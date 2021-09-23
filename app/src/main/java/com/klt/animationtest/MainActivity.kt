package com.klt.animationtest

import android.graphics.drawable.Animatable
import android.graphics.drawable.AnimatedVectorDrawable
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat

class MainActivity : AppCompatActivity() {

    lateinit var tv : TextView
    lateinit var btn : Button
    private lateinit var img1 : ImageView
    lateinit var img2 : ImageView
    private lateinit var fadeInAnim : Animation
    lateinit var fadeOutAnim : Animation
    lateinit var rotateAnim : Animation
    lateinit var blinkAnim : Animation
    lateinit var bounceAnim : Animation
    lateinit var moveAnim : Animation
    lateinit var zoomInAnim : Animation
    lateinit var zoomOutAnim : Animation
    lateinit var drawableAnim : AnimationDrawable
    lateinit var vectorDrawableAnimGreater25 : AnimatedVectorDrawable
    private var vectorDrawableAnimLess21 : AnimatedVectorDrawableCompat? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn)
        tv = findViewById(R.id.txt)
        img1 = findViewById(R.id.img1)
        img2 = findViewById(R.id.img2)
        fadeInAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_in)
        fadeOutAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.fade_out)
        rotateAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.rotate_clockwise)
        blinkAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        bounceAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.bounce)
        moveAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.move)
        zoomInAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom_in)
        zoomOutAnim = AnimationUtils.loadAnimation(applicationContext,R.anim.zoom_out)


        vectorDrawableAnimLess21 = AnimatedVectorDrawableCompat.create(applicationContext, R.drawable.vector_drawable)
        vectorDrawableAnimLess21?.let { img2.setImageDrawable(it) }

        img1.apply {
            setBackgroundResource(R.drawable.drawable_animation)
            drawableAnim = background as AnimationDrawable
        }

        btn.setOnClickListener{
            tv.visibility = View.VISIBLE
            tv.startAnimation(fadeInAnim)
            drawableAnim.start()
            (img2.drawable as Animatable?)?.start()
        }





    }
}