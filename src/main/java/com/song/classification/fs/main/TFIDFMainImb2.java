package com.song.classification.fs.main;

import com.song.classification.svm.CaclueteSVM;
import com.song.classification.fs.ParseDocument;
import com.song.classification.fs.weight.TFIDF;
import com.song.classification.fs.chi.CacluateChi11;
import com.song.classification.fs.chi.CacluateChiImb;
import com.song.classification.fs.weight.TermWeightWithTFIDF;
import com.song.classification.fs.weight.Weka;
import com.song.classification.svm.svm_predict;

import java.util.Date;
import java.util.Map;

public class TFIDFMainImb2 {

    public static void main(String[] args) {
        System.out.println(new Date());
        Long t1 = System.currentTimeMillis();
        String path = "F:\\lda\\neteasy\\netimb/";
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        StringBuffer sb = new StringBuffer();
        for (int w = 1; w <= 11; w += 2) {
            CacluateChiImb.weight = w;
            sb.append("\r\n");
            sb.append("\r\n");
            sb.append("featureNum weight: " + w);
            sb.append("\r\n");
            sb.append("\r\n");
            // 是否第一次计算chi
            boolean flag = true;
            for (int i = 300; i <= 2000; i += 200) {
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
                System.out.println("----------------------------------------------------------------");
            }
            System.out.println();
            System.out.println();
        }
        TFIDFMain.writeStrToFile(path + "resultimb1212.txt", sb.toString());
        System.out.println(new Date());
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / (1.0 * 1000 * 60));
    }

    public static void main1(String[] args) {
        System.out.println(new Date());
        Long t1 = System.currentTimeMillis();
        String path = "F:\\lda\\neteasy\\netimb/";
        ParseDocument.getCorpMap(path + "train");
        CacluateChiImb.schi = new StringBuffer();
        CacluateChiImb.getCHiAll();
        TFIDFMain.writeStrToFile(path + "resultimbschi.txt", CacluateChiImb.schi.toString());
        CacluateChiImb.schi = null;
        System.out.println(new Date());
        path = "F:\\LdaOriginalDocs\\select-net3/";
        ParseDocument.getCorpMap(path + "train");
        CacluateChiImb.schi = new StringBuffer();
        CacluateChiImb.getCHiAll();
        TFIDFMain.writeStrToFile(path + "resultimbschi.txt", CacluateChiImb.schi.toString());
        CacluateChiImb.schi = null;
        System.out.println(new Date());
        path = "F:\\opennlp\\fudan-s61/";
        ParseDocument.getCorpMap(path + "train");
        CacluateChiImb.schi = new StringBuffer();
        CacluateChiImb.getCHiAll();
        TFIDFMain.writeStrToFile(path + "resultimbschi.txt", CacluateChiImb.schi.toString());
        CacluateChiImb.schi = null;
        System.out.println(new Date());
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / (1.0 * 1000 * 60));
    }

}
