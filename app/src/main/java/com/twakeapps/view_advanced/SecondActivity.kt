package com.twakeapps.view_advanced

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity

import com.twakeapps.view_advanced.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity()
{
    private lateinit var binding : ActivitySecondBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSetData.setOnClickListener {

            val mName = binding.etName.text.toString()
            val i = Intent().apply {
                action = "my.name"
                putExtra("MY_NAME", mName)
                putExtra("REQUEST_CODE", intent.getIntExtra("REQUEST_CODE",0))
            }
            setResult(9999,i)
            finish()
        }
    }
}