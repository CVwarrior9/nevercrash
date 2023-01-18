package com.example.nenvercrashapp

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main2.*

class Main2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mainThreadCrash.setOnClickListener {
            makeMainThreadCrash()
        }
        subThreadCrash.setOnClickListener {
            makeSubThreadCrash()
        }
    }

    //主线程
    private fun makeMainThreadCrash() {
        crash()
    }

    //子线程
    private fun makeSubThreadCrash() {
        Thread { crash() }.start()
    }

    private fun crash() {
        val array = arrayOf(1, 2, 3)
        Log.d("tag", array[3].toString())
    }
}