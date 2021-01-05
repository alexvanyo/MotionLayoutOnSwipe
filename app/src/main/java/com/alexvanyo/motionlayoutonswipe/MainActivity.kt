package com.alexvanyo.motionlayoutonswipe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.constraintlayout.motion.widget.MotionLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.text)
        val motionLayout = findViewById<MotionLayout>(R.id.motionLayout)

        motionLayout.addTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(motionLayout: MotionLayout, startId: Int, endId: Int) {
                Log.d("MainActivity", "onTransitionStarted: startId=$startId, endId=$endId")
            }

            override fun onTransitionChange(motionLayout: MotionLayout, startId: Int, endId: Int, progress: Float) {
                Log.d("MainActivity", "onTransitionStarted: startId=$startId, endId=$endId, progress=$progress")
                text.text = "Animating!"
            }

            override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                Log.d("MainActivity", "onTransitionStarted: currentId=$currentId")

                text.text = (when (currentId) {
                    R.id.collapsed -> "Collapsed!"
                    R.id.expanded -> "Expanded!"
                    else -> throw IllegalStateException("Unknown constraint set id!")
                })
            }

            override fun onTransitionTrigger(motionLayout: MotionLayout, triggerId: Int, positive: Boolean, progress: Float) {
                Log.d("MainActivity", "onTransitionStarted: triggerId=$triggerId, positive=$positive, progress=$progress")
            }
        })
    }
}