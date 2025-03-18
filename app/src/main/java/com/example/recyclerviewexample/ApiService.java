package com.example.recyclerviewexample;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("https://server.samuelgd.com/api/ConsultaGastos.php") // Reemplaza con la URL de tu API
    Call<List<Usuario>> getUsuarios();
}
