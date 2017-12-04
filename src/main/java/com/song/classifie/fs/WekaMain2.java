package com.song.classifie.fs;

import com.song.classifie.svm.svm_predict;

import java.io.*;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/23
 */
public class WekaMain2 {
    public static void main(String[] args) {
        String path = "F:\\opennlp\\fudan-s6/";
        //ParseDocument.getCorpMap(path + "train");
        //ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        // 是否第一次计算chi
        boolean flag = true;
        System.out.println("原生");
        StringBuffer sb = new StringBuffer();
        sb.append("CacluateChi\r\n");
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi.featureNum = i;
            CacluateChi.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi1.featureNum = i;
            CacluateChi1.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF1(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF1(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
        sb.append("-------------------------------------------------------------\r\n");
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi11.featureNum = i;
            CacluateChi11.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF11(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF11(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi111.featureNum = i;
            CacluateChi111.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF111(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF111(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        flag = true;
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi2.featureNum = i;
            CacluateChi2.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF2(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF2(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");;
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi3.featureNum = i;
            CacluateChi3.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF3(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF3(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiBase.featureNum = i;
            CacluateChiBase.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDFBase(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFBase(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        writeStrToFile(path + "resultwekaold1129.txt", sb.toString());


        //String path = "E:\\net\\select-net/";
        //ParseDocument.getCorpMap(path + "train");
        //ParseDocument.getCorpMapWithTest(path + "test");
        trainIDF = TFIDF.getTFIDFAll1(true);
        testIDF = TFIDF.getTFIDFAll1(false);
        // 是否第一次计算chi
        flag = true;
        System.out.println("原生");
        sb = new StringBuffer();
        sb.append("CacluateChi\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi.featureNum = i;
            CacluateChi.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi1.featureNum = i;
            CacluateChi1.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF1(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF1(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi11.featureNum = i;
            CacluateChi11.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF11(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF11(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi111.featureNum = i;
            CacluateChi111.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF111(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF111(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        flag = true;
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi2.featureNum = i;
            CacluateChi2.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF2(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF2(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi3.featureNum = i;
            CacluateChi3.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF3(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF3(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        sb.append("-------------------------------------------------------------\r\n");
        flag = true;
        for (int i = 300; i <= 4000; i += 300)  {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiBase.featureNum = i;
            CacluateChiBase.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDFBase(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFBase(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path +"train.arff", path + "test.arff");
            sb.append("\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        writeStrToFile(path + "resultwekanew1129.txt", sb.toString());
       // PCHIPTFIDFMain.main(args);
    }

    public static void writeStrToFile(String path, String c) {
        try {
            FileOutputStream fos = new FileOutputStream(path);
            Writer os = new OutputStreamWriter(fos, "utf-8");
            os.write(c);
            os.flush();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
