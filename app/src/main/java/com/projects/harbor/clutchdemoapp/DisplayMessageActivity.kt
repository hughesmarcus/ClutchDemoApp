package com.projects.harbor.clutchdemoapp

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.view.View
import android.widget.TextView
import com.projects.harbor.clutchdemoapp.R.layout.activity_display_message
import android.widget.RelativeLayout



class DisplayMessageActivity : AppCompatActivity() {
    val colors = intArrayOf(Color.GRAY,Color.BLUE,Color.CYAN,Color.WHITE,Color.GREEN)
    var prefs: Prefs? = null
    lateinit var l:ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)
         l = findViewById<ConstraintLayout>(R.id.layout)
        val message = intent.getStringExtra(EXTRA_MESSAGE)

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

        prefs = Prefs(this)
        val bgColor = prefs!!.bgColor
        l.setBackgroundColor(colors[bgColor])


    }

   fun selectColor(view: View) {
       when {
           prefs!!.bgColor == colors.size-1 -> {
               l.setBackgroundColor(colors[0])
               prefs!!.bgColor = 0
           }
           else -> {
               val index = prefs!!.bgColor + 1
               l.setBackgroundColor(colors[index])
               prefs!!.bgColor = index
           }
       }
    }
}
