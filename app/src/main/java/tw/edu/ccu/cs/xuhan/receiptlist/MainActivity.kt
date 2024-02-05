package tw.edu.ccu.cs.xuhan.receiptlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
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


    }
}