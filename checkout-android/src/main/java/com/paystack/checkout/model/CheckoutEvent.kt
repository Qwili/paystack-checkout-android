package com.paystack.checkout.model

import androidx.annotation.Keep
import com.squareup.moshi.JsonClass

internal enum class CheckoutEventType(val value: String) {
    close("close"),
    redirecting("checkout:redirecting"),
    loadedTransaction("loaded:transaction"),
    success("success")
}

@Keep
internal sealed class CheckoutEvent

@Keep
@JsonClass(generateAdapter = true)
internal class CloseEvent : CheckoutEvent()

@Keep
@JsonClass(generateAdapter = true)
internal class RedirectingEvent : CheckoutEvent()

internal class ErrorEvent(val exception: Throwable) : CheckoutEvent()

@Keep
@JsonClass(generateAdapter = true)
internal data class SuccessEvent(val data: SuccessEventData) : CheckoutEvent()

@Keep
@JsonClass(generateAdapter = true)
internal class LoadedTransactionEvent : CheckoutEvent()
