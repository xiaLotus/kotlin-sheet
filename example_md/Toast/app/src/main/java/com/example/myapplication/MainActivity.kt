package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_toast = findViewById<Button>(R.id.btn_toast)
        val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
        val btn_exit = findViewById<Button>(R.id.btn_dialog3)

        btn_toast.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
        }

        btn_snackbar.setOnClickListener {
            Snackbar.make(it, "這裡是Button", Snackbar.LENGTH_LONG)
                .setAction("按鈕"){
                    Toast.makeText(this, "Button", Toast.LENGTH_LONG).show()
                }.show()
        }
        btn_exit.setOnClickListener {
            AlertDialog.Builder(this@MainActivity)
                .setTitle("離開")
                .setMessage("確定離開")
                .setPositiveButton("確定"){dialog, which ->
                    finish()
                }
                .setNegativeButton("返回"){dialog, which ->
                    Toast.makeText(this, "哈哈", Toast.LENGTH_LONG)
                        .show()
                }
                .show()
        }
    }
}