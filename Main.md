# Main

打開後是這樣子的。
![](https://i.imgur.com/3rjMoQY.png)




## 版面配置
直接開始吧。

延展，從下圖可知上與下差了20dp的距離(對齊藍色小點點~)
![](https://i.imgur.com/hCmLUWM.png)

先簡單用一個版面，這邊可以看到我們的 radioGroup 裡面有三個 button。
想要橫向，可以使用 `android:orientation="horizontal"`
由上而下的話，使用 `android:orientation="vertical"`
![](https://i.imgur.com/jGzgaxH.png)


切換到 code
![](https://i.imgur.com/oKmyA3t.png)

一切 ok ，我們可以開始動作了。
[`參考`](https://blog.csdn.net/MrZhang_happy/article/details/48436105)


## textview布局 和 命名
這裡使用 `plain view`，唯一要注意的是 `hint` 的部分
![](https://i.imgur.com/kvlEkEd.png)

請注意圖片左下角的部分
![](https://i.imgur.com/CSdTqU7.png)


命名的話依照自己的喜好命名即可。

## 監聽 與 回傳
我們回到 `MainActivity.kt` 寫作。
第一，我們要去接收。
```kotlin=
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
    }
}
```

再來，使用 button 監聽...當然也可以加上額外的動作。
```kotlin=
btn_check.setOnClickListener {
    if(tv_name.length() < 0){
        ed_retrun.text = "請輸入一些字"
        return@setOnClickListener
        }
        val people = tv_name.text


        val rand = (Math.random() * 3).toInt()
```


其實沒有很複雜，記得轉成 String 
```kotlin=
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
```
記得括號
