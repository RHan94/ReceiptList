package tw.edu.ccu.cs.xuhan.receiptlist

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class product(
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Int
): Serializable
