package com.example.f23comp3025w4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.f23comp3025w4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //define a global variable that can be used to access the view elements
    //in Java this would look like private ActivityMainBinding binding;
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //initialize the binding variable
        binding = ActivityMainBinding.inflate(layoutInflater)

        //set the contentView to use the Binding class instead of the XML.  The binding class will
        //connect to the xml layout
        setContentView(binding.root)

        binding.passDetailsButton.setOnClickListener {
            var name = binding.nameEditText.text.toString()

            if (name.isNotEmpty())
            {
                //pass the name to another activity
            }
            else
            {
                Toast.makeText(this,"Please enter your name", Toast.LENGTH_LONG).show()
            }
        }
    }
}