package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val tv_show = findViewById<TextView>(R.id.tv_show)
        val btn_resend = findViewById<Button>(R.id.btn_resend)

        intent?.extras?.let{
            tv_show.text = it.getString("send")
        }

        // button 回傳回去給 main
        // 如果要 bundle 也可以，記得打包
        btn_resend.setOnClickListener {
            val re = "我點了 second 的 button"
            val intent = Intent()
            intent.putExtra("re", re)

            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}