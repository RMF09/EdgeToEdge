package com.rmf.edgetoedge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import androidx.core.view.*
import com.rmf.edgetoedge.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        WindowCompat.setDecorFitsSystemWindows(window,false)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root){ view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())

            view.updateLayoutParams<ViewGroup.MarginLayoutParams>{
                this.updateMargins(left = insets.left, bottom = insets.bottom, right = insets.right)
            }


            WindowInsetsCompat.CONSUMED
        }
    }
}