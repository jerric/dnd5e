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
        races = ResourceLoader.getResources("creature/race", Race.class);
    }

    public Race[] getRaces() {
        return races.toArray(new Race[0]);
    }
}
