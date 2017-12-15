package com.song.classification.weka;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;

/**
 * @author mine_song
 * @date 2017/11/23
 */

import weka.classifiers.Evaluation;
import weka.core.Instance;

public class TestWeka {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        double [] y1 ={0.8266,	0.9156,	0.6283,	0.7040,0.8036,	0.8523,	0.6569,	0.8122};
        double [] y=  {0.8087,	0.8571,	0.6026,	0.6293,	0.7238,	0.8537,	0.6375,	0.8362};
        double [] y2 ={0.9167	,0.8861,0.7001,	0.7999,	0.7611,	0.8346,	0.7765,	0.9040};
        getAv(y);
        getAv(y1);
        getAv(y2);
        double []yy=  {86.03,	58.57,	86.15,	57.75,	84.49,	86.36};
        double []yy1 ={84.57,	65.93,	83.84,	68.83,82.65,	86.36};

        double []yy2 ={88.65,67.86,87.68,	72.96,	83.05,	88.71};
        getAv(yy);
        getAv(yy1);
        getAv(yy2);
        double []yyy=  {55.32	,70.48,	74.71,	78.31,	76.35,	91.04};
        double []yyy1 ={71.70	,85.95,	76.40,	90.07,	80.11,	94.47,	83.12};
        double []yyy2 ={ 86.66,	92.31,	76.92,	90.91	,84.24,	96.68,	87.95};
        getAv(yyy);
        getAv(yyy1);
        getAv(yyy2);
        Instances ins = null;
        Classifier cfs = null;

        try {
            // 读入训练测试样本
            File file = new File(
                    "D:\\develop\\weka\\Weka-3-8\\data\\cpu.with.vendor.arff");

            ArffLoader loader = new ArffLoader();
            loader.setFile(file);
            ins = loader.getDataSet();
            ins.setClassIndex(ins.numAttributes() - 1);

            // 初始化分类器
            cfs = (Classifier) Class.forName(
                    "weka.classifiers.bayes.NaiveBayes").newInstance();

            // 使用训练样本进行分类
            cfs.buildClassifier(ins);

            // 使用测试样本测试分类器的学习效果
            Instance testInst;
            Evaluation testingEvaluation = new Evaluation(ins);
            int length = ins.numInstances();
            for (int i = 0; i < length; i++) {
                testInst = ins.instance(i);
                testingEvaluation.evaluateModelOnceAndRecordPrediction(cfs,
                        testInst);
            }

            // 打印分类结果
            System.out.println("分类的正确率" + (1 - testingEvaluation.errorRate()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getAv(double[] y) {
        double t =0;
        for (double x:y) {
            t+=x;
        }
        t=t/y.length;
        //System.out.println(t);
        double r =0;
        for (double x:y){
            r+=Math.pow(x-t,2);
        }
        System.out.println(r/y.length);
    }
}