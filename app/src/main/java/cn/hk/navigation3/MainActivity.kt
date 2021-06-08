package cn.hk.navigation3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

/**
 * kotlin_jetpack_navigation
 * 使用navigation  + dataBinding + viewModel
 * 三个fragment共享一个viewModel中的数据，在NavigationView中显示
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}