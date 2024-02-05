package tw.edu.ccu.cs.xuhan.receiptlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        val receipt = intent.getSerializableExtra("clicked_receipt") as receipt
        val store = findViewById<TextView>(R.id.StoreNameTV)
        val id = findViewById<TextView>(R.id.IDTV)
        val products = findViewById<TextView>(R.id.productTV)
        val prices = findViewById<TextView>(R.id.priceTV)
        store.text = receipt.store
        id.text = receipt.id

        var productsContent = ""
        var priceContent = ""
        receipt.products.forEach {
            productsContent += it.name+"\n"
            priceContent += it.price.toString() + "\n"
        }

        products.text = productsContent
        prices.text = priceContent



    }
}