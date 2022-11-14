package com.example.myapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val ed_name = findViewById<EditText>(R.id.ed_name)
        val btn_send = findViewById<Button>(R.id.btn_send)
        val tv_receive = findViewById<TextView>(R.id.tv_receive)

        val getResult =
            registerForActivityResult(
                ActivityResultContracts.StartActivityForResult()){
                if(it.resultCode == Activity.RESULT_OK){
                    val example = it.data?.getStringExtra("re")
                    tv_receive.text = "這裡接收到了~"
                }else{
                    tv_receive.text = "沒收到"
                }
            }


        btn_send.setOnClickListener {
            if (ed_name.length() < 1){
                return@setOnClickListener
            }
            // 也可以有
            val name = ed_name.text.toString()
            val bundle = Bundle()
            // 寫法是 key, 值
            // bundle.putString("send", ed_name.text.toString())
            bundle.putString("send", name)

            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtras(bundle)
            startActivity(intent)

            getResult.launch(intent)
        }

    }
}