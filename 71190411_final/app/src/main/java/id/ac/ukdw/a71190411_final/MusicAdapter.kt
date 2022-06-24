package id.ac.ukdw.a71190411_final

import android.content.Intent
import android.icu.number.IntegerWidth
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.FirebaseFirestore

class MusicAdapter(val listMusic: ArrayList<Music>): RecyclerView.Adapter<MusicAdapter.MusicHolder>() {
    class MusicHolder(val v: View): RecyclerView.ViewHolder(v){
        var music: Music? = null
        var firestore: FirebaseFirestore? = null

        fun bindView(music : Music){

            firestore = FirebaseFirestore.getInstance()
            this.music = music
            v.findViewById<TextView>(R.id.textJudul).text= "${music.judulLagu}"
            v.findViewById<TextView>(R.id.textPenyanyi).text="${music.namaPenyanyi}"
            v.findViewById<Button>(R.id.btnHapus).setOnClickListener {
                firestore?.collection("music")
                    ?.whereEqualTo("judulLagu",music.judulLagu.toString())?.get()
                    ?.addOnSuccessListener { documents ->
                        for (dataDoc in documents) {
                            firestore?.collection("music")?.document(dataDoc.id)?.delete()
                        }
                        val i: Intent = Intent( v.context,MainActivity::class.java)
                        i.putExtra("refresh",true)
                        v.context.startActivity(i)
                    }


            }

//            v.setOnClickListener{
//                Toast.makeText(v.context, "${music.judulLagu} - ${music.namaPenyanyi}", Toast.LENGTH_LONG).show()
//                val i = Intent(v.context, MainActivity1::class.java)
//                v.context.startActivity(i)
//            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_music, parent, false)
        return MusicHolder(v)
    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        holder.bindView(listMusic[position])
    }

    override fun getItemCount(): Int = listMusic.size
}