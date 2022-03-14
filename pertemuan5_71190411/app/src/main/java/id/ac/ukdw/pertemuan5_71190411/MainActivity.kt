package id.ac.ukdw.pertemuan5_71190411


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val username= intent.getStringExtra("username")
        val salam = findViewById<TextView>(R.id.salam)
        salam.text="$username"
        val btnLogout : Button = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener{
            val i = Intent(this,LoginActivity::class.java)
            startActivity(i)
        }
    }
}
