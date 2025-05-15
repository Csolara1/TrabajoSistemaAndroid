package us.ldts.ktldts1rv;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("https://lab.ldts.us/phplab/pru1.php") // Reemplaza con la URL de tu API
    Call<List<ListItem>> getHorario();
}
