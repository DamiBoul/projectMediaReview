package fr.devops.mediareview.api;

import java.util.List;

import fr.devops.mediareview.model.Game;
import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Body;
import okhttp3.RequestBody;
import retrofit2.http.POST;

public interface IGDBApiService {

    @POST("games")
    Call<List<Game>> getGameDetails(
        @Header("Client-ID") String clientId,
        @Header("Authorization") String authorization,
        @Body RequestBody body
    );
}