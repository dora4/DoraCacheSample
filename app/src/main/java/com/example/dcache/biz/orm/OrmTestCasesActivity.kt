package com.example.dcache.biz.orm

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dcache.R
import dora.widget.panel.MenuPanel
import dora.widget.panel.MenuPanelItem
import dora.widget.panel.menu.NormalMenuPanelItem

class OrmTestCasesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orm_test_cases)
        val menuPanel = findViewById<MenuPanel>(R.id.menuPanel)
        menuPanel.addMenu(NormalMenuPanelItem(text = "基本数据类型测试"))
        menuPanel.addMenu(NormalMenuPanelItem(text = "写入性能测试"))
        menuPanel.addMenu(NormalMenuPanelItem(text = "读取性能测试"))
        menuPanel.addMenu(NormalMenuPanelItem(text = "复杂数据类型测试"))
        menuPanel.setOnPanelMenuClickListener(object : MenuPanel.OnPanelMenuClickListener {
            override fun onMenuClick(
                position: Int,
                view: View,
                menuName: String,
                item: MenuPanelItem
            ) {
                when (position) {
                    0 -> {
                        val intent = Intent(this@OrmTestCasesActivity,
                            BasicDataTypeTestActivity::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this@OrmTestCasesActivity,
                            OrmWriteTestActivity::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@OrmTestCasesActivity,
                            OrmReadTestActivity::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@OrmTestCasesActivity,
                            ComplexDataTypeTestActivity::class.java)
                        startActivity(intent)
                    }
                }
            }
        })
    }
}