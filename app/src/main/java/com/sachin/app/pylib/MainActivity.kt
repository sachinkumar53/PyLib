package com.sachin.app.pylib

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sachin.pylib.numpy.Numpy

private const val TAG = "MainActivity"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            val numpy = Numpy()
            numpy.unique(
                arrayOf(4, 5, 5, 1)
            ).joinToString().also {
                Log.w(TAG, "onCreate: $it")
            }
        } catch (e: Exception) {
            Log.e(TAG, "onCreate: ", e)
        }
    }
}