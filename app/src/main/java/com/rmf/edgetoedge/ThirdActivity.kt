package com.rmf.edgetoedge

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.rmf.edgetoedge.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        setFullscreen(window)
        lightStatusBar(window)
        setContentView(binding.root)


        sheetBehavior = BottomSheetBehavior.from(binding.incBs.bottomSheet)


        ViewCompat.setOnApplyWindowInsetsListener(binding.root){ view, windowInsets ->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
            view.updateLayoutParams<ViewGroup.MarginLayoutParams>{
                this.updateMargins(left = insets.left, bottom = insets.bottom, right = insets.right)
            }

            WindowInsetsCompat.CONSUMED
        }

        ViewCompat.setOnApplyWindowInsetsListener(binding.incBs.bottomSheet){ view, windowInsets->
            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemGestures())
            view.updatePadding(insets.left,insets.top, insets.right, insets.bottom)

            WindowInsetsCompat.CONSUMED
        }


    }
}