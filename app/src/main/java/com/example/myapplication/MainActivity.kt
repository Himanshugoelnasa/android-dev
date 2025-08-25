package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import cn.pedant.SweetAlert.SweetAlertDialog
import cn.pedant.SweetAlert.SweetAlertDialog.OnSweetClickListener
import com.shashank.sony.fancytoastlib.FancyToast
import android.content.Intent
import com.example.myapplication.databinding.ActivityEditViewImageBinding


class MainActivity : AppCompatActivity() {

    val customMenu = com.example.myapplication.CustomMenu()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        installSplashScreen()
        setContentView(R.layout.activity_main)

        // code for toast
        val toastButton = findViewById<Button>(R.id.toastButton)
        toastButton.setOnClickListener {
            //Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
            FancyToast.makeText(this,"Hello World !",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
        }

        // code for menu items
        val showPopup = findViewById<Button>(R.id.menuButton)
        showPopup.setOnClickListener {
            customMenu.showMenu(this, it)
        }

        // code for alert dialog
        val alertButton = findViewById<Button>(R.id.alertButton)
        alertButton.setOnClickListener {
            val alert = AlertDialog.Builder(this)

            alert.setTitle(R.string.alert_title)
            alert.setMessage(R.string.alert_message)
            //alert.setIcon()

            alert.setPositiveButton("Yes") { dialogInterface, which ->
                Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show()
            }

            alert.setNegativeButton("No") { dialogInterface, which ->
                Toast.makeText(this, "No", Toast.LENGTH_SHORT).show()
            }

            alert.setNeutralButton("Cancel") { dialogInterface, which ->
                Toast.makeText(this, "Cancel", Toast.LENGTH_SHORT).show()
            }
            val alertDialog:AlertDialog = alert.create()

            alertDialog.setCancelable(false)
            alertDialog.show()
        }

        // code for sweeet alert dialog
        val sweetAlert = findViewById<Button>(R.id.sweetAlertButton)
        sweetAlert.setOnClickListener {
            SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Are you sure?")
                .setContentText("Won't be able to recover this file!")
                .setConfirmText("Yes,delete it!")
                .setConfirmClickListener(object : OnSweetClickListener {
                    override fun onClick(sDialog: SweetAlertDialog) {
                        sDialog.dismissWithAnimation()
                    }
                })
                .setCancelButton("Cancel", object : OnSweetClickListener {
                    override fun onClick(sDialog: SweetAlertDialog) {
                        sDialog.dismissWithAnimation()
                    }
                })
                .show()
        }


        // open web view
        val button = findViewById<Button>(R.id.openWebView)
        button.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            intent.putExtra("url", "https://www.google.com")
            startActivity(intent)
        }

        // open grid layout
        val gridLayoutBtn = findViewById<Button>(R.id.gridLayoutBtn)
        gridLayoutBtn.setOnClickListener {
            val intent = Intent(this, gridLayoutActivity::class.java)
            startActivity(intent)
        }

        val implicitBtn  = findViewById<Button>(R.id.implicitBtn)
        implicitBtn.setOnClickListener {
            val intent = Intent(this, implicitIntentActivity::class.java)
            startActivity(intent)
        }

        val bundleBtn  = findViewById<Button>(R.id.bundleBtn)
        bundleBtn.setOnClickListener {
            val intent = Intent(this, editViewImageActivity::class.java)
            startActivity(intent)
        }

    }
}