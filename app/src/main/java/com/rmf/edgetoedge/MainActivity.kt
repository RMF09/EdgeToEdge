package com.rmf.edgetoedge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.WindowCompat
import com.rmf.edgetoedge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setFullscreen(window)
        lightStatusBar(window,false)
        setContentView(binding.root)

        binding.apply {
            btn.setOnClickListener {
                startActivity(Intent(this@MainActivity,SecondActivity::class.java))
            }

            btn2.setOnClickListener {
                startActivity(Intent(this@MainActivity,ThirdActivity::class.java))
            }

        }
    }
}