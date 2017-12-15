package com.song.classification.fs.weight;
import com.song.classification.fs.ParseDocument;
import com.song.classification.fs.chi.CacluateChi;

import java.io.File;
import java.util.Map;

public class TermWeightWithTFIDF2 {
    public static void getTermWeightwithTFIDF(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi.mapCls;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    private static StringBuffer map2String(Map<String, Double> scoreMap) {
        //TODO
        Map<String, Integer> mapSVM = CacluateChi.mapSVM;
        StringBuffer sb = new StringBuffer();
        double total = 0;
        for (Map.Entry<String, Double> entry : scoreMap.entrySet()) {
            total += Math.pow(entry.getValue(), 2);
            Double max = entry.getValue();
            if (entry.getKey() == null) {
                continue;
            }
            Integer i = mapSVM.get(entry.getKey());
            if (i == null) {
                continue;
            }
            if (max == null) {
                continue;
            }

            sb.append(i + ":" + String.format("%.4f", max) + " ");
        }
        sb.append("\r\n");
        return sb;
    }
}