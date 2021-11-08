package com.nim19041081.intentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var tvResult: TextView
    private val resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == MoveResultActivity.RESULT_CODE && result.data != null) {
            val selectedValue =
                result.data?.getIntExtra(MoveResultActivity.EXTRA_SELECTED_VALUE, 0)
            tvResult.text = "Hasil : $selectedValue"
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        val btnMoveDataActivity: Button = findViewById(R.id.btn_move_activity_data)
        btnMoveDataActivity.setOnClickListener(this)

        val btnMoveObject:Button = findViewById(R.id.btn_move_activity_Object)
        btnMoveObject.setOnClickListener(this)

        val btnMoveResult:Button = findViewById(R.id.btn_move_result)
        btnMoveResult.setOnClickListener(this)
        tvResult = findViewById(R.id.tv_result)


    }

    override fun onClick(p0: View?) {

        when (p0?.id) {
            R.id.btn_move_activity-> {
                val moveIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(moveIntent)
            }
            R.id.btn_move_activity_data -> {
                val moveDataIntent = Intent(this@MainActivity, MoveDataAvtivity::class.java)
                moveDataIntent.putExtra(MoveDataAvtivity.EXTRA_NAME, "Vikar Maulana")
                moveDataIntent.putExtra(MoveDataAvtivity.EXTRA_AGE, 20)
                startActivity(moveDataIntent)
            }
            R.id.btn_move_activity_Object -> {
                val student = Student(
                    "Poltek Harber",
                    5,
                    "academy@harber.com",
                    "Tegal"
                )
                val moveObjectIntent = Intent(this@MainActivity, MoveObjectActivity::class.java)
                moveObjectIntent.putExtra(MoveObjectActivity.EXTRA_STUDENT, student)
                startActivity(moveObjectIntent)
            }
            R.id.btn_move_result -> {
                val moveForResultIntent = Intent(this@MainActivity,
                    MoveResultActivity::class.java)
                resultLauncher.launch(moveForResultIntent)
            }
//            }
        }
    }
}



