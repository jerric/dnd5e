package net.lliira.dnd5e.common.creature;

import com.google.gson.Gson;
import net.lliira.dnd5e.common.util.ResourceLoader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class RaceFactory {
    private final List<Race> races;

    public RaceFactory() {
        races = loadRaces();
    }

    public Race[] getRaces() {
        return races.toArray(new Race[0]);
    }

    private List<Race> loadRaces() {
        Gson gson = new Gson();
        var files = ResourceLoader.getResources("creature/race");
        var races = new ArrayList<Race>(files.length);
        for (File file : files) {
            try {
                var race = gson.fromJson(new FileReader(file), Race.class);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return races;
    }
}
