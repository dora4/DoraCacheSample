package com.example.dcache.orm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dcache.R
import dora.db.dao.DaoFactory
import dora.util.ToastUtils
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItemGroup

class BasicDataTypeTestActivity : AppCompatActivity() {

    private var models: List<TestCaseModel> = arrayListOf()
    private lateinit var menuPanel: MenuPanel

    private fun refreshModels() {
        models = DaoFactory.getDao(TestCaseModel::class.java).selectAll()
        menuPanel
            .clearAll()
            .addMenuGroup(
            MenuPanelItemGroup(
                items = getMenuPanelItems()
            )
        )
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            val model = data?.getSerializableExtra("model") as TestCaseModel
            if (requestCode == 0) {
                if (DaoFactory.getDao(TestCaseModel::class.java).insert(model)) {
                    ToastUtils.showShort("添加成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("添加失败")
                }
            }
            if (requestCode == 1) {
                if (DaoFactory.getDao(TestCaseModel::class.java).update(model)) {
                    ToastUtils.showShort("编辑成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("编辑失败")
                }
            }
            refreshModels()
        }
    }

    private fun getMenuPanelItems(): Array<SwipeMenuPanelItem> {
        val list = mutableListOf<SwipeMenuPanelItem>()
        models.forEach {
            val item = SwipeMenuPanelItem("", it)
            item.setItemListener(object : SwipeMenuPanelItem.ItemListener {

                override fun onClick(model: TestCaseModel) {
                    val intent = Intent(this@BasicDataTypeTestActivity, OrmModelEditorActivity::class.java)
                    intent.action = "ACTION_UPDATE"
                    intent.putExtra("model", model)
                    startActivityForResult(intent, 1)
                }

                override fun onDelete(model: TestCaseModel, item: SwipeMenuPanelItem) {
                    if (DaoFactory.getDao(TestCaseModel::class.java).delete(model)) {
                        ToastUtils.showShort("删除成功")
                        menuPanel.removeItem(item)
                    } else {
                        ToastUtils.showShort("删除失败")
                    }
                }
            })
            list.add(item)
        }
        return list.toTypedArray()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basic_data_type_test)
        menuPanel = findViewById(R.id.menuPanel)
        val tvAdd = findViewById<TextView>(R.id.tvAdd)
        tvAdd.setOnClickListener {
            val intent = Intent(this, OrmModelEditorActivity::class.java)
            intent.action = "ACTION_ADD"
            startActivityForResult(intent, 0)
        }
        refreshModels()
    }
}