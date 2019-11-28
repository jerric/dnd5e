package net.lliira.dnd5e.common.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import net.lliira.dnd5e.common.creature.Race;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
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
    builder.registerTypeAdapter(Dice.class, diceDeserializer);
    builder.registerTypeAdapter(Length.class, lengthDeserializer);
    gson = builder.create();
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
