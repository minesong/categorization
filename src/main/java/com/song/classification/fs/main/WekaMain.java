package com.song.classification.fs.main;

import com.song.classification.fs.ParseDocument;
import com.song.classification.fs.weight.TFIDF;
import com.song.classification.fs.chi.CacluateChi;
import com.song.classification.fs.weight.Weka;

import java.util.Map;

/**
 * @author mine_song
 * @date 2017/11/23
 */
public class WekaMain {
    public static void main(String[] args) {
        String path = "F:\\opennlp\\fudan-s1/";
        ParseDocument.getCorpMap(path + "train");
        ParseDocument.getCorpMapWithTest(path + "test");
        Map<String, Map<String, Double>> trainIDF = TFIDF.getTFIDFAll(true);
        Map<String, Map<String, Double>> testIDF = TFIDF.getTFIDFAll(false);
        //是否第一次计算chi
        boolean flag = true;

        for (int i = 300; i <= 1600; i += 100) {
            CacluateChi.featureNum = i;
            System.out.println("featureNum: " + i);
            CacluateChi.getTrain(flag);
            flag = false;
            Weka.getTermWeightwithTFIDF(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDF(path + "test", path  + "test.arff", testIDF);
            Weka.wekaClassifier(path  + "train.arff", path  + "test.arff");
        }
        System.out.println();
        System.out.println();
    }
}
