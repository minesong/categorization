package com.song.classifie.svm;

import java.io.IOException;

public class SVMDemo {
    public static void main(String[] args) throws IOException {
        String[] arg = { "F:\\LdaOriginalDocs/train.txt", //训练集
                "F:\\LdaOriginalDocs/model.txt" }; // 存放SVM训练模型


        String[] parg = { "F:\\LdaOriginalDocs/test.txt", //测试数据
                "F:\\LdaOriginalDocs/model.txt", // 调用训练模型
                "F:\\LdaOriginalDocs/predict.txt" }; //预测结果
        System.out.println("........SVM运行开始..........");
        long start=System.currentTimeMillis();
        svm_train.main(arg); //训练
        System.out.println("用时:"+(System.currentTimeMillis()-start));
        //预测
        svm_predict.main(parg);
    }
}