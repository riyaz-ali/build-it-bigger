package com.udacity.gradle.builditbigger;

import com.udacity.gradle.builditbigger.common.Joke;
import java.util.Arrays;
  import java.util.List;
import java.util.Random;

import static java.util.Collections.unmodifiableList;

/**
 * Created on 05 Oct, 2018
 *
 * @author Riyaz
 */
public final class JokeTeller {

  // List of some pre-initialized jokes...
  private static final List<Joke> jokes = unmodifiableList(
      Arrays.asList(
          joke("[error] No keyboard! press F1 to continue."),
          joke("Best file compression around: \"DEL *.*\" = 100% compression"),
          joke("Crashing is the only thing windows does quickly.")
      )
  );

  // helper to create joke instances
  private static Joke joke(String joke){
    return Joke.builder().content(joke).build();
  }

  private Random random = new Random();

  // use factory to create instances
  private JokeTeller(){
  }

  /**
   * Get a random joke from a list of available jokes
   * @return an instance of randomly selected joke
   */
  public Joke tellAJoke(){
    return jokes.get(random.nextInt(jokes.size()));
  }

  /**
   * Get a new random joke from the teller
   * @return an instance of joke
   */
  public static Joke tellMeAJoke(){
    return getATeller().tellAJoke();
  }

  /**
   * Get a new instance of teller
   * @return an instance of teller
   */
  public static JokeTeller getATeller(){
    return new JokeTeller();
  }
}
