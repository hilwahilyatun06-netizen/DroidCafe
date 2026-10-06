package lat.pam.droidcafe

import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_order)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cities = arrayOf(
            getString(R.string.city_bandung),
            getString(R.string.city_cianjur),
            getString(R.string.city_garut),
            getString(R.string.city_tasikmalaya)
        )

        val adapter = ArrayAdapter(
            this,
            android.R.layout.simple_spinner_item,
            cities
        )

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        val citySpinner = findViewById<android.widget.Spinner>(R.id.city_spinner)
        citySpinner.adapter = adapter
    }

    fun onRadioButtonClicked(view: View) {
        if (view is RadioButton) {
            val checked = view.isChecked

            if (checked) {
                when (view.getId()) {
                    R.id.sameday ->
                        Toast.makeText(
                            this,
                            getString(R.string.same_day_messenger_service),
                            Toast.LENGTH_SHORT
                        ).show()

                    R.id.nextday ->
                        Toast.makeText(
                            this,
                            getString(R.string.next_day_ground_delivery),
                            Toast.LENGTH_SHORT
                        ).show()

                    R.id.pickup ->
                        Toast.makeText(
                            this,
                            getString(R.string.pick_up),
                            Toast.LENGTH_SHORT
                        ).show()
                }
            }
        }
    }
}