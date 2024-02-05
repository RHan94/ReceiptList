package tw.edu.ccu.cs.xuhan.receiptlist

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class receipt(
    @SerializedName("Date")
    val date: String,
    @SerializedName("ID")
    val id:String,
    @SerializedName("Store")
    val store: String,
    @SerializedName("Price")
    val price:Int,
    @SerializedName("Products")
    val products: List<product>
) : Serializable
