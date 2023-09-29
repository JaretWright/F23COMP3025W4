package com.example.f23comp3025w4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f23comp3025w4.databinding.ActivitySmsBinding

class SmsActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySmsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySmsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.backToMainButton.setOnClickListener {
            finish()
        }

        binding.imageButton.setOnClickListener {
            var phoneNum = binding.editTextPhone.text.toString()
            var msg = binding.msgEditText.text.toString()

            if (phoneNum.isNotEmpty() && msg.isNotEmpty())
            {
                //send an SMS
                var uri = Uri.parse("smsto:$phoneNum")
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", msg)
                startActivity(intent)
            }
            else
            {
                Toast.makeText(this,"Enter a phone number & message", Toast.LENGTH_LONG).show()
            }
        }
    }
}