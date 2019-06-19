package usernameanastasia.randusersapp.Retrofit;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import usernameanastasia.randusersapp.Model.Results;

public interface IRetrofit {
    @GET("/api/")
    Call<Results> getRandomUsers(@Query("results") int results);

}
