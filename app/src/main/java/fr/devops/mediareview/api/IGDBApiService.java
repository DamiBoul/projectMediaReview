package fr.devops.mediareview.api;

import java.util.List;

import fr.devops.mediareview.model.Game;
import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Headers;
import retrofit2.http.Body;
import okhttp3.RequestBody;

public interface IGDBApiService {

    @Headers({
            "Client-ID: 5nyyadn508xcp877p0stzsovjf6iz3",
            "Authorization: Bearer 3toaet87w6ghfead1xetbbqtvu0die"
    })
    @POST("games")
    Call<List<Game>> getGameDetails(@Body RequestBody body);
}