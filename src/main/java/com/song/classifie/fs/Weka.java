package com.song.classifie.fs;

import org.apache.commons.lang3.builder.ToStringBuilder;
import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.lazy.IBk;
import weka.classifiers.trees.J48;
import weka.classifiers.trees.RandomForest;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.pmml.jaxbbindings.SupportVectorMachine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.nlpcn.commons.lang.tire.domain.Forest;

/**
 * @author mine_song
 * @date 2017/11/23
 */
class Node {
    public double p;
    public double r;
    public double f;
    public double micf;
    public List<Node> list;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}

public class Weka {
    public static double j48;
    public static double nb;
    public static double rf;
    public static double knn15;
    public static double knn4;
    public static double knn7;
    public static List<Node> reslist = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println(Math.log(4));
        System.out.println(Math.log(4) / Math.log(2));
        String path = "E:\\net/";
        Weka.wekaClassifier(path + "train.arff", path + "test.arff");
    }

    public static void wekaClassifier(String trainpath, String testpath) {
        reslist = new ArrayList<>();
        Classifier m_classifier = new J48();
        j48 = classifier(trainpath, testpath, m_classifier);
        m_classifier = new NaiveBayes();
        nb = classifier(trainpath, testpath, m_classifier);
        m_classifier = new RandomForest();
        rf = classifier(trainpath, testpath, m_classifier);
        System.out.println("--------------------------------------------------------");
        // m_classifier = new IBk(4);
        //knn4 = classifier(trainpath, testpath, m_classifier);
        // m_classifier = new IBk(7);
        // knn7 = classifier(trainpath, testpath, m_classifier);
        // m_classifier = new IBk(15);
        // knn15 = classifier(trainpath, testpath, m_classifier);
    }

    private static double classifier(String trainpath, String testpath, Classifier m_classifier) {
        File inputFile = new File(trainpath);// 训练语料文件
        double res = 0;
        ArffLoader atf = new ArffLoader();
        try {
            atf.setFile(inputFile);
            Instances instancesTrain = atf.getDataSet(); // 读入训练文件
            inputFile = new File(testpath);// 测试语料文件
            atf.setFile(inputFile);
            Instances instancesTest = atf.getDataSet(); // 读入测试文件
            instancesTest.setClassIndex(instancesTest.numAttributes() - 1); // 设置分类属性所在行号（第一行为0号），instancesTest.numAttributes()可以取得属性总数
            double sum = instancesTest.numInstances(), // 测试语料实例数
                    right = 0.0f;
            instancesTrain.setClassIndex(instancesTrain.numAttributes() - 1);
            m_classifier.buildClassifier(instancesTrain); // 训练
            List<Double> pre = new ArrayList<Double>();
            List<Double> last = new ArrayList<Double>();
            for (int i = 0; i < sum; i++)// 测试分类结果
            {
                pre.add(m_classifier.classifyInstance(instancesTest.instance(i)));
                last.add(instancesTest.instance(i).classValue());
            }
            Set<Double> set = new LinkedHashSet<>(last);
            Node node = new Node();
            List<Node> list = new ArrayList<>();
            node.list = list;
            double macp = 0;
            double macr = 0;
            for (Double d : set) {
                int t = 0;
                int f = 0;
                int rec = 0;
                Node n = new Node();
                for (int i = 0; i < sum; i++) {
                    if (d.equals(pre.get(i))) {
                        rec++;
                    }
                    if (d.equals(last.get(i))) {
                        if (pre.get(i).equals(d)) {
                            right++;
                            t++;
                            continue;
                        }
                        f++;
                    }
                }
                n.p = t * 1.0 / (t + f);
                n.r = t * 1.0 / rec;
                n.f = 2 * n.p * n.r / (n.p + n.r);
                list.add(n);
                macp += n.p;
                macr += n.r;
                System.out.println(d + " " + n.p + " " + n.r + " " + n.f);
            }
            node.p = macp / set.size();
            node.r = macr / set.size();
            node.f = 2 * node.p * node.r / (node.p + node.r);
            node.micf= right / sum;
            reslist.add(node);
            System.out.println("classification precision:" + (right / sum) + " " + node.f);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void getTermWeightwithTFIDF(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi.mapCls;
        Map<String, Integer> mapSVM = CacluateChi.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

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
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

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
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

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
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

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
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

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
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDF4(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChi4.mapCls;
        Map<String, Integer> mapSVM = CacluateChi4.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDFBase(String dir, String subDir,
                                                  Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChiBase.mapCls;
        Map<String, Integer> mapSVM = CacluateChiBase.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    private static StringBuffer map2WekaString(Map<String, Double> scoreMap, Map<String, Integer> mapSVM) {
        // TODO
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            String tmp = "0";
            Double s = scoreMap.get(entry.getKey());
            if (s != null) {
                tmp = String.format("%.4f", s);
            }
            sb.append(tmp + ",");
        }
        return sb;
    }

    public static void getTermWeightwithTFIDFImb(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChiImb.mapCls;
        Map<String, Integer> mapSVM = CacluateChiImb.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }

    public static void getTermWeightwithTFIDFImb1(String dir, String subDir, Map<String, Map<String, Double>> tfidfMap) {
        Map<String, Integer> mapCls = CacluateChiImb1.mapCls;
        Map<String, Integer> mapSVM = CacluateChiImb1.mapSVM;
        File dir1 = new File(dir);
        File[] dirs2 = dir1.listFiles();
        StringBuffer sb = new StringBuffer();
        sb.append("@RELATION net\r\n");
        for (Map.Entry<String, Integer> entry : mapSVM.entrySet()) {
            sb.append("@ATTRIBUTE  " + entry.getValue() + "  NUMERIC\r\n");
        }
        sb.append("@ATTRIBUTE class   {");
        int indx = 1;
        for (Map.Entry<String, Integer> entry : mapCls.entrySet()) {
            sb.append(entry.getKey());
            if (indx != mapCls.size()) {
                sb.append(",");
            }
            indx++;
        }
        sb.append("}\r\n");
        sb.append("@DATA\r\n");
        for (File dir2 : dirs2) {
            String path2 = dir + "/" + dir2.getName();
            File dir33 = new File(path2);
            File[] dirs3 = dir33.listFiles();
            for (File dir3 : dirs3) {
                Map<String, Double> scoreMap = tfidfMap.get(dir3.getName());
                StringBuffer sf = map2WekaString(scoreMap, mapSVM);
                if (sf.length() >= 2) {
                    sb.append(sf);
                    sb.append(dir2.getName() + "\r\n");

                }
            }
        }
        ParseDocument.writeStrToFile(subDir, sb.toString());
    }
}
