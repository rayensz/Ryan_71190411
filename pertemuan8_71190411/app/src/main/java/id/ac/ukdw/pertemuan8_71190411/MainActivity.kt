package id.ac.ukdw.pertemuan8_71190411

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar_default))
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_default, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.tambah -> Toast.makeText(this,"Menu Tambah",Toast.LENGTH_LONG).show()
            R.id.akun -> Toast.makeText(this,"Menu Akun",Toast.LENGTH_LONG).show()
            R.id.pesan -> Toast.makeText(this,"Menu Pesan",Toast.LENGTH_LONG).show()
        }
        return true
    }
}