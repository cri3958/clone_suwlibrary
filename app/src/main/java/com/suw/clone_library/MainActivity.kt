package com.suw.clone_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.io.File

class MainActivity : AppCompatActivity(){
    val fileName:String = "data_autologin.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_navigation_left.setWidth1(changeDP(1))
        main_navigation_left.setVisibility(View.INVISIBLE)
        var isleftnavopen = false


        val file = File("/data/data/com.suw.clone_library/files/"+fileName)
        if(file.exists()){
            main_btn_login.visibility = View.INVISIBLE
            main_btn_dashboard.visibility = View.VISIBLE
        }

        main_btn_login.setOnClickListener { startActivity(Intent(this,LoginActivity::class.java)) }

        main_btn_dashboard.setOnClickListener{
            if(isleftnavopen){
                main_navigation_left.setWidth1(changeDP(1))
                main_navigation_left.setVisibility(View.INVISIBLE)
                isleftnavopen = false
            }else{
                main_navigation_left.setWidth1(changeDP(240))
                main_navigation_left.setVisibility(View.VISIBLE)
                isleftnavopen = true
            }
        }
        scrollview.setOnTouchListener { _: View, event: MotionEvent ->true}

        nav_item_1.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text1,Toast.LENGTH_SHORT).show() }
        nav_item_2.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text2,Toast.LENGTH_SHORT).show() }
        nav_item_3.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text3,Toast.LENGTH_SHORT).show() }
        nav_item_4.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text4,Toast.LENGTH_SHORT).show() }
        nav_item_5.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text5,Toast.LENGTH_SHORT).show() }
        nav_item_6.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text6,Toast.LENGTH_SHORT).show() }
        nav_item_7.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text7,Toast.LENGTH_SHORT).show() }
        nav_item_8.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text8,Toast.LENGTH_SHORT).show() }
        nav_item_9.setOnClickListener { Toast.makeText(applicationContext,R.string.main_navigationview_text9,Toast.LENGTH_SHORT).show() }
        nav_item_10.setOnClickListener {
            val file = File("/data/data/com.suw.clone_library/files/"+fileName)
            file.delete()
            finishAffinity()
            val intent:Intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            Toast.makeText(applicationContext,R.string.main_navigationview_toast,Toast.LENGTH_SHORT).show()
        }
    }
    private fun changeDP(value : Int) : Int{
        var displayMetrics = resources.displayMetrics
        var dp = Math.round(value * displayMetrics.density)
        return dp
    }
    fun View.setWidth1(value: Int) {
        val lp = layoutParams
        lp?.let {
            lp.width = value
            layoutParams = lp
        }
    }

}