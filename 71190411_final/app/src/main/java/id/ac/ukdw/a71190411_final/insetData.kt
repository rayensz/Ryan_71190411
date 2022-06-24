package id.ac.ukdw.a71190411_final

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class insetData: AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    var firestore: FirebaseFirestore? = null

    override fun onCreate(savedInstanceStance: Bundle?) {
        super.onCreate(savedInstanceStance)
        setContentView(R.layout.activity_insert)

        auth = FirebaseAuth.getInstance()
        firestore = FirebaseFirestore.getInstance()

        val judulLagu = findViewById<EditText>(R.id.edtJudul)
        val namaPenyanyi = findViewById<EditText>(R.id.edtPenyanyi)
        val judulAlbum = findViewById<EditText>(R.id.edtAlbum)
//        val gambarCover = findViewById<EditText>(R.id.edtCover)
        val genre = findViewById<EditText>(R.id.edtGenre)
        val tahunRilis = findViewById<EditText>(R.id.edtRilis)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val btnBatal = findViewById<Button>(R.id.btnBatal)

        btnSimpan.setOnClickListener {

            if(judulLagu.text.toString().isEmpty()){
                judulLagu.error = "Judul lagu harus diisi"
                judulLagu.requestFocus()
                return@setOnClickListener
            }

            if(namaPenyanyi.text.toString().isEmpty()){
                namaPenyanyi.error="Nama penyanyi harus diisi"
                namaPenyanyi.requestFocus()
                return@setOnClickListener
            }

            if(judulAlbum.text.toString().isEmpty()){
                judulAlbum.error="Judul album harus diisi"
                judulAlbum.requestFocus()
                return@setOnClickListener
            }

//            if(gambarCover.text.toString().isEmpty()){
//                gambarCover.error="Gambar harus diisi"
//                gambarCover.requestFocus()
//                return@setOnClickListener
//            }

            if(genre.text.toString().isEmpty()){
                genre.error="Genre harus diisi"
                genre.requestFocus()
                return@setOnClickListener
            }

            if(tahunRilis.text.toString().isEmpty()){
                tahunRilis.error="Tahun rilis harus diisi"
                tahunRilis.requestFocus()
                return@setOnClickListener
            }

            val music = Music(judulLagu.text.toString(), namaPenyanyi.text.toString(), judulAlbum.text.toString(), genre.text.toString(), tahunRilis.text.toString())

            firestore?.collection("music")?.add(music)
                ?.addOnSuccessListener {
                    Toast.makeText(this, "Musik Berhasil Ditambahkan", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }?.addOnFailureListener{
                    Toast.makeText(this, "Music gagal ditambahkan!", Toast.LENGTH_SHORT).show()
                }

        }

    }


}