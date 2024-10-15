package com.twakeapps.view_advanced

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.DatePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.LinearLayout
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textview.MaterialTextView
import com.twakeapps.view_advanced.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState : Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        /*
        * View without xml
        * */

//        val tv1 = MaterialTextView(this).apply {
//            text = "Twake"
//            textSize = 12F
//        }
// val tv2 = MaterialTextView(this).apply {
//            text = "Hello kotlin"
//            textSize = 22F
//        }
//
//
//val llMain = LinearLayout(this).apply {
//    orientation = LinearLayout.VERTICAL
//    addView(tv1)
//    addView(tv2)
//
//}
//
//        setContentView(llMain)











        /*
        * set font to text view
        * */
//        val tf = ResourcesCompat.getFont(this, R.font.caveat_bold)
//        binding.tvTitle.typeface = tf

        /*
        * Animation
        * */

        binding.btnAnimate.setOnClickListener {

            binding.tvTitle.animate().apply {
                translationY(0F)
                translationX(0F)
                translationXBy(100F)
                translationYBy(100F)

                duration = 1000
                setListener(object :AnimatorListenerAdapter(){
                    override fun onAnimationEnd(animation : Animator)
                    {
                        super.onAnimationEnd(animation)

                        //Your code here


                    }
                })

            }

        }
///*
//* Include footer button
//* */
        binding.includeFooterButton.btnNext.setOnClickListener {

        }
        binding.includeFooterButton.btnCancel.setOnClickListener {

        }

        /*
        *Activity result
        *  */

        binding.btnGoNext.setOnClickListener {

            val i = Intent(this,SecondActivity::class.java)
            i.putExtra("REQUEST_CODE", 1000) // for new style
//            startActivityForResult(i,1000) // old style
            resultLauncher.launch(i)// new style

        }
        datePicker()


    }// onCreate

    private fun datePicker(){

        val c = Calendar.getInstance()
        val mYear = c.get(Calendar.YEAR)
        val mMonth = c.get(Calendar.MONTH)
        val mDay = c.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
            binding.btnDatePicker.text = "${dayOfMonth}/${month}/${year}"
        },mYear,mMonth,mDay)

        binding.btnDatePicker.setOnClickListener {
            dpd.show()
        }

    }





    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){result ->
        val allData = "Req. Code: ${result?.data?.getIntExtra("REQUEST_CODE",0)}, Action: ${result.resultCode}, Action: ${result?.data?.action}, Name: ${result?.data?.getStringExtra(" MY_NAME")}"
        print(allData)
    }







    // old style

//    override fun onActivityResult(requestCode : Int, resultCode : Int, data : Intent?)
//    {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        val allData = "Req. Code: ${requestCode}, Res. Code: ${resultCode}, Action: ${data?.action}, Name: ${data?.getStringExtra(" MY_NAME")}"
//         println(allData)
//    }
}