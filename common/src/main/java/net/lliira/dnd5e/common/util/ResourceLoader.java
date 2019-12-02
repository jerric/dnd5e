package net.lliira.dnd5e.common.util;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResourceLoader {

  private static final Gson gson;

  static {
    var builder = new GsonBuilder();
    JsonDeserializer<Dice> diceDeserializer =
        (json, type, context) -> new Dice(json.getAsJsonPrimitive().getAsString());
    JsonDeserializer<Length> lengthDeserializer =
        (json, type, context) -> new Length(json.getAsJsonPrimitive().getAsString());
    gson = new GsonBuilder()
        .registerTypeAdapter(Dice.class, diceDeserializer)
        .registerTypeAdapter(Length.class, lengthDeserializer)
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .create();
  }

  public static <T> List<T> getResources(String path, Class<T> entityClass) {
    ClassLoader loader = Thread.currentThread().getContextClassLoader();
    URL url = loader.getResource(path);
    File[] files = new File(url.getPath()).listFiles();
    var entities = new ArrayList<T>();
    if (files != null) {
      for (var file : files) {
        try {
          var entity = gson.fromJson(new FileReader(file), entityClass);
          entities.add(entity);
        } catch (FileNotFoundException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return entities;
  }
}
