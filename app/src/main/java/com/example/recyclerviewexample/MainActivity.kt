package com.example.recyclerviewexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: PersonaAdapter
    private lateinit var listaPersonas: ArrayList<Persona>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listaPersonas = ArrayList()
        //listaPersonas.add(Persona("Juan", "Pérez", "123456789", "juan.perez@example.com"))

        val retrofit: Retrofit = Builder()
            .baseUrl("TU_BASE_URL_AQUI") // Reemplaza con la base URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)

        adapter = PersonaAdapter(listaPersonas)
        recyclerView.adapter = adapter
    }
}