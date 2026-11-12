package ke.ekambani.mpesa.reader

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.content.pm.PackageManager
import android.widget.TextView
import android.widget.LinearLayout
import android.widget.Button
import android.widget.Toast

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layout = LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            setPadding(36, 48, 36, 36)
        }
        layout.addView(TextView(this).apply {
            text = "EKAMBANI M-Pesa Reader\n\nSample project – not a finished payment verifier.\n\nThis app is designed to detect incoming SMS locally and filter M-Pesa-like messages. It does not yet connect to your renewal backend."
            textSize = 18f
        })
        layout.addView(Button(this).apply {
            text = "Enable SMS detection"
            setOnClickListener {
                if (checkSelfPermission(Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED) {
                    requestPermissions(arrayOf(Manifest.permission.RECEIVE_SMS), 100)
                } else Toast.makeText(this@MainActivity, "SMS permission already granted", Toast.LENGTH_SHORT).show()
            }
        })
        setContentView(layout)
    }
}
