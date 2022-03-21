package id.ac.ukdw.pertemuan6_71190411

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class SecondFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v = inflater.inflate(R.layout.fragment_second,container, false)
        val btnThird = v.findViewById<Button>(R.id.btnThird)
        btnThird.setOnClickListener{
            val i = Intent(context, MainActivity3::class.java)
            context?.startActivity(i)
        }
        return v
    }
}