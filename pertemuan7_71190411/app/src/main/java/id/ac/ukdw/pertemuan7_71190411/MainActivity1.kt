package id.ac.ukdw.pertemuan7_71190411

import android.content.Intent
import android.media.Image
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)

        val cover=intent.getIntExtra("Cover",10)
        val gambar=findViewById<ImageView>(R.id.imgContact)
        gambar.setImageResource(cover)


        val username= intent.getStringExtra("Nama")
        val nama= findViewById<TextView>(R.id.edtNama)
        nama.text="$username"

        val no= intent.getStringExtra("Nomor")
        val nomor= findViewById<TextView>(R.id.edtNomor)
        nomor.text="$no"

        val Email= intent.getStringExtra("Email")
        val Email1= findViewById<TextView>(R.id.edtEmail)
        Email1.text="$Email"

        val Motto= intent.getStringExtra("Motto")
        val Motto1= findViewById<TextView>(R.id.edtMotto)
        Motto1.text="$Motto"

        val btnBack : Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
    }
}