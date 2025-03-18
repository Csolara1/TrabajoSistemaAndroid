package com.example.recyclerviewexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewexample.Persona
import com.example.recyclerviewexample.R

class PersonaAdapter(private val listaPersonas: List<Persona>) :
    RecyclerView.Adapter<PersonaAdapter.PersonaViewHolder>() {

    class PersonaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreTextView: TextView = itemView.findViewById(R.id.nombreTextView)
        val apellidosTextView: TextView = itemView.findViewById(R.id.apellidosTextView)
        val telefonoTextView: TextView = itemView.findViewById(R.id.telefonoTextView)
        val emailTextView: TextView = itemView.findViewById(R.id.emailTextView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_persona, parent, false)
        return PersonaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PersonaViewHolder, position: Int) {
        val personaActual = listaPersonas[position]
        holder.nombreTextView.text = personaActual.nombre
        holder.apellidosTextView.text = personaActual.apellidos
        holder.telefonoTextView.text = personaActual.telefono
        holder.emailTextView.text = personaActual.email
    }

    override fun getItemCount() = listaPersonas.size
}