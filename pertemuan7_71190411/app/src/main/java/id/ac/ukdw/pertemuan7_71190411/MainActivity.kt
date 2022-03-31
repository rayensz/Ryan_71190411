package id.ac.ukdw.pertemuan7_71190411

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listContact= ArrayList<Contact>()
        listContact.add(Contact("Archie Aussie","081234565432",R.drawable.biru,"archieaussie@gmail.com","Mengalir Seperti Air"))
        listContact.add(Contact("Bagus Setiawan","085871929163",R.drawable.merah,"bagusganteng@yahoo.co.id","Alon-alon Waton Kelakon"))
        listContact.add(Contact("Chintya Bella","082861496154",R.drawable.ungu,"chintyabella@gmail.com","Selalu Cantik"))
        val rcyContact= findViewById<RecyclerView>(R.id.rcyContact)
        rcyContact.layoutManager = LinearLayoutManager(this)
        val contactAdapter= ContactAdapter(listContact)
        rcyContact.adapter = contactAdapter
    }
}