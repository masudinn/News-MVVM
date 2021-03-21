package com.masudinn.news_app.core.platform

import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import androidx.annotation.LayoutRes
import androidx.lifecycle.Observer
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.masudinn.news_app.core.Utils.hideKeyboard
import com.masudinn.news_app.core.Utils.hideWait
import com.masudinn.news_app.core.Utils.showWait
import dagger.android.support.DaggerAppCompatActivity


abstract class BaseActivity<B : ViewDataBinding> constructor(
    @LayoutRes val layoutRes: Int,
    private val isFullScreen: Boolean = false
): DaggerAppCompatActivity() {

    protected lateinit var binding: B

    protected open fun bindView() {
        binding = DataBindingUtil.setContentView(this, layoutRes)
    }

    protected val loadingObserver by lazy {
        Observer<Boolean> { isLoading -> if (isLoading) showWait() else hideWait() }
    }

    fun setFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        val decorView = window.decorView
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
//        }
//        if (isFullScreen) setFullScreen()
        bindView()
    }

    override fun onStop() {
        super.onStop()
        hideWait()
        hideKeyboard()
    }

}