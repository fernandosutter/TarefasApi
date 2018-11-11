import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import java.util.List;

public class RetroFit {

    public static void main(String[] args) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/api/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TesteApi api = retrofit.create(TesteApi.class);

        //Post
        try {
            Tarefas tarefas = new Tarefas();

            tarefas.setDescricao("estudar3");
            Call<Tarefas> call = api.postTarefas(tarefas);

            Response<Tarefas> r = call.execute();

            Tarefas t = r.body();

        System.out.println(t);

    } catch (Exception e) {
        e.printStackTrace();
    }


        //Get
        try {
            Call<List<Tarefas>> call = api.getTarefas();

            Response<List<Tarefas>> r = call.execute();

            List<Tarefas> t = r.body();

            System.out.println(t);

        } catch (Exception e) {
            e.printStackTrace();
        }


        //Get ID

        try {
            Tarefas tarefas = new Tarefas();

            Call<Tarefas> call = api.getTarefasId("1420");

            Response<Tarefas> r = call.execute();

            Tarefas t = r.body();

            System.out.println(t);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Call<Void> call = api.delete("1421");
            Response<Void> r = call.execute();
            r.isSuccessful();
            if (r.isSuccessful()) {
                System.out.println("Tarefa excluida");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {

            Tarefas tarefas = new Tarefas();
            tarefas.setId("27");
            tarefas.setDescricao("Update");
            tarefas.setDone(true);

            Call<Void> call = api.update(tarefas.getId(), tarefas);

            Response<Void> r = call.execute();
            r.isSuccessful();
            if (r.isSuccessful()) {
                System.out.println("Tarefa atualizada");
            } else {
                System.out.println("Tarefa não localizada");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
