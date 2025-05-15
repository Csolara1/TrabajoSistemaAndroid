package us.ldts.ktldts1rv

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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
        listadoItems.add(ListItem("CSI1", "Juan Pérez García", "08:15-09:15 Proceso Integral de la Actividad Comercial / JYE"))

        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://lab.ldts.us/phplab/") // Reemplaza con la base URL de tu API
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService: ApiService = retrofit.create(ApiService::class.java)

        val call = apiService.getHorario()

        call.enqueue(object : Callback<List<ListItem>> {
            override fun onResponse(
                call: Call<List<ListItem>>,
                response: Response<List<ListItem>>
            ) {
                if (response.isSuccessful) {
                    val horarioList = response.body()
                    if (horarioList != null) {
                        listadoItems.clear()
                        listadoItems.addAll(horarioList)
                        adapter.notifyDataSetChanged()
                    }
                }
            }

            override fun onFailure(call: Call<List<ListItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })

        adapter = ListItemAdapter(listadoItems)
        recyclerView.adapter = adapter
    }
}