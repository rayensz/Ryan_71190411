package id.ac.ukdw.pertemuan7_71190411

import android.content.Intent
import android.icu.number.IntegerWidth
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ContactAdapter(val listNama: ArrayList<Contact>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {
    class ContactHolder(val v: View): RecyclerView.ViewHolder(v){
        var contact: Contact? = null

        fun bindView(contact : Contact){
            this.contact = contact
            v.findViewById<TextView>(R.id.textNama).text= "${contact.Nama}"
            v.findViewById<TextView>(R.id.textNomor).text="${contact.Nomor}"
            v.findViewById<ImageView>(R.id.cvrCnt).setImageResource(contact.Cover)
            v.setOnClickListener{
                Toast.makeText(v.context, "${contact.Nama} - ${contact.Nomor}", Toast.LENGTH_LONG).show()
                val i = Intent(v.context, MainActivity1::class.java)
                i.putExtra("Cover",contact.Cover)
                i.putExtra("Nama",contact.Nama)
                i.putExtra("Nomor",contact.Nomor)
                i.putExtra("Email", contact.Email)
                i.putExtra("Motto",contact.Motto)

                v.context.startActivity(i)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_contact, parent, false)
        return ContactHolder(v)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bindView(listNama[position])
    }

    override fun getItemCount(): Int = listNama.size
}