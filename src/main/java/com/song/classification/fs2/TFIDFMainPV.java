package com.song.classification.fs2;

import com.song.classification.fs.*;
import com.song.classification.fs.main.TFIDFMain;
import com.song.classification.fs.weight.TFIDF;
import com.song.classification.fs.weight.TermWeightWithTFIDF;
import com.song.classification.fs.weight.Weka;
import com.song.classification.svm.CaclueteSVM;
import com.song.classification.svm.svm_predict;

import java.util.Date;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/12/13
 */
public class TFIDFMainPV {
    public static void getRes(String path ){
        System.out.println(new Date());
        Long t1 = System.currentTimeMillis();
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        // 是否第一次计算chi
        boolean flag = true;
        StringBuffer sb = new StringBuffer();
        for (int i = 300; i <= 4000; i += 200) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiTFD.featureNum = i;
            CacluateChiTFD.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFTFD(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFTFD(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            Weka.getTermWeightwithTFIDFTFD(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFTFD(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n--------------");
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        TFIDFMain.writeStrToFile(path + "resulttfd1214.txt", sb.toString());
        /*flag = true;
        sb = new StringBuffer();
        for (int i = 300; i <= 2000; i += 200) {
            sb.append("\r\n");
            sb.append("featureNum: " + i);
            sb.append("\r\n");
            System.out.println("featureNum: " + i);
            CacluateChiPV.featureNum = i;
            CacluateChiPV.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFPV(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFPV(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            Weka.getTermWeightwithTFIDFPV(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFPV(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n--------------");
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        TFIDFMain.writeStrToFile(path + "resultpv1214.txt", sb.toString());*/
        System.out.println(new Date());
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / (1.0 * 1000 * 60));
    }

    public static void main(String[] args) {
        getRes("F:\\lda\\neteasy\\netimb/");
        getRes("F:\\LdaOriginalDocs\\select-net3/");
        getRes("F:\\opennlp\\fudan-s61/");
    }
}
