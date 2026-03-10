package com.example.mybankdemo

import android.app.Activity
import android.os.Bundle
import android.widget.TextView

class ConfirmTransferActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transferUri = intent?.data
        val to = transferUri?.getQueryParameter("to") ?: "unknown"
        val amount = transferUri?.getQueryParameter("amount") ?: "0"

        val confirmationText = TextView(this).apply {
            text = "Confirm Transfer\n\nRecipient: $to\nAmount: $amount"
        }

        setContentView(confirmationText)
    }
}
