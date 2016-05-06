package com.terryx.utils;

import java.util.*;

/**
 * Map 排序类
 * Created by xueta on 2016/4/18 19:43.
 */
public class MapSort {
    public static Map<Integer, Double> sortMap(Map<Integer, Double> oldMap) {
        ArrayList<Map.Entry<Integer, Double>> list = new ArrayList<Map.Entry<Integer, Double>>(oldMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Double>>() {

            public int compare(Map.Entry<Integer, Double> arg0, Map.Entry<Integer, Double> arg1) {
                return - arg0.getValue().compareTo(arg1.getValue());
            }
        });
        Map newMap = new LinkedHashMap();
        for (Map.Entry<Integer, Double> aList : list) {
            newMap.put(aList.getKey(), aList.getValue());
        }
        return newMap;
    }
}


