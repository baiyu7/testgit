package com.by;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Demo {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("a", 1);

        String grop = "";
        for (Map.Entry<String, Integer> maps : map.entrySet()) {
            grop = maps.getKey();

        }
        System.out.println(grop);

    }

    public static Map<String, Integer> getDeleteKv(Map<String, Integer> map, String key) {
        Map<String, Object> m = new HashMap<>();
        Iterator iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String k = (String) iterator.next();
            if (key.equals(k)) {
                iterator.remove();
            }
        }
        return map;
    }
}
