package com.song.classification.fs.main;

import com.song.classification.svm.CaclueteSVM;
import com.song.classification.fs.ParseDocument;
import com.song.classification.fs.weight.TFIDF;
import com.song.classification.fs.chi.CacluateChi11;
import com.song.classification.fs.chi.CacluateChi2;
import com.song.classification.fs.chi.CacluateChi3;
import com.song.classification.fs.chi.CacluateChiBase;
import com.song.classification.fs.weight.TermWeightWithTFIDF;
import com.song.classification.fs.weight.Weka;
import com.song.classification.svm.svm_predict;

import java.util.Date;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/12/13
 */
public class TFIDFMain11 {
    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();
        System.out.println(new Date());
        String path = "F:\\opennlp\\fudan-s61/";
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        String subPath = "reslut1213-1.txt";
        getRes(path, trainIDF, testIDF, subPath);

        trainIDF = TFIDF.getTFIDFAll1(true);
        testIDF = TFIDF.getTFIDFAll1(false);
         subPath = "reslut1213-3.txt";
        getRes(path, trainIDF, testIDF, subPath);
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / (1.0 * 1000 * 60));
    }

    public static void getRes(String path, Map<String, Map<String, Double>> trainIDF, Map<String, Map<String, Double>> testIDF, String subPath) {
        System.out.println(new Date());
        Long t1 = System.currentTimeMillis();
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 300; i <= 4000; i += 200) {
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
            Weka.getTermWeightwithTFIDF11(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF11(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            sb.append("\r\n--------------");
            System.out.println("----------------------------------------------------------------");
        }

        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 4000; i += 200) {
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
            Weka.getTermWeightwithTFIDF2(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF2(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            sb.append("\r\n--------------");
            System.out.println("----------------------------------------------------------------");
        }

        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 4000; i += 200) {
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
            Weka.getTermWeightwithTFIDF3(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF3(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            sb.append("\r\n--------------");
            System.out.println("----------------------------------------------------------------");
        }

        sb.append("\r\n");
        sb.append("\r\n");
        System.out.println();
        System.out.println();
        flag = true;
        for (int i = 300; i <= 4000; i += 200) {
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
            Weka.getTermWeightwithTFIDFBase(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFBase(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n" + Weka.reslist);
            sb.append("\r\n--------------");
            System.out.println("----------------------------------------------------------------");
        }
        TFIDFMain.writeStrToFile(path + subPath, sb.toString());
        System.out.println(new Date());

    }
}

