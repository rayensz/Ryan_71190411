package id.ac.ukdw.pertemuan5_71190411

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity()  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val edtUsername : EditText = findViewById(R.id.edtUsername)
        val edtPassword : EditText = findViewById(R.id.edtPassword)
        val btnLogin : Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener{
            login(edtUsername.text.toString(), edtPassword.text.toString())
        }
    }

    fun login(username : String, password : String){
        if(password.equals("1234")){
            val i: Intent = Intent(this,MainActivity::class.java)
            i.putExtra("username", username )
            startActivity(i)
        }else{
            showMessage("Password Anda Salah")

        }

    }

    fun showMessage(message: String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()

    }
}