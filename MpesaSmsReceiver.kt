package ke.ekambani.mpesa.reader

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.util.Log

class MpesaSmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Telephony.Sms.Intents.SMS_RECEIVED_ACTION) return
        for (sms in Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
            val sender = sms.originatingAddress.orEmpty()
            val body = sms.messageBody.orEmpty()
            // Basic filtering only. Sender IDs and message formats must be verified
            // against the user's genuine Safaricom messages before production use.
            val looksLikeMpesa = sender.contains("MPESA", ignoreCase = true) ||
                sender.contains("Safaricom", ignoreCase = true)
            if (looksLikeMpesa) {
                // Deliberately do not upload or persist raw SMS in this sample.
                // Production implementation needs encrypted local queue, authenticated
                // HTTPS endpoint, replay protection, and server-side verification.
                Log.i("EKAMBANI_MPESA", "M-Pesa-like SMS detected locally")
            }
        }
    }
}
