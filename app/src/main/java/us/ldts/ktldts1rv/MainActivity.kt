package us.ldts.ktldts1rv

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ListItemAdapter
    private lateinit var listadoItems: ArrayList<ListItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        listadoItems = ArrayList()
        adapter = ListItemAdapter(listadoItems)
        recyclerView.adapter = adapter

        // Configurar Retrofit
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://51.120.14.196:8080/LDTSHandlerSession2/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)

        val call = apiService.getHorario()

        Log.d("MainActivity", "Llamando a la API...")

        call.enqueue(object : Callback<List<ListItem>> {
            override fun onResponse(
                call: Call<List<ListItem>>,
                response: Response<List<ListItem>>
            ) {
                Log.d("MainActivity", "Código de respuesta: ${response.code()}")

                if (response.isSuccessful) {
                    val horarioList = response.body()
                    if (!horarioList.isNullOrEmpty()) {
                        listadoItems.clear()
                        listadoItems.addAll(horarioList)
                        adapter.notifyDataSetChanged()
                        Log.d("MainActivity", "Datos recibidos: $horarioList")
                    } else {
                        Log.d("MainActivity", "Lista vacía recibida desde la API.")
                    }
                } else {
                    Log.e("MainActivity", "Respuesta no exitosa: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<ListItem>>, t: Throwable) {
                Log.e("MainActivity", "Error en la llamada: ${t.message}", t)
            }
        })
    }
}
