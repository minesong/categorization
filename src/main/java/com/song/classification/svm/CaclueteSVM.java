package com.song.classification.svm;

import com.song.classification.svm.svm_predict;
import com.song.classification.svm.svm_train;

import java.io.IOException;

/**
 * @author mine_song
 * @date 2017/11/21
 */
public class CaclueteSVM {
    public static void caclueteSVM(String path) {
        String[] arg = {path + "/train.txt", //训练集
                path + "/model.txt"}; // 存放SVM训练模型


        String[] parg = {path + "/test.txt", //测试数据
                path + "/model.txt", // 调用训练模型
                path + "/predict.txt"}; //预测结果
        System.out.println("........SVM运行开始..........");
        long start = System.currentTimeMillis();
        try {
            svm_train.main(arg); //训练
            svm_predict.main(parg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("用时:" + (System.currentTimeMillis() - start));
        //预测

    }
}