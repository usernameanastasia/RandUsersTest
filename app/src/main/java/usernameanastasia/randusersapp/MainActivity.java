package usernameanastasia.randusersapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import usernameanastasia.randusersapp.Adapter.MyAdapter;
import usernameanastasia.randusersapp.Model.Result;
import usernameanastasia.randusersapp.Model.Results;
import usernameanastasia.randusersapp.Retrofit.IRetrofit;
import usernameanastasia.randusersapp.Retrofit.RetrofitClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        final MyAdapter adapter = new MyAdapter(MainActivity.this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        IRetrofit client = RetrofitClient.getClient().create(IRetrofit.class);
        client.getRandomUsers(20).enqueue(new Callback<Results>() {
            @Override
            public void onResponse(@NonNull Call<Results> call, @NonNull Response<Results> response) {
                assert response.body() != null;
                List<Result> results = response.body().getResults();
                adapter.setResults(results);
            }

            @Override
            public void onFailure(@NonNull Call<Results> call, @NonNull Throwable t) {
                Log.e("Progress failed", t.toString());
            }
        });
    }
}
