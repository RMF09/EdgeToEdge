package com.rmf.edgetoedge

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.*
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.rmf.edgetoedge.databinding.ActivityThirdBinding
import com.rmf.edgetoedge.databinding.BottomSheetBinding

class ThirdActivity : AppCompatActivity() {

    private lateinit var binding: ActivityThirdBinding

    private lateinit var sheetBehavior: BottomSheetBehavior<View>

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)

        setFullscreen(window)
        lightStatusBar(window)
        setContentView(binding.root)


        sheetBehavior = BottomSheetBehavior.from(binding.incBss.bottomSheet)
        val peekHeightOriginal = sheetBehavior.peekHeight
        val pbBottomSheetOriginal = binding.incBss.bottomSheet.paddingBottom


        ViewCompat.setOnApplyWindowInsetsListener(binding.incBss.bottomSheet) { view, windowInsets ->
//            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemBars())
//           /* view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
//                this.updateMargins(left = insets.left, bottom = insets.bottom, right = insets.right)
//            }*/


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                val insetsS = windowInsets.getInsets(WindowInsetsCompat.Type.systemGestures())

//                sheetBehavior.peekHeight = 0
                view.updatePadding(
                    binding.incBss.bottomSheet.paddingLeft,
                    binding.incBss.bottomSheet.paddingTop,
                    binding.incBss.bottomSheet.paddingRight,
                    insetsS.bottom +  pbBottomSheetOriginal
                )
                binding.text.text = " sad : ${insetsS.left}, ${insetsS.right}, ${insetsS.bottom}"
                binding.incBss.linearContent.updateLayoutParams<ViewGroup.MarginLayoutParams> {
                    this.updateMargins(top = insetsS.bottom + pbBottomSheetOriginal)
                }

            }

            WindowInsetsCompat.CONSUMED
        }

        /* ViewCompat.setOnApplyWindowInsetsListener(binding.incBss.bottomSheet) { view, windowInsets ->
             val insets = windowInsets.getInsets(WindowInsetsCompat.Type.systemGestures())
             view.updatePadding(insets.left, insets.top, insets.right, insets.bottom)
             binding.text.text = " sad : ${insets.left}, ${insets.right}, ${insets.bottom}"

             WindowInsetsCompat.CONSUMED
         }*/


    }
}