package id.ac.ukdw.pertemuan10_71190411

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.BaseColumns
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    var dbHelper: DatabaseHelper? = null
    var sql: SQLiteDatabase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNama = findViewById<EditText>(R.id.edtNama)
        val edtUsia = findViewById<EditText>(R.id.edtUsia)
        val btnSimpan = findViewById<Button>(R.id.btnSimpan)
        val btnHapus = findViewById<Button>(R.id.btnHapus)
        val btnCari = findViewById<Button>(R.id.btnCari)

        dbHelper = DatabaseHelper(this)
        sql = dbHelper?.writableDatabase

        btnSimpan.setOnClickListener {
            val values = ContentValues().apply {
                put(DatabaseContract.Penduduk.COLUMN_NAME_NAMA, edtNama.text.toString())
                put(DatabaseContract.Penduduk.COLUMN_NAME_USIA, edtUsia.text.toString())
            }
            sql?.insert(DatabaseContract.Penduduk.TABLE_NAME, null, values)
            edtNama.setText("")
            edtUsia.setText("")
            refreshData()
        }

        btnHapus.setOnClickListener {
            val selection = "USIA =? OR NAMA = ?"
            val selectionArgs = arrayOf(edtUsia.text.toString(), edtNama.text.toString())

            sql?.delete(DatabaseContract.Penduduk.TABLE_NAME, selection, selectionArgs)
            refreshData()
        }

        refreshData()
    }

    fun refreshData(){
        val txvHasil = findViewById<TextView>(R.id.txvHasil)
        val column = arrayOf(
            BaseColumns._ID,
            DatabaseContract.Penduduk.COLUMN_NAME_NAMA,
            DatabaseContract.Penduduk.COLUMN_NAME_USIA
        )

        val cursor = sql?.query(
            DatabaseContract.Penduduk.TABLE_NAME,
            column,
            null,
            null,
            null,
            null,
            null
        )

        var result = ""
        with(cursor){
            while(this!!.moveToNext()){
                result +="${this!!.getString(1)}-${this!!.getString(2)}th\n"
            }
        }

        txvHasil.text=result
    }
}