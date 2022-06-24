package id.ac.ukdw.a71190411_final

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : AppCompatActivity() {
    var firestore: FirebaseFirestore? = null
    lateinit var mGoogleSignInClient: GoogleSignInClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login()
        firestore = FirebaseFirestore.getInstance()

        firestore?.collection("music")?.get()
            ?.addOnSuccessListener {
                var listMusic = ArrayList<Music>()
                listMusic.clear()

                for(doc in it){
                    listMusic.add(Music("${doc.data["judulLagu"]}", "${doc.data["namaPenyanyi"]}", "${doc.data["judulAlbum"]}", "${doc.data["genre"]}",  "${doc.data["tahunRilis"]}"))
                }

                val rcyMusic = findViewById<RecyclerView>(R.id.rcyMusic)
                rcyMusic.layoutManager = LinearLayoutManager(this)
                val adapter = MusicAdapter(listMusic)
                rcyMusic.adapter = adapter

                Log.e("List", listMusic.toString())

            }
            ?.addOnFailureListener{
                Log.d("Load Data", "Pengambilan Data Gagal!")
            }

    }

    fun login(){
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.web_client))
            .requestEmail()
            .build()
        mGoogleSignInClient= GoogleSignIn.getClient(this,gso)

        var logout = findViewById<Button>(R.id.logout)
        logout.setOnClickListener {
            mGoogleSignInClient.signOut().addOnCompleteListener {
                val intent= Intent(this, LoginActivity::class.java)
                Toast.makeText(this,"Logging Out",Toast.LENGTH_SHORT).show()
                startActivity(intent)
                finish()
            }
        }
    }

    fun tambahBarang(view: android.view.View) {
        val intent = Intent(this, insetData::class.java)
        startActivity(intent)
        finish()
    }


}