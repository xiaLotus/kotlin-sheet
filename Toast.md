# Toast

### 更改
我們先來到 design 旁邊的 code 改改程式碼。
```xml=
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Hello World!"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

</LinearLayout>
```

這邊我們使用`LinearLayout`。
接著，一樣排版。
![](https://i.imgur.com/SgkYvtt.png)
不想排就把這個貼上去。
```xml=
    <Button
        android:id="@+id/btn_toast"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="預設 Toast" />

    <Button
        android:id="@+id/btn_custom"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="自訂義 Toast" />

    <Button
        android:id="@+id/btn_snackbar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="按鈕式 Snackbar" />

    <Button
        android:id="@+id/btn_dialog1"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="按鈕式 AlertDialog" />

    <Button
        android:id="@+id/btn_dialog2"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="列表式 AlertDialog" />

    <Button
        android:id="@+id/btn_dialog3"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="單選式 AlertDialog" />
```

#### Toast
一樣，先寫入。
```kotlin=
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_toast = findViewById<Button>(R.id.btn_toast)

        btn_toast.setOnClickListener {
            showToast("這裡是 Toast")
        }
    }

    private fun showToast(s: String) {
        Toast.makeText(this, s, Toast.LENGTH_SHORT)
            .show()
    }
}
```
這裡可以先運行。
[`運行不出來嗎?`](https://blog.csdn.net/qq_33505109/article/details/85001074)，放心我也不行。
如果要的話可以自己開一個 second 去看一下....
來寫寫吧。

先開一個 second。
開啟的方式，在上個章節有喔。
```kotlin=
// main
val btn_toast = findViewById<Button>(R.id.btn_toast)

btn_toast.setOnClickListener {
    val intent = Intent(this, MainActivity2::class.java)
}
```
```kotlin=
// second
intent?.extras?.let{
    Toast.makeText(this@MainActivity2, "這裡顯示Toast", Toast.LENGTH_LONG).show()
}
```

[`還是出不來?`](https://blog.csdn.net/qq_33505109/article/details/85001074)

那就先放棄.jpg。
應該是權限問題吧。

#### Snackbar
```kotlin=
// ...
val btn_snackbar = findViewById<Button>(R.id.btn_snackbar)
// ...
btn_snackbar.setOnClickListener {
    Snackbar.make(it, "這裡是Button", Snackbar.LENGTH_LONG)
        .setAction("按鈕"){
            Toast.makeText(this, "Button", Toast.LENGTH_LONG).show()
        }.show()
}
```
這樣就出來了，有點神奇。
應該也不是說不支援 Toast 才對吧？

#### AlertDialog
這裡一樣可以包 Toast
```kotlin=
// ...
val btn_exit = findViewById<Button>(R.id.btn_dialog3)
// ...
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
```
* 這裡是離開。
![](https://i.imgur.com/vXX5YTC.png)
* 這裡是按下返回後的樣子。
![](https://i.imgur.com/KodxVYi.png)
