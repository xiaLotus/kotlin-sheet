# Activity

### 建立檔案
![](https://i.imgur.com/1e7S19m.png)
建立你的第二個可供傳遞的檔案

## 首頁
先簡單的排個版，這裡只有單方面傳遞，雙方的話請往下滑
![](https://i.imgur.com/kLMhULB.png)

ok，來寫一下程式碼
```kotlin=
// main
val ed_name = findViewById<EditText>(R.id.ed_name)
val btn_send = findViewById<Button>(R.id.btn_send)

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
}
```
## 第二頁
如果沒問題，就開另一個xml排版，簡單就好。

![](https://i.imgur.com/DP7Qp9f.png)

一樣，撰寫程式碼。這裡我的名字是 MainActivity2，這是預設的，可以不用動。
程式碼的部分就簡單許多。
```kotlin=
// second
val tv_show = findViewById<TextView>(R.id.tv_show)

intent?.extras?.let{
    tv_show.text = it.getString("send")
}
```

## 那來回互傳呢？
一樣，我們給定一個 `Textview` 在main 這邊，second 給一個 `button`

直接來撰寫 main
```kotlin=
val tv_receive = findViewById<TextView>(R.id.tv_receive)

val getResult =
    // 確定回傳的是 0 or 1
    registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()){
        if(it.resultCode == Activity.RESULT_OK){
            val example = it.data?.getStringExtra("re")
            tv_receive.text = "這裡接收到了~"
        }else{
            tv_receive.text = "沒收到"
        }
    }

```
最後，注意，這個必須包在 btn_send的click事件裡面。
```kotlin=
getResult.launch(intent)
```

接著是 second 的部分
```kotlin=
val btn_resend = findViewById<Button>(R.id.btn_resend)

// intent...

// button 回傳回去給 main
// 如果要 bundle 也可以，記得打包
btn_resend.setOnClickListener {
    val re = "我點了 second 的 button"
    val intent = Intent()
    intent.putExtra("re", re)

    setResult(Activity.RESULT_OK, intent)
    finish()
}
```

### 運行圖如下
* 輸入任意文字，點擊 button。
![](https://i.imgur.com/UWiG67d.png)
* 按下回傳
![](https://i.imgur.com/Y4Ieznb.png)
* 這裡接收到後，會顯示 if/else 的 text 預設。
![](https://i.imgur.com/SzA9jMD.png)
