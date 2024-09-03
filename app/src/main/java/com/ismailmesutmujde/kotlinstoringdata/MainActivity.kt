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
    var ageFromPref : Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingMainActivity = ActivityMainBinding.inflate(layoutInflater)
        val view = bindingMainActivity.root
        setContentView(view)

        // Shared Preferences - XML : Key-Value
        sharedPref = this.getSharedPreferences("com.ismailmesutmujde.kotlinstoringdata", Context.MODE_PRIVATE)

        ageFromPref = sharedPref.getInt("age", -1)

        if (ageFromPref == -1) {
            bindingMainActivity.textView.text = "Your age : "
        } else {
            bindingMainActivity.textView.text = "Your age : ${ageFromPref}"
        }


    }

    fun save (view: View) {
        val myAge = bindingMainActivity.editText.text.toString().toIntOrNull()
        if (myAge != null) {
            bindingMainActivity.textView.text = "Your age : ${myAge}"
            sharedPref.edit().putInt("age", myAge).apply()
        }

    }

    fun delete(view: View) {
        ageFromPref = sharedPref.getInt("age", -1)
        if (ageFromPref != -1) {
            sharedPref.edit().remove("age").apply()
            bindingMainActivity.textView.text = "Your age : "
        }
    }
}