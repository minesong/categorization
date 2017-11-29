package com.song.classifie.fs;

import java.io.File;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/18
 */
public class TermWeightWithTFIDF {
    public static void getTermWeightwithTFIDF(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi.mapCls;
        Map<String, Integer> mapSVM = CacluateChi.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF2(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi2.mapCls;
        Map<String, Integer> mapSVM = CacluateChi2.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF3(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi3.mapCls;
        Map<String, Integer> mapSVM = CacluateChi3.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF1(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi1.mapCls;
        Map<String, Integer> mapSVM = CacluateChi1.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF11(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi11.mapCls;
        Map<String, Integer> mapSVM = CacluateChi11.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF111(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi111.mapCls;
        Map<String, Integer> mapSVM = CacluateChi111.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }
    public static void getTermWeightwithTFIDFBase(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChiBase.mapCls;
        Map<String, Integer> mapSVM = CacluateChiBase.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }
    public static void getTermWeightwith4(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi4.mapCls;
        Map<String, Integer> mapSVM = CacluateChi4.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2String(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(mapCls.get(dir2.getName()) + " ");
                    sb.append(sf);
                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    private static StringBuffer map2String(Map<String, Double> scoreMap, Map<String, Integer> mapSVM) {
        //TODO
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

