import retrofit2.Call;
import retrofit2.http.*;
import java.util.List;

public interface TesteApi {

    @Headers("Student:1111008023")
    @GET("tasks")
    Call<List<Tarefas>> getTarefas();

    @Headers("Student: 1111008023")
    @POST("tasks")
    Call<Tarefas> postTarefas(@Body Tarefas tarefas);

    @Headers("Student:1111008023")
    @GET("tasks/{id}")
    Call<Tarefas> getTarefasId(@Path("id") String id);

    @Headers("Student:1111008023")
    @PUT("tasks/{id}")
    Call<Void> update(@Path("id") String id, @Body Tarefas description);

    @Headers("Student:1111008023")
    @DELETE("tasks/{id}")
    Call<Void> delete(@Path("id") String id);
}
