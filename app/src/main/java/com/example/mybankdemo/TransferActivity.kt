package com.example.mybankdemo

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView

class TransferActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val transferUri = intent?.data
        val to = transferUri?.getQueryParameter("to") ?: "unknown"
        val amount = transferUri?.getQueryParameter("amount") ?: "0"

        val statusText = TextView(this).apply {
            text = "Received deep link transfer request:\nTo: $to\nAmount: $amount\n\nForwarding..."
        }
        setContentView(statusText)

        // Vulnerability: forwards the attacker-controlled incoming intent without validation.
        val forwardedIntent = Intent(intent).apply {
            setClass(this@TransferActivity, ConfirmTransferActivity::class.java)
        }
        startActivity(forwardedIntent)
        finish()
    }
}
