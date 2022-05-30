package id.ac.ukdw.pertemuan12_71190411

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtKota = findViewById<EditText>(R.id.edtKota)
        val btnCek = findViewById<Button>(R.id.btnCek)

        btnCek.setOnClickListener {
            cekCuaca(edtKota.text.toString())
        }
    }

    fun cekCuaca(kota: String){
        val queue = Volley.newRequestQueue(this)
        val url = "https://api.openweathermap.org/data/2.5/weather?q=${kota}&appid=8e36975bdb7bbcaaa0936bc3e73dab84"
        val request = StringRequest(
            Request.Method.GET,
            url,
            Response.Listener<String> { response ->
                val data = JSONObject(response)
                val cuaca = data.getJSONArray("weather").getJSONObject(0).getString("description")
                val suhu = data.getJSONObject("main").getDouble("temp")
                val txvHasil = findViewById<TextView>(R.id.txvHasil)
                txvHasil.text="${cuaca} (${String.format("%.2f", suhu-273.15).toDouble()}\u2103)"
            },
            Response.ErrorListener {

            })

        queue.add(request)

    }
}