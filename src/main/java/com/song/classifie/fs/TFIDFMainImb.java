package com.song.classifie.fs;

import com.song.classifie.svm.svm_predict;

import java.util.Date;
import java.util.Map;

/**
 * @author mine_song
 * @date 2017/12/5
 */
public class TFIDFMainImb {

    public static void main(String[] args) {
        System.out.println(new Date());
        Long t1 = System.currentTimeMillis();
        String path = "F:\\opennlp\\fudan-s61/";
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
            CacluateChiImb.featureNum = i;
            CacluateChiImb.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFImb(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFImb(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            Weka.getTermWeightwithTFIDFImb(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFImb(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n--------------");
            //sb.append("\r\n" + Weka.knn4);
            //sb.append("\r\n" + Weka.knn7);
            //sb.append("\r\n" + Weka.knn15);
            sb.append("\r\n" + Weka.reslist);
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
            CacluateChiImb1.featureNum = i;
            CacluateChiImb1.getTrain(flag);
            flag = false;
            TermWeightWithTFIDF.getTermWeightwithTFIDFImb1(path + "train", path + "train.txt", trainIDF);
            TermWeightWithTFIDF.getTermWeightwithTFIDFImb1(path + "test", path + "test.txt", testIDF);
            CaclueteSVM.caclueteSVM(path);
            sb.append(svm_predict.f1Scores.toString());
            sb.append("\r\n" + svm_predict.micro);
            sb.append("\r\n" + svm_predict.macro);
            Weka.getTermWeightwithTFIDFImb1(path + "train", path + "train.arff", trainIDF);
            Weka.getTermWeightwithTFIDFImb1(path + "test", path + "test.arff", testIDF);
            Weka.wekaClassifier(path + "train.arff", path + "test.arff");
            sb.append("\r\n\r\n" + Weka.j48);
            sb.append("\r\n" + Weka.nb);
            sb.append("\r\n" + Weka.rf);
            sb.append("\r\n--------------");
            //sb.append("\r\n" + Weka.knn4);
            //sb.append("\r\n" + Weka.knn7);
            //sb.append("\r\n" + Weka.knn15);
            sb.append("\r\n" + Weka.reslist);
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
            sb.append("\r\n--------------");
            //sb.append("\r\n" + Weka.knn4);
            //sb.append("\r\n" + Weka.knn7);
            //sb.append("\r\n" + Weka.knn15);
            sb.append("\r\n" + Weka.reslist);
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
            sb.append("\r\n--------------");
            //sb.append("\r\n" + Weka.knn4);
            //sb.append("\r\n" + Weka.knn7);
            //sb.append("\r\n" + Weka.knn15);
            sb.append("\r\n" + Weka.reslist);
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
            sb.append("\r\n--------------");
            //sb.append("\r\n" + Weka.knn4);
            //sb.append("\r\n" + Weka.knn7);
            //sb.append("\r\n" + Weka.knn15);
            sb.append("\r\n" + Weka.reslist);
            System.out.println("----------------------------------------------------------------");
        }
        TFIDFMain.writeStrToFile(path + "resultimb1210.txt", sb.toString());
        System.out.println(new Date());
        Long t2 = System.currentTimeMillis();
        System.out.println((t2 - t1) / (1.0 * 1000 * 60));
    }
}

