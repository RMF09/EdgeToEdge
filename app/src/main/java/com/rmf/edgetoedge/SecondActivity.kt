package com.rmf.edgetoedge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.*
import com.rmf.edgetoedge.databinding.ActivitySecondBinding
import dev.chrisbanes.insetter.applyInsetter

class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setFullscreen(window)
        lightStatusBar(window)
        setContentView(binding.root)



//        val toolbarTopPadding = binding.toolbar.paddingTop
//
//        ViewCompat.setOnApplyWindowInsetsListener(binding.fab) { view, windowInsets ->
//            val insets = windowInsets.getInsets(WindowInsetsCompat.Type.navigationBars())
//
//            view.updateLayoutParams<ViewGroup.MarginLayoutParams> {
//                this.updateMargins(
//                    left = insets.left,
//                    bottom = insets.bottom + 40,
//                    right = insets.right + view.marginEnd
//                )
//
//            }
//            //update toolbar
//            val insetsSB = windowInsets.getInsets(WindowInsetsCompat.Type.statusBars())
//            val newToolbarTopPadding = insetsSB.top + toolbarTopPadding
//            binding.toolbar.updatePadding(top = newToolbarTopPadding+40, bottom= 60)
//
//
//            WindowInsetsCompat.CONSUMED
//        }
        binding.apply {
            setSupportActionBar(toolbar)
            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            toolbar.applyInsetter {
                type(statusBars = true){
                    padding()
                }
            }

            fab.applyInsetter {
                type(navigationBars = true ){
                    margin()
                }
            }
        }
    }
}