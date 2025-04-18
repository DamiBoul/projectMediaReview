package fr.devops.mediareview.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/// Retrofit est le client (bibliothèque open-source) qui permet de traduire des interface java en requête API.
public class RetrofitClient {
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}