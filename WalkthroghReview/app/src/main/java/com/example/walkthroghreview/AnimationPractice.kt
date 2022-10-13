package com.example.walkthroghreview

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.animation.TimeInterpolator
import android.os.Bundle
import android.util.Property
import android.view.View
import android.view.animation.LinearInterpolator
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_animation_practice.*


class AnimationPractice : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // scale or width
        setContentView(R.layout.activity_animation_practice)
        animateBtn1.setOnClickListener {
            // Move to another another place
//            val animation = ObjectAnimator.ofFloat(animateBtn1, "translationY", 1000f)

            // Move to target place
            val animation = ObjectAnimator.ofFloat(animateBtn1, View.TRANSLATION_Y, animateBtn1.translationY, target.translationY, 1000f)

            animation.duration = 4000
            animation.interpolator = LinearInterpolator()
            animation.addListener(object : AnimatorListenerAdapter() {

                override fun onAnimationStart(animator: Animator?) {}

                override fun onAnimationEnd(animator: Animator?) {}

                override fun onAnimationCancel(animator: Animator?) {}

                override fun onAnimationRepeat(animator: Animator?) {}
            })
            animation.start()

        }

        animateBtn2.setOnClickListener {
            val animation = ObjectAnimator.ofFloat(animateBtn2, "translationZ", 300f)
            animation.duration = 4000
            animation.start()
        }
        target.setOnClickListener {
            Toast.makeText(this@AnimationPractice, animateBtn2.x.toString(), Toast.LENGTH_SHORT).show()
        }
//        tabStrip.animate().translationX(tabArray[position].x).duration =
//        val animation = ObjectAnimator.ofFloat(view, "translationY", 1300f)
//        animation.duration = 4000
    }

    fun animationFunction(target: View, property: Property<View, Float>, from: Float, to: Float, duration : Long, interpolator: TimeInterpolator){
        val animation = ObjectAnimator.ofFloat(target, property, from, to, 1000f)

        animation.duration = duration
        animation.interpolator = interpolator
        animation.addListener(object : AnimatorListenerAdapter() {

            override fun onAnimationStart(animator: Animator?) {}

            override fun onAnimationEnd(animator: Animator?) {}

            override fun onAnimationCancel(animator: Animator?) {}

            override fun onAnimationRepeat(animator: Animator?) {}
        })
        animation.start()
    }
}