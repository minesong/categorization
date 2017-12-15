package com.song.classification.fs.main;

import com.song.classification.svm.CaclueteSVM;
import com.song.classification.fs.ParseDocument;
import com.song.classification.fs.weight.TFIDF;
import com.song.classification.fs.chi.CacluateChi;
import com.song.classification.fs.weight.TermWeightWithTFIDF;

import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/21
 */
public class TFIDFMain2 {
    public static void main(String[] args) {
        String path = "F:\\LdaOriginalDocs\\net\\select-net/";
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        //是否第一次计算chi
        boolean flag = true;
        System.out.println("原生");
        for (int i = 1200; i <= 1600; i += 200) {
            for (int k = 1; k <= 20; k++) {
                System.out.println("weight: " + k);
                CacluateChi.featureNum = i;
                CacluateChi.weight = k;
                CacluateChi.getTrain(flag);
                TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "train", path + "train.txt", trainIDF);
                TermWeightWithTFIDF.getTermWeightwithTFIDF(path + "test", path + "test.txt", testIDF);
                CaclueteSVM.caclueteSVM(path);
                System.out.println("----------------------------------------------------------------");
            }
        }
        System.out.println();
        System.out.println();
    }
}