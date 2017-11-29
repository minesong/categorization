package com.song.classifie.fs;

/**
 * @author mine_song
 * @date 2017/11/21
 */

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @author mine_song
 * @date 2017/11/12
 */
public class ParseDocument {
    public static Map<String, Map<String, List<String>>> corpMap;
    public static Map<String, Set<String>> corpSetMap;
    public static Map<String, Map<String, List<String>>> corpMaptest;
    public static Map<String, Set<String>> corpSetMaptest;
    public static void getCorpMap(String dir) {
        corpMap = new LinkedHashMap<>();
        corpSetMap = new LinkedHashMap<>();
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            Set<String> clsSet = new LinkedHashSet<>();
            Map<String, List<String>> tmp = new LinkedHashMap<>();
            for (File dir3 : dirs3) {
                String path3 = path2 + "/" + dir3.getName();
                String content = readFileWithNotCut(path3);
                List<String> list = spiltString(content);
                tmp.put(dir3.getName(), list);
                clsSet.addAll(list);
            }
            corpMap.put(dir2.getName(), tmp);
            corpSetMap.put(dir2.getName(), clsSet);
        }
    }


    public static String readFileWithNotCut(String fullPath) {
        if (StringUtils.isEmpty(fullPath)) {
            return null;
        }
        StringBuffer sb = new StringBuffer();
        InputStreamReader is = null;
        String line = null;
        BufferedReader br = null;
        try {
            is = new InputStreamReader(new FileInputStream(fullPath));
            br = new BufferedReader(is);

            while ((line = br.readLine()) != null) {
                sb.append(line).append("\r\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if (br != null) {
                br.close();
            }
            if (is != null) {
                is.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static List<String> spiltString(String content) {
        String[] strings = content.split("\\s+");
        List<String> list = new ArrayList<>();
        for (String s : strings) {
            s = s.trim();
            if (StringUtils.isNotEmpty(s) && s.length() > 1) {
                list.add(s);
            }
        }
        return list;
    }

    public static void writeStrToFile(String path, String content) {
        try {
            FileOutputStream fos = new FileOutputStream(new File(path));
            Writer os = new OutputStreamWriter(fos, "utf-8");
            os.write(content);
            os.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void getCorpMapWithTest(String dir) {
        corpMaptest = new LinkedHashMap<>();
        corpSetMaptest = new LinkedHashMap<>();
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            Set<String> clsSet = new LinkedHashSet<>();
            Map<String, List<String>> tmp = new LinkedHashMap<>();
            for (File dir3 : dirs3) {
                String path3 = path2 + "/" + dir3.getName();
                String content = readFileWithNotCut(path3);
                List<String> list = spiltString(content);
                tmp.put(dir3.getName(), list);
                clsSet.addAll(list);
            }
            corpMaptest.put(dir2.getName(), tmp);
            corpSetMaptest.put(dir2.getName(), clsSet);
        }
    }
}
