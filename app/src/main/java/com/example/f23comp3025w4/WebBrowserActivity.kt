package com.example.f23comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f23comp3025w4.databinding.ActivityWebBrowserBinding

class WebBrowserActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWebBrowserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebBrowserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToMainButton.setOnClickListener {
            finish()
        }

        binding.loadURLButton.setOnClickListener {
            var url = binding.urlEditText.text.toString()

            if (url.isNotEmpty())
            {
                //ensure that the url starts with http://
                if (!(url.startsWith("http://")) || (url.startsWith("https://")))
                    url = "http://" + url

                //create an implicit intent to call the browser
                val intent = Intent(Intent.ACTION_VIEW)

                //add data to the intent
                intent.data = Uri.parse(url)

                //launch the intent
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter a URL",Toast.LENGTH_LONG).show()
            }
        }
    }
}