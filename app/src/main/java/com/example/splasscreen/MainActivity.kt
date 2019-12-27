package com.example.splasscreen

import android.animation.ObjectAnimator
import android.animation.PropertyValuesHolder
import android.os.Bundle
import android.transition.AutoTransition
import android.transition.Transition
import android.transition.TransitionManager
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.transition.addListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


class MainActivity : AppCompatActivity() {
val constraint1 = ConstraintSet()
val constraint2 = ConstraintSet()
val constraint3 = ConstraintSet()
val constraint4 = ConstraintSet()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        window.setBackgroundDrawable(resources.getDrawable(R.drawable.bg,null ))
//        musiclabel.scaleType=ImageView.ScaleType.FIT_XY
//        remember.scaleType=ImageView.ScaleType.FIT_XY
        constraint1.clone(root)
        constraint2.clone(this,R.layout.zoom_in_image)
        constraint3.clone(this,R.layout.side_icon)
        constraint4.clone(this,R.layout.text_enter)

    }

    override fun onResume() {
        super.onResume()
        val constraint = constraint1
        constraint.applyTo(root)
        GlobalScope.launch (Dispatchers.Main){
            delay(1000)
            startAnimator()
        }


    }

    private fun startAnimator() {

        val autoTransition=AutoTransition()
        autoTransition.duration=3000
        autoTransition.addListener(object : Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {
                    sideAnimator()
            }

            override fun onTransitionResume(p0: Transition?) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onTransitionPause(p0: Transition?) {}

            override fun onTransitionCancel(p0: Transition?) {}

            override fun onTransitionStart(p0: Transition?) {

            }
        })
        TransitionManager.beginDelayedTransition(root,autoTransition)
        val constraint= constraint2
        constraint.applyTo(root)
    }

    private fun sideAnimator() {

        val autoTransition1 = AutoTransition()
        autoTransition1.duration = 2000
        autoTransition1.addListener(object :Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {
                textEnterAnimation()
            }

            override fun onTransitionResume(p0: Transition?) {}

            override fun onTransitionPause(p0: Transition?) {}

            override fun onTransitionCancel(p0: Transition?) {}

            override fun onTransitionStart(p0: Transition?) {}
        })

        TransitionManager.beginDelayedTransition(root,autoTransition1)
        val constraint = constraint3
        constraint.applyTo(root)
    }

    private fun textEnterAnimation() {
        val autoTransition2 = AutoTransition()
        autoTransition2.duration = 3000
        autoTransition2.addListener(object : Transition.TransitionListener{
            override fun onTransitionEnd(p0: Transition?) {}

            override fun onTransitionResume(p0: Transition?) {}

            override fun onTransitionPause(p0: Transition?) {}

            override fun onTransitionCancel(p0: Transition?) {}

            override fun onTransitionStart(p0: Transition?) {}
        })
        TransitionManager.beginDelayedTransition(root,autoTransition2)
        val constraint = constraint4
        constraint.applyTo(root)
    }


}

