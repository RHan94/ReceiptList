package tw.edu.ccu.cs.xuhan.receiptlist

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView

class ReceiptAdapter(val receipts: Array<receipt>) : RecyclerView.Adapter<ReceiptAdapter.ViewHolder>() {

    inner class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView) {
        val date = itemView.findViewById<TextView>(R.id.date)
        val id = itemView.findViewById<TextView>(R.id.ID)
        val store = itemView.findViewById<TextView>(R.id.store)
        val price = itemView.findViewById<TextView>(R.id.price)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val clickedReceipt = receipts[position]
                    val intent = Intent(this.itemView.context, DetailsActivity::class.java)
                    intent.putExtra("clicked_receipt", clickedReceipt)
                    this.itemView.context.startActivity(intent)
                }
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.receipt_items, parent, false))
    }

    override fun getItemCount(): Int {
        return  receipts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date.text = receipts[position].date
        holder.id.text = receipts[position].id
        holder.store.text = receipts[position].store
        holder.price.text = "TWD ${receipts[position].price}"
    }
}