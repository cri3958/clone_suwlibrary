package com.suw.clone_library

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_main_layout.*
import java.io.File

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    val fileName:String = "data_autologin.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = File("/data/data/com.suw.clone_library/files/"+fileName)
        if(file.exists()){
            main_btn_login.visibility = View.INVISIBLE
            main_btn_dashboard.visibility = View.VISIBLE
        }

        main_btn_login.setOnClickListener { startActivity(Intent(this,LoginActivity::class.java)) }

        main_btn_dashboard.setOnClickListener{
            mainlayout.openDrawer(GravityCompat.START)
        }
        main_navigationview.setNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_item_1 -> Toast.makeText(applicationContext,R.string.main_navigationview_text1,Toast.LENGTH_SHORT).show()
            R.id.nav_item_2 -> Toast.makeText(applicationContext,R.string.main_navigationview_text2,Toast.LENGTH_SHORT).show()
            R.id.nav_item_3 -> Toast.makeText(applicationContext,R.string.main_navigationview_text3,Toast.LENGTH_SHORT).show()
            R.id.nav_item_4 -> Toast.makeText(applicationContext,R.string.main_navigationview_text4,Toast.LENGTH_SHORT).show()
            R.id.nav_item_5 -> Toast.makeText(applicationContext,R.string.main_navigationview_text5,Toast.LENGTH_SHORT).show()
            R.id.nav_item_6 -> Toast.makeText(applicationContext,R.string.main_navigationview_text6,Toast.LENGTH_SHORT).show()
            R.id.nav_item_7 -> Toast.makeText(applicationContext,R.string.main_navigationview_text7,Toast.LENGTH_SHORT).show()
            R.id.nav_item_8 -> Toast.makeText(applicationContext,R.string.main_navigationview_text8,Toast.LENGTH_SHORT).show()
            R.id.nav_item_9 -> Toast.makeText(applicationContext,R.string.main_navigationview_text9,Toast.LENGTH_SHORT).show()
            R.id.nav_item_10 -> {
                val file = File("/data/data/com.suw.clone_library/files/"+fileName)
                file.delete()
                finishAffinity()
                val intent:Intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                Toast.makeText(applicationContext,R.string.main_navigationview_toast,Toast.LENGTH_SHORT).show()
            }
        }
        mainlayout.closeDrawers()
        return false
    }


}