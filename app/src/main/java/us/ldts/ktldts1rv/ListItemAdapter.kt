package us.ldts.ktldts1rv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListItemAdapter(private val listadoItems: List<ListItem>) :
    RecyclerView.Adapter<ListItemAdapter.PersonaViewHolder>() {

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val idGrupoTextView: TextView = itemView.findViewById(R.id.idGrupoTextView)
        val pecTextView: TextView = itemView.findViewById(R.id.pecTextView)
        val claseTextView: TextView = itemView.findViewById(R.id.claseTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val personaActual = listadoItems[position]
        holder.idGrupoTextView.text = personaActual.idGrupo
        holder.pecTextView.text = personaActual.pec
        holder.claseTextView.text = personaActual.clase
    }

    override fun getItemCount() = listadoItems.size
}