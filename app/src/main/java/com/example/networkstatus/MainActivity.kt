package com.example.networkstatus

import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.content.getSystemService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtView: TextView = findViewById(R.id.textView2)
        val btn :Button = findViewById(R.id.button)

        btn.setOnClickListener(object:View.OnClickListener{
            override fun onClick(view: View){
                //System services
                var connectivityManager:ConnectivityManager =
                    getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager   //To get access to system services like bluetooth manager, connectivity manager
                var netInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
                var isConnected: Boolean = netInfo?.isConnectedOrConnecting == true
                txtView.text = "Connection Status:"+ if(isConnected) "Connected" else "Disconnected"
            }
        })
    }
}