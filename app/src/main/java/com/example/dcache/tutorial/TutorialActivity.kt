package com.example.dcache.tutorial

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.dcache.R
import dora.db.dao.DaoFactory

/**
 * 使用教程，希望使用了本框架的程序缘每天都是☀阳光灿烂☀，写代码零BUG或少BUG，早点下班，多陪家人。
 */
class TutorialActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
        val tvTutorial = findViewById<TextView>(R.id.tvTutorial)
        DaoFactory.getDao(Tutorial::class.java).insertOrUpdate(Tutorial("1. 《江南》——汉乐府民歌\n" +
                "江南可采莲，莲叶何田田。\n" +
                "鱼戏莲叶间。\n" +
                "鱼戏莲叶东，鱼戏莲叶西，\n" +
                "鱼戏莲叶南，鱼戏莲叶北。\n" +
                "\n" +
                "这首诗描绘了江南水乡采莲的美景，莲叶田田，鱼儿在叶间嬉戏，展现出一种欢快、自在的氛围。\n" +
                "\n" +
                "2. 《山中杂诗》——吴均\n" +
                "山际见来烟，竹中窥落日。\n" +
                "鸟向檐上飞，云从窗里出。\n" +
                "\n" +
                "这首诗用简洁的语言描绘了山中的清新景象，仿佛身处其中，感受到大自然的宁静和快乐。\n" +
                "\n" +
                "3. 《游园不值》——叶绍翁\n" +
                "应怜屐齿印苍苔，小扣柴扉久不开。\n" +
                "春色满园关不住，一枝红杏出墙来。\n" +
                "\n" +
                "这首诗描写了春日游园时的情景，虽未能入园，然而红杏出墙的景象却让人感受到春天生机勃勃的活力与快乐。\n" +
                "\n" +
                "4. 《春晓》——孟浩然\n" +
                "春眠不觉晓，处处闻啼鸟。\n" +
                "夜来风雨声，花落知多少。\n" +
                "\n" +
                "这首诗通过写“春眠不觉晓”传达了一种春日的慵懒和愉悦，鸟鸣声更增添了轻快的气氛。\n" +
                "\n" +
                "这些诗词都充满了轻松愉快的情感，让人感受到自然美景和生活的美好。"))
        val tutorial = DaoFactory.getDao(Tutorial::class.java).selectOne()
        tvTutorial.text = tutorial?.content
    }
}