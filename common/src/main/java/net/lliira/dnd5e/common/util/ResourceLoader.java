package net.lliira.dnd5e.common.util;

import java.io.File;
import java.net.URL;

public class ResourceLoader {
    public static File[] getResources(String path) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(path);
        return new File(url.getPath()).listFiles();
    }
}
