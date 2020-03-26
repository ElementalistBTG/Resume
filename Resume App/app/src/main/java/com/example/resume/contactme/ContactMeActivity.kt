package com.example.resume.contactme

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.resume.R
import com.example.resume.databinding.ActivityContactmeBinding



class ContactMeActivity : AppCompatActivity() {


    private lateinit var binding : ActivityContactmeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_contactme)

        if(verifyAvailableNetwork(this)){
            //whats app
            binding.WhatsAppbutton.setOnClickListener {
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data =
                    Uri.parse("PERSONAL DATA REMOVED")
                startActivity(intent)

            }

            //messenger
            binding.messengerButton.setOnClickListener{
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse("PERSONAL DATA REMOVED")
                startActivity(intent)
            }

            //gmail
            binding.gmailButton.setOnClickListener{
                try{
                    val intent = Intent(Intent.ACTION_SEND)
                    intent.putExtra(Intent.EXTRA_SUBJECT,"job offer")
                    intent.putExtra(Intent.EXTRA_TEXT,"Hello Konstantinos, I would like to talk to you about a job offer.")
                    intent.data = Uri.parse("mailto:PERSONAL DATA REMOVED")
                    startActivity(intent)
                } catch (ex : ActivityNotFoundException){
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("mailto:PERSONAL DATA REMOVED")
                    startActivity(intent)
                }

            }

            //skype
            binding.skypeButton.setOnClickListener {
                try{
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("skype:PERSONAL DATA REMOVED")
                    startActivity(intent)
                }catch (ex : ActivityNotFoundException){
                    this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.skype.raider")))
                }

            }

            //viber
            binding.viberButton.setOnClickListener {
                val viberPackageName = "com.viber.voip"
                try {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse("tel:"+Uri.encode("PERSONAL DATA REMOVED"))
                    intent.setClassName(viberPackageName,"com.viber.voip.WelcomeActivity")
                    startActivity(intent)
                } catch (ex: ActivityNotFoundException) {
                    try {
                        this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=$viberPackageName")))
                    } catch (ex: ActivityNotFoundException) {
                        this.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=$viberPackageName")))
                    }
                }
            }
        }else{
            Toast.makeText(this,"You need an active internet connection to contact me",Toast.LENGTH_LONG).show()
        }



    }

    private fun verifyAvailableNetwork(activity:AppCompatActivity):Boolean{
        val connectivityManager=activity.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if(android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M){
            val networkInfo = connectivityManager.activeNetwork
            return networkInfo!=null
        }else{
            val networkInfo=connectivityManager.activeNetworkInfo
            return  networkInfo!=null && networkInfo.isConnected
        }
    }

}
