package pl.dawidolko.wifidirect

import android.content.Intent
import android.os.Bundle
import android.provider.Settings
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import pl.dawidolko.wifidirect.FileActivity.FileReceiverActivity
import pl.dawidolko.wifidirect.FileActivity.FileSenderActivity
import pl.dawidolko.wifidirect.HistoryActivity.HistoryActivity
import pl.dawidolko.wifidirect.TrustedDevicesActivity.TrustedDevicesActivity

/**
 * @Author: dawidolko
 * @Date: 26.11.2024
 *
 * @Desc: Aktywność centralna dla funkcji Wi-Fi Direct. Obsługuje nawigację do modułów wysyłania,
 * odbierania plików, zarządzania zaufanymi urządzeniami oraz historii.
 */

class WifiDirectActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wifi_direct)

        // Ustawienie strzałki wstecz w ActionBar
        supportActionBar?.apply {
            title = "Menu Wifi Direct"
            setDisplayHomeAsUpEnabled(true)
        }

        // Inicjalizacja przycisków
        val btnSender = findViewById<Button>(R.id.btnSender)
        val btnReceiver = findViewById<Button>(R.id.btnReceiver)
        val btnWifiDirect = findViewById<Button>(R.id.btnWifiDirect)
        val btnTrustedDevices = findViewById<Button>(R.id.btnTrustedDevices)
        val btnHistoryFile = findViewById<Button>(R.id.btnHistoryFile)

        // Handling the 'Send File' button – navigating to FileSenderActivity.
        btnSender.setOnClickListener {
            val intent = Intent(this, FileSenderActivity::class.java)
            startActivity(intent)
        }

        // Handling the 'Receive File' button – navigating to FileReceiverActivity.
        btnReceiver.setOnClickListener {
            val intent = Intent(this, FileReceiverActivity::class.java)
            startActivity(intent)
        }

        // Handling the 'Wi-Fi Direct Settings' button – navigating to the Wi-Fi Direct settings.
        btnWifiDirect.setOnClickListener {
            val intent = Intent(Settings.ACTION_WIFI_IP_SETTINGS) // Możesz również użyć Settings.ACTION_WIFI_SETTINGS
            startActivity(intent)
        }

        // Handling the 'Trusted Devices' button – navigating to the trusted devices view.
        btnTrustedDevices.setOnClickListener {
            val intent = Intent(this, TrustedDevicesActivity::class.java)
            startActivity(intent)
        }

        // Handling the 'History Files' button – navigating to the file history view.
        btnHistoryFile.setOnClickListener {
            val intent = Intent(this, HistoryActivity::class.java) // Przejście do HistoryActivity
            startActivity(intent)
        }

    }

    // Obsługa kliknięcia na strzałkę wstecz w ActionBar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
