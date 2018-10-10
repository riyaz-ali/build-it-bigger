package com.udacity.gradle.builditbigger.myandroidlibrary;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import com.udacity.gradle.builditbigger.common.Joke;

public class JokeDisplayActivity extends AppCompatActivity {

  public static Intent intentToDisplayJoke(Context context, Joke joke){
    return new Intent(context, JokeDisplayActivity.class).putExtra("joke", new JokeParceller(joke));
  }

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_joke_display);

    Joke joke = ((JokeParceller) getIntent().getParcelableExtra("joke")).joke;

    TextView tv = findViewById(R.id.textview_joke);
    tv.setText(joke.content());
  }

  // helper to help parcel a java object
  static class JokeParceller implements Parcelable {
    final Joke joke;

    JokeParceller(Joke joke){
      this.joke = joke;
    }

    JokeParceller(Parcel in) {
      this.joke = Joke.builder().content(in.readString()).build();
    }

    public static final Creator<JokeParceller> CREATOR = new Creator<JokeParceller>() {
      @Override
      public JokeParceller createFromParcel(Parcel in) {
        return new JokeParceller(in);
      }

      @Override
      public JokeParceller[] newArray(int size) {
        return new JokeParceller[size];
      }
    };

    @Override public int describeContents() {
      return 0;
    }

    @Override public void writeToParcel(Parcel dest, int flags) {
      dest.writeString(joke.content());
    }
  }
}
