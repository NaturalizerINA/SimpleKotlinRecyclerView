package com.mukminullah.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_detail)
        tvDetail.text = intent.getStringExtra("text")
        ivDetail.setImageResource(intent.getIntExtra("image", 0))

    }
}