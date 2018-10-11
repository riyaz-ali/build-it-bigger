package com.udacity.gradle.builditbigger.backend;

import com.udacity.gradle.builditbigger.common.Joke;

/**
 * Created on 11 Oct, 2018
 *
 * @author Riyaz
 */
public class JokeBean {

  private String joke;

  public void setJoke(Joke joke){
    this.joke = joke.content();
  }

  public String getJoke() {
    return joke;
  }
}
