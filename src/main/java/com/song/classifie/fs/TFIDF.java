package com.song.classifie.fs;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/17
 */
public class TFIDF {
    public static Map<String, Map<String, Double>> getTFIDFAll(boolean flag) {
        Map<String, Map<String, Double>> res = new HashMap<>();
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;

        for (String key : corpMap.keySet()) {
            Map<String, List<String>> map = corpMap.get(key);
            for (String doc : map.keySet()) {
                res.put(doc, getTFIDFWithOneDoc(key, doc, flag));
            }
        }
        return res;
    }

    public static Map<String, Double> getTFIDFWithOneDoc(String dir, String doc, boolean flag) {
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;
        List<String> list = corpMap.get(dir).get(doc);

        Map<String, Double> map = new HashMap<>();

        if (list == null) {
            return map;
        }
        double total = 0.0;
        for (String word : list) {
            int count = 0;
            int tf = 0;
            int num = 0;
            if (map.containsKey(word)) {
                continue;
            }
            for (String s : list) {
                if (s.equals(word)) {
                    tf++;
                }
            }
            for (String s : corpMap.keySet()) {
                for (List<String> strings : corpMap.get(s).values()) {
                    num++;
                    if (strings.contains(word)) {
                        count++;
                    }
                }
            }
            double tfidf = tf * 1.0 / list.size() * Math.log(num * 1.0 / count + 0.5) / Math.log(2);
            total += tfidf * tfidf;
            map.put(word, tfidf);
        }
        total = Math.sqrt(total);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() * 1.0 / total);
        }
        return map;
    }

    public static Map<String, Map<String, Double>> getTFIDFAll1(boolean flag) {
        Map<String, Map<String, Double>> res = new HashMap<>();
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;

        for (String key : corpMap.keySet()) {
            Map<String, List<String>> map = corpMap.get(key);
            for (String doc : map.keySet()) {
                res.put(doc, getTFIDFWithOneDoc1(key, doc, flag));
            }
        }
        return res;
    }

    public static Map<String, Double> getTFIDFWithOneDoc1(String dir, String doc, boolean flag) {
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;
        List<String> list = corpMap.get(dir).get(doc);

        Map<String, Double> map = new HashMap<>();

        if (list == null) {
            return map;
        }
        double total = 0.0;
        for (String word : list) {
            int count = 0;
            int tf = 0;
            int num = 0;
            if (map.containsKey(word)) {
                continue;
            }
            for (String s : list) {
                if (s.equals(word)) {
                    tf++;
                }
            }
            int sub = 0;
            for (int i = 0; i < Math.min(20, list.size()); i++) {
                if (word.equals(list.get(i))) {
                    sub++;
                }
            }
            double tf1 = (Math.log(1 + sub) / Math.log(2) + 1) * tf;
            for (String s : corpMap.keySet()) {
                for (List<String> strings : corpMap.get(s).values()) {
                    num++;
                    if (strings.contains(word)) {
                        count++;
                    }
                }
            }
            double tfidf = tf1 * 1.0 / list.size() * Math.log(num * 1.0 / count + 0.5) / Math.log(2);
            total += tfidf * tfidf;
            map.put(word, tfidf);
        }
        total = Math.sqrt(total);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() * 1.0 / total);
        }
        return map;
    }

    //一种基于多特征因子改进的中文文本分类算法
    public static Map<String, Map<String, Double>> getTFIDFAll2(boolean flag) {
        Map<String, Map<String, Double>> res = new HashMap<>();
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;

        for (String key : corpMap.keySet()) {
            Map<String, List<String>> map = corpMap.get(key);
            for (String doc : map.keySet()) {
                res.put(doc, getTFIDFWithOneDoc2(key, doc, flag));
            }
        }
        return res;
    }

    public static Map<String, Double> getTFIDFWithOneDoc2(String dir, String doc, boolean flag) {
        Map<String, Map<String, List<String>>> corpMap = null;
        if (flag)
            corpMap = ParseDocument.corpMap;
        else
            corpMap = ParseDocument.corpMaptest;
        List<String> list = corpMap.get(dir).get(doc);

        Map<String, Double> map = new HashMap<>();

        if (list == null) {
            return map;
        }
        double total = 0.0;
        for (String word : list) {
            int count = 0;
            int tf = 0;
            int tft = 0;
            int num = 0;
            if (map.containsKey(word)) {
                continue;
            }
            int idx = 0;
            for (String s : list) {
                if (s.equals(word)) {
                    if (idx < 6) {
                        tft++;
                    } else {
                        tf++;
                    }
                }
                idx++;
            }
            for (String s : corpMap.keySet()) {
                for (List<String> strings : corpMap.get(s).values()) {
                    num++;
                    if (strings.contains(word)) {
                        count++;
                    }
                }
            }
            double tfidf = (tft * 1.2 + tf * 0.8) * 1.0 / list.size() * Math.log(num * 1.0 / count + 0.5) / Math.log(2) * Math.log(word.length() * 1.0 + 3) / Math.log(2.718); /*/ Math.log(2)*/
            ;
            total += tfidf * tfidf;
            map.put(word, tfidf);
        }
        total = Math.sqrt(total);
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            map.put(entry.getKey(), entry.getValue() * 1.0 / total);
        }
        return map;
    }
}