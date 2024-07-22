package com.example.dcache.biz.orm

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.content.ContextCompat
import com.example.dcache.R
import dora.db.dao.DaoFactory
import dora.util.DensityUtils
import dora.util.ToastUtils
import dora.util.ViewUtils
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItem
import dora.widget.panel.menu.ButtonMenuPanelItem
import dora.widget.panel.menu.InputMenuPanelItem

class OrmModelEditorActivity : AppCompatActivity() {

    private var isOpen: Boolean = false
    private var model: TestCaseModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orm_model_editor)
        model = intent.getSerializableExtra("model") as TestCaseModel?
        isOpen = model?.booleanVal ?: false
        val menuPanel = findViewById<MenuPanel>(R.id.menuPanel)
        menuPanel
            .addMenu(
                InputMenuPanelItem(
                    title = "String",
                    hint = "输入字符串",
                    content = model?.stringVal
                )
            )
            .addMenu(ToggleButtonMenuPanelItem(ToggleButtonEntity(
                "布尔值开关",
                isOpen,
                object : ToggleButtonEntity.OnSelectListener {
                    override fun onSelect(
                        item: ToggleButtonMenuPanelItem,
                        select: Boolean
                    ) {
                        isOpen = select
                    }
                }), "Boolean"))
            .addMenu(
                InputMenuPanelItem(
                    title = "短整形",
                    hint = "输入short值",
                    content = model?.shortVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "整数型",
                    hint = "输入int值",
                    content = model?.intVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "长整形",
                    hint = "输入long值",
                    content = model?.longVal?.toString() ?: "0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "单精度浮点型",
                    hint = "输入float值",
                    content = model?.floatVal?.toString() ?: "0.0"
                )
            )
            .addMenu(
                InputMenuPanelItem(
                    title = "双精度浮点型",
                    hint = "输入double值",
                    content = model?.doubleVal?.toString() ?: "0.0"
                )
            )
            .addMenu(
                ButtonMenuPanelItem(marginTop = DensityUtils.DP10, menuName = "save", text = "保存",
                textColor = ContextCompat.getColor(this, R.color.colorPrimary))
            )
        menuPanel.setOnPanelMenuClickListener(object : MenuPanel.OnPanelMenuClickListener {

            override fun onMenuClick(
                position: Int,
                view: View,
                menuName: String,
                item: MenuPanelItem
            ) {
                if (menuName == "save") {
                    if (intent.action == "ACTION_UPDATE") {
                        val testCaseModel = model!!
                        testCaseModel.stringVal = ViewUtils.getText(menuPanel.getViewByPosition(0,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText)
                        testCaseModel.booleanVal = isOpen
                        testCaseModel.shortVal = ViewUtils.getText(menuPanel.getViewByPosition(2,
                        InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toShort()
                        testCaseModel.intVal = ViewUtils.getText(menuPanel.getViewByPosition(3,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toInt()
                        testCaseModel.longVal = ViewUtils.getText(menuPanel.getViewByPosition(4,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toLong()
                        testCaseModel.floatVal = ViewUtils.getText(menuPanel.getViewByPosition(5,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toFloat()
                        testCaseModel.doubleVal = ViewUtils.getText(menuPanel.getViewByPosition(6,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toDouble()
                        if (DaoFactory.getDao(TestCaseModel::class.java).update(testCaseModel)) {
                            ToastUtils.showShort("编辑成功")
                            setResult(Activity.RESULT_OK)
                            finish()
                        } else {
                            ToastUtils.showShort("编辑失败")
                        }
                    } else {
                        val testCaseModel = TestCaseModel(menuName = MenuPanelItem.generateMenuName())
                        testCaseModel.stringVal = ViewUtils.getText(menuPanel.getViewByPosition(0,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText)
                        testCaseModel.booleanVal = isOpen
                        testCaseModel.shortVal = ViewUtils.getText(menuPanel.getViewByPosition(2,
                        InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toShort()
                        testCaseModel.intVal = ViewUtils.getText(menuPanel.getViewByPosition(3,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toInt()
                        testCaseModel.longVal = ViewUtils.getText(menuPanel.getViewByPosition(4,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toLong()
                        testCaseModel.floatVal = ViewUtils.getText(menuPanel.getViewByPosition(5,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toFloat()
                        testCaseModel.doubleVal = ViewUtils.getText(menuPanel.getViewByPosition(6,
                            InputMenuPanelItem.ID_EDIT_TEXT_INPUT) as EditText).toDouble()
                        if (DaoFactory.getDao(TestCaseModel::class.java).insert(testCaseModel)) {
                            ToastUtils.showShort("添加成功")
                            setResult(Activity.RESULT_OK)
                            finish()
                        } else {
                            ToastUtils.showShort("添加失败")
                        }
                    }
                }
            }
        })
    }
}