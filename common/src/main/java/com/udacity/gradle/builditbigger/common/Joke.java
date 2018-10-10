package com.udacity.gradle.builditbigger.common;

/**
 * Created on 05 Oct, 2018
 *
 * @author Riyaz
 */
public class Joke {
  // content of the joke
  private String content;

  // use Builder to create a joke
  private Joke(Builder builder){
    this.content = builder.content;
  }

  /**
   * Get the content of the joke
   * @return String with the joke's content
   */
  public String content(){
    return content;
  }

  /**
   * Create a new Joke.Builder instance
   * @return an instance of Builder to create a new Joke
   */
  public static Builder builder(){
    return new Builder();
  }

  // builder to create a Joke
  public static class Builder {
    // joke content
    private String content;

    /** Set the Joke's content */
    public Builder content(String content){
      if(null == content){
        throw new IllegalArgumentException("content must not be null");
      }
      this.content = content;
      return this;
    }

    /** Build the Joke instance */
    public Joke build(){
      if(null == this.content){
        throw new IllegalStateException("initialize joke with content first");
      }
      return new Joke(this);
    }
  }
}
