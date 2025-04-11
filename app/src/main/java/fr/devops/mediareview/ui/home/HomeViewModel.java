package fr.devops.mediareview.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import fr.devops.mediareview.api.IGDBApiService;
import fr.devops.mediareview.api.RetrofitClient;
import fr.devops.mediareview.config.ApiConfig;
import fr.devops.mediareview.model.Game;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;
    private final MutableLiveData<Game> mGameDetails;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
        mGameDetails = new MutableLiveData<>();
    }

    public LiveData<String> getText() {
        return mText;
    }

    /// LiveData est une classe qui peut contenir des données observables. Cela signifie que vous pouvez observer les changements de ces données et réagir en conséquence.
    /// Sources: Le Chat
    public LiveData<Game> getGameDetails() {
        return mGameDetails;
    }

    public void fetchGameDetails(String gameId) {
        IGDBApiService apiService = RetrofitClient.getClient("https://api.igdb.com/v4/").create(IGDBApiService.class);

        // On créer un corps de requête brut afin de récupérer le nom du jeu souhaité.
        String jsonBody = "fields name; where id = " + gameId + ";";
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);

        // On fait notre appel API
        Call<List<Game>> call = apiService.getGameDetails(
            ApiConfig.getClientId(),
            ApiConfig.getAuthorization(),
            body
        );

        call.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Game> games = response.body();
                    if (!games.isEmpty()) {
                        // On est supposé ne récupérer qu'un seul jeu, donc on peut ne regarder que le premier.
                        mGameDetails.setValue(games.get(0));
                    }
                    System.out.println("API Response Successful");
                } else {
                    System.out.println("API Response Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                System.out.println("API Call Failed: " + t.getMessage());
            }
        });
    }
}