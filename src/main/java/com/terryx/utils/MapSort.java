package com.terryx.utils;

import java.util.*;

/**
 * Map 排序类
 * Created by xueta on 2016/4/18 19:43.
 */
public class MapSort {
    public static Map<String, Double> sortMap(Map oldMap) {
        ArrayList<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(oldMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {

            public int compare(Map.Entry<String, Double> arg0, Map.Entry<String, Double> arg1) {
                return - arg0.getValue().compareTo(arg1.getValue());
            }
        });
        Map newMap = new LinkedHashMap();
        for (Map.Entry<String, Double> aList : list) {
            newMap.put(aList.getKey(), aList.getValue());
        }
        return newMap;
    }
}


