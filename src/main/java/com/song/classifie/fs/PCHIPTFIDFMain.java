package com.song.classifie.fs;

import com.song.classifie.svm.svm_predict;

import java.io.*;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/25
 */
//一种基于多特征因子改进的中文文本分类算法
public class PCHIPTFIDFMain {
    public static void main(String[] args) {
        String path = "F:\\opennlp\\fudan-s1/";
        //ParseDocument.getCorpMap(path + "train");
        //ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll2(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll2(false);
        // 是否第一次计算chi
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi4.featureNum = i;
            CacluateChi4.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwith4(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwith4(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append("\r\n" +svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            Weka.getTermWeightwithTFIDF4(path + "train", path  + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF4(path + "test", path  + "test.arff", testIDF);
            Weka.wekaClassifier(path  + "train.arff", path  + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
         trainIDF = TFIDF.getTFIDFAll(true);
         testIDF = TFIDF.getTFIDFAll(false);
        // 是否第一次计算chi
        flag = true;
        sb.append("\r\n--------------------------------------------------------------\r\n");
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi111.featureNum = i;
            CacluateChi111.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF111(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF111(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append("\r\n" +svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
            Weka.getTermWeightwithTFIDF111(path + "train", path  + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF111(path + "test", path  + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
        }
        trainIDF = TFIDF.getTFIDFAll1(true);
        testIDF = TFIDF.getTFIDFAll1(false);
        // 是否第一次计算chi
        //flag = true;
        sb.append("\r\n--------------------------------------------------------------\r\n");
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi111.featureNum = i;
            CacluateChi111.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF111(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF111(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append("\r\n" +svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
            Weka.getTermWeightwithTFIDF111(path + "train", path  + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF111(path + "test", path  + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
        }
        writeStrToFile(path + "resultPCHIPTFID1129.txt", sb.toString());
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
