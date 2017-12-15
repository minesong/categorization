package com.song.classification.fs.chi;

import com.song.classification.fs.ParseDocument;

import java.util.*;

/**
 * @author mine_song
 * @date 2017/11/12
 *///一种基于多特征因子改进的中文文本分类算法
public class CacluateChi4 {
    public static Integer featureNum = 200;
    public static Map<String, Integer> mapCls;
    public static Map<String, Integer> mapSVM;
    public static Map<String, Map<String, Double>> mapCHiAll;
    public static Set<String> corpSet;
    public static double weight = 1;

    public static void getTrain(boolean flag) {
        mapCls = new HashMap<>();
        mapSVM = new HashMap<>();
        int j = 1;
        if (flag) {
            mapCHiAll = getCHiAll();
        }
        corpSet = new HashSet<>();

        Map<String, Double> fusemap = new HashMap<>();
        for (String cls : ParseDocument.corpMap.keySet()) {
            mapCls.put(cls, j++);
            Map<String, Double> map1 = mapCHiAll.get(cls);
            fuseMap(map1, fusemap);
        }
        System.out.println("总特征词个数：" + fusemap.size());
        fusemap = sortMap(fusemap);
        System.out.println("总特征词个数：" + fusemap.size());

        int index = 1;
        for (String s : fusemap.keySet()) {
            mapSVM.put(s, index);
            index++;
        }
    }

    private static void fuseMap(Map<String, Double> stringDoubleMap, Map<String, Double> fusemap) {
        for (Map.Entry<String, Double> entry : stringDoubleMap.entrySet()) {
            Double v = fusemap.get(entry.getKey());
            if (v == null) {
                fusemap.put(entry.getKey(), entry.getValue());
            } else {
                if (v.compareTo(entry.getValue()) < 0) {
                    fusemap.put(entry.getKey(), entry.getValue());
                }
            }
        }
    }

    public static Map<String, Double> sortMap(Map<String, Double> map) {
        PriorityQueue<Map.Entry<String, Double>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            priorityQueue.offer(entry);
            if (priorityQueue.size() > featureNum) {
                priorityQueue.poll();
            }
        }
        Map<String, Double> doubleMap = new HashMap<>();
        for (Map.Entry<String, Double> entry : priorityQueue) {
            doubleMap.put(entry.getKey(), entry.getValue());
        }
        return doubleMap;
    }

    public static Map<String, Map<String, Double>> getCHiAll() {
        Map<String, Map<String, Double>> allChiMap = new LinkedHashMap<>();
        Map<String, Set<String>> corpSetMap = ParseDocument.corpSetMap;
        for (String cls : corpSetMap.keySet()) {
            Map<String, Double> map = getCHiWithOneClass(cls);
            allChiMap.put(cls, map);
        }
        //System.out.println(allChiMap.get("IT"));
        return allChiMap;

    }

    public static Map<String, Double> getCHiWithOneClass(String cls) {

        Map<String, Double> map = new HashMap<>();
        Map<String, Set<String>> corpSetMap = ParseDocument.corpSetMap;
        Set<String> clsset = corpSetMap.get(cls);
        for (String s : clsset) {
            Double w = getCHiWithOneFeature(cls, s);
            map.put(s, w);

        }
        return map;
    }

    public static double getCHiWithOneFeature(String cls, String feature) {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;
        int t = 0;
        int ci = 0;
        int ba = 0;
        int ta = 0;
        Map<String, Map<String, List<String>>> corpMap = ParseDocument.corpMap;
        for (String s : corpMap.keySet()) {
            Map<String, List<String>> map = corpMap.get(s);
            int tmp = 0;
            for (List<String> list : map.values()) {
                if (s.equals(cls)) {
                    if (list.contains(feature)) {

                        a++;
                        tmp++;
                        int idx = 0;
                        for (String s1 : list) {
                            if (s1.equals(feature)) {
                                t++;
                                if (idx < 6) {
                                    ta++;
                                } else {
                                    ba++;
                                }
                            }
                            idx++;
                        }
                    } else {
                        c++;
                    }
                } else {
                    if (list.contains(feature)) {
                        b++;
                        tmp++;
                        for (String s1 : list) {
                            if (s1.equals(feature)) {
                                t++;
                            }
                        }
                    } else {
                        d++;
                    }
                }
            }
            if (tmp > 0) {
                ci++;
            }
        }
        Double chi = new ChiSquare(feature, a, b, c, d).getChisq();
        double bb = corpMap.keySet().size() * 1.0 / ci * (a / (a + c)) * ((1.2 * ta + 0.8 * ba) / t);
        chi = chi * bb;
        return chi;

    }
}
