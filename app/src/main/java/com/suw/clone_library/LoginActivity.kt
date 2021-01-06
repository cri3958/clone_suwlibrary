package com.suw.clone_library

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.io.File
import java.io.FileInputStream

class LoginActivity : AppCompatActivity() {
    val fileName:String = "data_autologin.txt"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        login_btn_home.setOnClickListener { gohome() }

        login_edittext_id.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                login_textview_warningid.visibility = View.INVISIBLE
                login_textview_warningid.setTextSize(0, 1F)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(login_edittext_id.text.isEmpty()){
                    login_textview_warningid.visibility = View.VISIBLE
                    login_textview_warningid.setTextSize(0, 48F)
                } else{
                    login_textview_warningid.visibility = View.INVISIBLE
                    login_textview_warningid.setTextSize(0, 1F)
                }
            }
        })

        login_edittext_pw.addTextChangedListener(object : TextWatcher{
            override fun afterTextChanged(p0: Editable?) {

            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                login_textview_warningpw.visibility = View.INVISIBLE
                login_textview_warningpw.setTextSize(0, 1F)
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if(login_edittext_pw.text.isEmpty()){
                    login_textview_warningpw.visibility = View.VISIBLE
                    login_textview_warningpw.setTextSize(0, 48F)
                } else{
                    login_textview_warningpw.visibility = View.INVISIBLE
                    login_textview_warningpw.setTextSize(0, 1F)
                }
            }
        })

        login_btn_login.setOnClickListener{
            if(login_edittext_id.text.isEmpty()||login_edittext_pw.text.isEmpty())
                Toast.makeText(applicationContext,"아이디와 비밀번호를 모두 입력하세요.",Toast.LENGTH_SHORT).show()
            else if(login_switch_autologin.isChecked==true) {
                Toast.makeText(applicationContext, "로그인 되었습니다. with 자동로그인", Toast.LENGTH_SHORT).show()
                val outFs = openFileOutput(fileName, Context.MODE_PRIVATE)
                val str: String = login_edittext_id.text.toString()+ "@" + login_edittext_pw.text.toString()+"@"
                outFs.write(str.toByteArray())
                outFs.close()
                gohome()
            }
            else {
                Toast.makeText(applicationContext, "로그인 되었습니다.", Toast.LENGTH_SHORT).show()
                gohome()
            }
        }

        val file = File("/data/data/com.suw.clone_library/files/"+fileName)
        if(file.exists()){
            val inFs:FileInputStream = openFileInput(fileName)
            val txt = ByteArray(500)
            inFs.read(txt)
            val fdata = String(txt).trim().split("@")
            login_edittext_id.setText(fdata[0])
            login_edittext_pw.setText(fdata[1])
        }
    }
    fun gohome(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}