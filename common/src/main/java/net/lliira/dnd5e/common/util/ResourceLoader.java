package net.lliira.dnd5e.common.util;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ResourceLoader {
    public static <T> List<T> getResources(String path, Class<T> entityClass) {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        URL url = loader.getResource(path);
        File[] files = new File(url.getPath()).listFiles();
        List<T> entities = new ArrayList<>();
        
    }
}
