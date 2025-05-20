package us.ldts.ktldts1rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter(private val listadoItems: List<ListItem>) :
    RecyclerView.Adapter<ListItemAdapter.PersonaViewHolder>() {

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alumnosTextView: TextView = itemView.findViewById(R.id.alumnosTextView)
        val examenesTextView: TextView = itemView.findViewById(R.id.examenesTextView)
        val notasTextView: TextView = itemView.findViewById(R.id.notasTextView)
        val materiasTextView: TextView = itemView.findViewById(R.id.materiasTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val personaActual = listadoItems[position]
        holder.alumnosTextView.text = personaActual.alumnos
        holder.examenesTextView.text = personaActual.examenes
        holder.notasTextView.text = personaActual.notas
        holder.materiasTextView.text = personaActual.materias
    }

    override fun getItemCount() = listadoItems.size
}