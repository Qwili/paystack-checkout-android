package com.paystack.checkout.model

import android.os.Parcelable
import androidx.annotation.Keep
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import kotlinx.parcelize.IgnoredOnParcel
import kotlinx.parcelize.Parcelize


@Keep
@Parcelize
data class ChargeParams(
    val publicKey: String,
    val email: String,
    val amount: Long,
    val currency: String,
    val channels: List<PaymentChannel>? = null,
    val phone: String? = null,
    val label: String? = null,
    val reference: String? = null,
    val subAccount: String? = null,
    val bearer: String? = null,
    val transactionCharge: Long? = null,
    val splitCode: String? = null,
    val plan: String? = null,
    val quantity: Long? = null,
    val metadata: String? = null
) : Parcelable {

    @IgnoredOnParcel
    private val channelsJsonAdapter: JsonAdapter<List<String>> by lazy {
        val type = Types.newParameterizedType(List::class.java, String::class.java)
        Moshi.Builder().build().adapter<List<String>>(type)
    }

    private val channelsJson: String?
        get() = channels?.map { it.name }?.let { channelsJsonAdapter.toJson(it) }

    fun toRequestMap(): Map<String, Any> {

        return mapOf(
            "key" to publicKey,
            "email" to email,
            "amount" to amount,
            "currency" to currency,
            "channels" to channelsJson,
            "phone" to phone,
            "label" to label,
            "ref" to reference,
            "subaccount" to subAccount,
            "bearer" to bearer,
            "transactionCharge" to transactionCharge,
            "split_code" to splitCode,
            "plan" to plan,
            "quantity" to quantity,
            "metadata" to metadata,
        ).pruneNullValues()
    }

    private fun <K, V> Map<K, V?>.pruneNullValues(): Map<K, V> {
        return filterValues { it != null } as Map<K, V>
    }
}
