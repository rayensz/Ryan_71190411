 package id.ac.ukdw.pertemuan9_71190411

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

 class MainActivity : AppCompatActivity() {


     // untuk ambil data
    var sp: SharedPreferences? = null

     // untuk simpan data
     var spEdit: SharedPreferences.Editor? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sp= getSharedPreferences("mySP", MODE_PRIVATE)
        spEdit= sp?.edit()

        if(sp?.getBoolean("isLogin", false)== true){
            setContentView(R.layout.activity_home)
            val btnLogout = findViewById<Button>(R.id.btnLogout)
            btnLogout.setOnClickListener {
                logout()
            }
        }else{
            setContentView(R.layout.activity_main)
            val edtUsername = findViewById<EditText>(R.id.edtUsername)
            val edtPassword = findViewById<EditText>(R.id.edtPassword)
            val btnLogin = findViewById<Button>(R.id.btnLogin)
            btnLogin.setOnClickListener {
                login(edtUsername.text.toString(), edtPassword.text.toString())
            }
        }
    }

     fun login(username : String, password : String){
         if(username.equals("admin") && password.equals("admin")){
            spEdit?.putBoolean("isLogin", true)
             spEdit?.commit()
             val i = Intent(this, MainActivity::class.java)
             startActivity(i)
             finish()
         }else{
             Toast.makeText(this, "Username && Password Salah", Toast.LENGTH_LONG).show()
         }

     }

     fun logout(){
         spEdit?.putBoolean("isLogin", false)
         spEdit?.commit()
         val i = Intent(this, MainActivity::class.java)
         startActivity(i)
         finish()
     }
}