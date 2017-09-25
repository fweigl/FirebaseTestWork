package com.example.firebasetestwork

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.firebase.FirebaseApp
import com.google.firebase.remoteconfig.FirebaseRemoteConfig

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirebaseApp.initializeApp(this)
        val config = FirebaseRemoteConfig.getInstance()

        config.fetch().addOnCompleteListener(this, {
            Log.d("yyy", "complete ${it.isSuccessful} ${it.exception}")

            if (it.isSuccessful) {
                config.activateFetched()

                val v = config.getString("test_value")
                Log.d("yyy", v)
            }
        })

    }
}
