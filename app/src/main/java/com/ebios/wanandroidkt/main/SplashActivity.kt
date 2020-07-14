package com.ebios.wanandroidkt.main

import android.content.Intent
import android.view.animation.AlphaAnimation
import android.widget.LinearLayout
import com.ebios.wanandroidkt.R
import com.ebios.wanandroidkt.base.BaseActivity

class SplashActivity :BaseActivity() {

//    private lateinit var logoLottieView: LottieAnimationView

    private lateinit var ll_splash: LinearLayout

    override fun getLayoutResId(): Int {
        return R.layout.activity_splash
    }
    override fun initView() {

        ll_splash= findViewById(R.id.ll_splash);
//        logoLottieView = findViewById(R.id.lav_logo)
//        logoLottieView.addAnimatorListener(object : Animator.AnimatorListener {
//            override fun onAnimationRepeat(animation: Animator?) {
//            }
//
//            override fun onAnimationCancel(animation: Animator?) {
//            }
//
//            override fun onAnimationStart(animation: Animator?) {
//            }
//
//            override fun onAnimationEnd(animation: Animator?) {
//
//            }
//        })
    }

    override fun initData() {
        super.initData()

       //渐变动画
        var animation= AlphaAnimation(1f, 1.0f)
        animation.duration=1500
        ll_splash.startAnimation(animation)

    }

    override fun onStart() {
        super.onStart()

      Thread({

          Thread.sleep(2000)
          startActivity(Intent(this@SplashActivity, MainActivity::class.java))
          finish()

      }).start()


    }





}