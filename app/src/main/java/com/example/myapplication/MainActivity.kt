package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // どのレイアウトファイルを使うかを設定する
        setContentView(R.layout.activity_main)

        // 登録ボタンを押した時の処理を書く
        register.setOnClickListener {
            Toast.makeText(this , "登録に成功しました", Toast.LENGTH_SHORT).show()
        }

        // 適当な画面をタップするとキーボードが消える
        content_layout.setOnClickListener{
            this.hideKeyboard()
        }

        // ラジオボタンをタップしてもキーボードが消える
        gender_group.setOnCheckedChangeListener { _, _ ->
            this.hideKeyboard()
        }
    }

    // キーボードが消えなかったので消す関数を追加
    private fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val manager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            manager.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }
}