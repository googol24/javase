package com.googol24.java.collection;

import java.util.HashMap;
import java.util.Map;

public class Practice {
//    private static final Integer ONE = 1;
    private static final int ONE = 1;
    public static void main(String[] args) {
        Map m = new HashMap();

        for (int i = 0; i < args.length; i++) {
            if (!m.containsKey(args[i])) {
                m.put(args[i], ONE);
            } else {
//                Integer freq = (Integer) m.get(args[i]);
                int freq = (Integer) m.get(args[i]);
//                m.put(args[i], new Integer(freq + 1));
                m.put(args[i], freq + 1);
            }
        }

        System.out.println(m.size() + " distinct words detected:");
        System.out.println(m);
    }
}
