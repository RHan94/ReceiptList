package tw.edu.ccu.cs.xuhan.receiptlist

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv = findViewById<RecyclerView>(R.id.rv)



        val gson = Gson()
        val receipts = gson.fromJson(
            resources.openRawResource(R.raw.receipts).bufferedReader(),
            Array<receipt>::class.java
        )

        rv.adapter = ReceiptAdapter(receipts)
        rv.layoutManager = LinearLayoutManager(this)

        val dividerItemDecoration = DividerItemDecoration(rv.context, LinearLayoutManager(this).orientation)
        dividerItemDecoration.setDrawable(resources.getDrawable(R.drawable.divider))
        rv.addItemDecoration(dividerItemDecoration)

        val countTV = findViewById<TextView>(R.id.receipt_countTV)
        countTV.text = "共有${receipts.size}筆消費"

        val priceTV = findViewById<TextView>(R.id.receipt_priceTV)
        priceTV.text = "${receipts.sumOf { it.price }}"




    }
}