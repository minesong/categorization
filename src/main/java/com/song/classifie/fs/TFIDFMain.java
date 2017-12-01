package com.song.classifie.fs;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

import com.song.classifie.svm.svm_predict;

/**
 * @author mine_song
 * @date 2017/11/21
 */
public class TFIDFMain {
    public static void main(String[] args) {
        String path = "F:\\opennlp\\fudan-s6/";
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        // 是否第一次计算chi
        boolean flag = true;
        System.out.println("原生");
        StringBuffer sb = new StringBuffer();
        sb.append("CacluateChi\r\n");
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi.featureNum = i;
            CacluateChi.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi1.featureNum = i;
            CacluateChi1.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF1(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF1(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append("\r\n" + svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi11.featureNum = i;
            CacluateChi11.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF11(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF11(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
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
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        flag = true;
        sb.append("\r\n");
        sb.append("\r\n");
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi2.featureNum = i;
            CacluateChi2.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF2(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF2(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi3.featureNum = i;
            CacluateChi3.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF3(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF3(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiBase.featureNum = i;
            CacluateChiBase.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFBase(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFBase(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        writeStrToFile(path + "resultold1129.txt", sb.toString());


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
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi.featureNum = i;
            CacluateChi.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi1.featureNum = i;
            CacluateChi1.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF1(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF1(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append("\r\n" + svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi11.featureNum = i;
            CacluateChi11.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF11(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF11(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
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
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        flag = true;
        sb.append("\r\n");
        sb.append("\r\n");
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi2.featureNum = i;
            CacluateChi2.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF2(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF2(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChi3.featureNum = i;
            CacluateChi3.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDF3(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDF3(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        System.out.println();
        System.out.println();
        sb.append("\r\n");
        sb.append("\r\n");
        flag = true;
        for (int i = 300; i <= 2000; i += 100) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiBase.featureNum = i;
            CacluateChiBase.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFBase(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFBase(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            System.out.println("----------------------------------------------------------------");
        }
        writeStrToFile(path + "resultnew1129.txt", sb.toString());
        WekaMain2.main(args);
        PCHIPTFIDFMain.main(args);

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