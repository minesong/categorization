package com.song.classifie.weka;

import weka.classifiers.Classifier;
import weka.classifiers.bayes.NaiveBayes;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.io.IOException;

/**
 * @author mine_song
 * @date 2017/11/23
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

public class TestWeka {
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        double []y=  {80.87,	85.71,	60.26,	62.93,	72.38,	85.37,	63.75,	83.62};
        double []y1 ={82.66,	91.56,	62.83,	70.40,80.36,	85.23,	65.69,	81.22};

        double []y2 ={91.67	,88.61,70.00,	79.99,	76.11,	83.46,	77.65,	90.40};
        getAv(y);
        getAv(y1);
        getAv(y2);
        double []yy=  {86.03,	58.57,	86.15,	57.75,	84.49,	86.36};
        double []yy1 ={84.57,	65.93,	83.84,	68.83,82.65,	86.36};

        double []yy2 ={88.65,67.86,87.68,	72.96,	83.05,	88.71};
        getAv(yy);
        getAv(yy1);
        getAv(yy2);
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