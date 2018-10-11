package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.udacity.gradle.builditbigger.backend.jokeApi.JokeApi;
import com.udacity.gradle.builditbigger.common.Joke;
import com.udacity.gradle.builditbigger.myandroidlibrary.JokeDisplayActivity;
import java.io.IOException;

/**
 * Created on 11 Oct, 2018
 *
 * @author Riyaz
 */
public class FetchJokeAsyncTask extends AsyncTask<Void, Void, String> {

  private Context context;

  public FetchJokeAsyncTask(Context context){
    this.context = context;
  }

  @Override protected String doInBackground(Void... voids) {
    JokeApi api =
        new JokeApi.Builder(
            AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null
        ).setRootUrl(BuildConfig.URL).build();

    try {
      return api.getJoke().execute().getJoke();
    } catch (IOException e) {
      Log.e("[fetch-joke]", "Failed to fetch joke from server", e);
      return null;
    }
  }

  @Override protected void onPostExecute(String s) {
    Intent intent = JokeDisplayActivity.intentToDisplayJoke(context, Joke.builder().content(s).build());
    context.startActivity(intent);
  }
}
