package com.example.dcache.orm

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.dcache.R
import dora.db.dao.DaoFactory
import dora.util.IntentUtils
import dora.util.ToastUtils
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItemGroup

class ComplexDataTypeTestActivity : AppCompatActivity() {

    private var models: List<TestCaseModel3> = arrayListOf()
    private lateinit var menuPanel: MenuPanel

    private fun refreshModels() {
        models = DaoFactory.getDao(TestCaseModel3::class.java).selectAll()
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
            val model = data?.let { IntentUtils.getSerializableExtra(it, "model") } as TestCaseModel
            if (requestCode == 0) {
                val model3 = TestCaseModel3()
                model3.model = model
                if (DaoFactory.getDao(TestCaseModel3::class.java).insert(model3)) {
                    ToastUtils.showShort("添加成功")
                    setResult(Activity.RESULT_OK)
                    finish()
                } else {
                    ToastUtils.showShort("添加失败")
                }
            }
            refreshModels()
        }
    }

    private fun getMenuPanelItems(): Array<SwipeMenuPanelItem2> {
        val list = mutableListOf<SwipeMenuPanelItem2>()
        models.forEach {
            val item = SwipeMenuPanelItem2("", it)
            item.setItemListener(object : SwipeMenuPanelItem2.ItemListener {

                override fun onClick(model: TestCaseModel3) {
                }

                override fun onDelete(model: TestCaseModel3, item: SwipeMenuPanelItem2) {
                    if (DaoFactory.getDao(TestCaseModel3::class.java).delete(model)) {
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
        setContentView(R.layout.activity_complex_data_type_test)
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