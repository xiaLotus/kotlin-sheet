package com.example.myapplication

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<TextView>(R.id.ed_name)
        val tv_name = findViewById<EditText>(R.id.ed_name)
        val btn_a = findViewById<Button>(R.id.btn_a)
        val btn_b = findViewById<Button>(R.id.btn_b)
        val btn_c = findViewById<Button>(R.id.btn_c)
        val btn_check = findViewById<Button>(R.id.btn_check)
        val ed_retrun = findViewById<TextView>(R.id.ed_return)


        btn_check.setOnClickListener {
            if(tv_name.length() < 0){
                ed_retrun.text = "請輸入一些字"
                return@setOnClickListener
            }
            val people = tv_name.text

            // 這裡也很隨意
            val rand = (Math.random() * 3).toInt()

            val matchText = when{
                btn_a.isClickable -> "輸入 a"
                btn_b.isClickable -> "輸入 b"
                else -> "這裡是 c"
            }
            // 其實這裡可以不用，只是拿剪刀石頭布那個改改而已。
            val compareText = when(rand) {
                0 -> "a"
                1 -> "b"
                else -> "c"
            }

            when{
                btn_check.isClickable && rand == 0 -> {
                    ed_retrun.text = "a"
                }
                btn_check.isClickable && rand == 1 -> {
                    ed_retrun.text = "b"
                }
                else -> {
                    ed_retrun.text = "c"
                }
            }
        }
    }
}