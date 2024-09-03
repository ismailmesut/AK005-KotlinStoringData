package com.ismailmesutmujde.kotlinstoringdata

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.ismailmesutmujde.kotlinstoringdata.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var bindingMainActivity : ActivityMainBinding
    lateinit var sharedPref : SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivity.root
        setContentView(view)

        // Shared Preferences - XML : Key-Value
        sharedPref = this.getSharedPreferences("com.ismailmesutmujde.kotlinstoringdata", Context.MODE_PRIVATE)

    }

    fun save (view: View) {
        val myAge = bindingMainActivity.editText.text.toString()
        //bindingMainActivity.textView.text = "Your age : " + myAge
    }

    fun delete(view: View) {

    }
}