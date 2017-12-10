package com.song.classifie.kmeans;

import java.io.*;

public class K_Means {

    int Flags = 0;
    int[] logo = new int[100]; // 标志位
    double center_A[] = new double[2], center_B[] = new double[2],
            center_C[] = new double[2], center_1[] = new double[2],
            center_2[] = new double[2], center_3[] = new double[2];
    double train[][] = new double[100][2]; // 将对象实体化

    /***************************************************************************
     * 读文件data0.txt中数据，保存至train[][]二维数组中
     **************************************************************************/
    public void readtxt() throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("c:/data3.txt"));
        String s;
        int i, j;
        i = 0;
        j = 0;
        while (br.ready())// 判断此流是否已准备好被读取
        {
            s = br.readLine();// 读文件中一行
            java.util.StringTokenizer tokenizer = new java.util.StringTokenizer(
                    s, ",，");
            while (tokenizer.hasMoreTokens())// 测试此 tokenizer
            // 的字符串中是否还有更多的可用标记
            {
                train[i][j] = Double.parseDouble(tokenizer.nextToken());// 将读入的字符串转化为双精度型数据
                j++;
                if (j == 2) {
                    j = 0;
                    i++;
                }
            }
        }
    }


    /***************************************************************************
     * 初始化中心点(任意)
     **************************************************************************/
    public void initial() {
        for (int i = 0; i < 3; i++)
            // 初始化簇（旧）中心，不妨以前三个为中心
            for (int j = 0; j < 2; j++) {
                if (i == 0) {
                    center_A[j] = train[i][j];
                } else if (i == 1) {
                    center_B[j] = train[i][j];
                } else {
                    center_C[j] = train[i][j];
                }
            }
        for (int j = 0; j < 2; j++)// 初始化簇（新）中心
        {
            center_1[j] = center_2[j] = center_3[j] = 0;
        }

        for (int i = 0; i < train.length; i++) {
            logo[i] = 0;// 初始化标志位
        }
    }

    /***************************************************************************
     * 比较差值，确定所属类
     **************************************************************************/
    public void plus()// 求方差
    {
        for (int i = 0; i < train.length; i++) {
            double a, b, c;
            a = b = c = 0;
            for (int j = 0; j < 2; j++) {
                a += Math.pow((train[i][j] - center_A[j]), 2);
                b += Math.pow((train[i][j] - center_B[j]), 2);
                c += Math.pow((train[i][j] - center_C[j]), 2);
            }
            token(a, b, c, i);// 标记logo[i] ，以logo=1,2,3表示所属类
        }
    }

    /***************************************************************************
     * 更改标志位(重新分配，看点属于那个簇)
     **************************************************************************/
    public void token(double a, double b, double c, int i) {
        double temp = 0;
        if (a >= b) {
            temp = b;
            this.logo[i] = 2;
        } else {
            temp = a;
            this.logo[i] = 1;
        }
        if (temp >= c) {
            temp = c;
            this.logo[i] = 3;
        }
    }

    /***************************************************************************
     * 每聚类一次，求一次新的中心点
     **************************************************************************/
    public void center() {
        int num1, num2, num3;
        num1 = num2 = num3 = 0;
        for (int j = 0; j < 2; j++) {
            center_1[j] = center_2[j] = center_3[j] = 0;
        }
        for (int i = 0; i < train.length; i++) {
            switch (logo[i]) {
                case 1: {
                    for (int j = 0; j < 2; j++) {
                        center_1[j] += train[i][j];
                    }
                    num1++;
                    break;
                }
                case 2: {
                    for (int j = 0; j < 2; j++) {
                        center_2[j] += train[i][j];
                    }
                    num2++;
                    break;
                }
                case 3: {
                    for (int j = 0; j < 2; j++) {
                        center_3[j] += train[i][j];
                    }
                    num3++;
                    break;
                }
            }
        }
        for (int j = 0; j < 2; j++) {
            center_1[j] = (double) (center_1[j] / (double) num1);
            center_2[j] = (double) (center_2[j] / (double) num2);
            center_3[j] = (double) (center_3[j] / (double) num3);
        }
    }

    /***************************************************************************
     * 判断聚类运算是否结束
     **************************************************************************/
    public void compare()// 新旧中心点
    {
        double a, b, c;
        a = b = c = 0;
        for (int j = 0; j < 2; j++) {
            a += Math.pow((center_1[j] - center_A[j]), 2);
            b += Math.pow((center_2[j] - center_B[j]), 2);
            c += Math.pow((center_3[j] - center_C[j]), 2);
        }
        // 符合要求
        if ((a < 0.01) && (b < 0.01) && (c < 0.01)) {
            Flags = 1;
        }
    }

    /***************************************************************************
     * 用新的簇中心替换旧的簇中心
     **************************************************************************/
    public void DuplicateCenter() {
        for (int j = 0; j < 2; j++) {
            center_A[j] = center_1[j];
            center_B[j] = center_2[j];
            center_C[j] = center_3[j];
        }
        ;
    }

    /***************************************************************************
     * 写文件到cluster_result.txt中
     **************************************************************************/
    public void WrietTxt() throws Exception {
        BufferedWriter bw = new BufferedWriter(new FileWriter(
                "c:/cluster_result.txt"));
        int i = 0;
        while (i < train.length) {
            String s = "";
            for (int j = 0; j < 2; j++) {
                s += "  " + String.valueOf(train[i][j]) + "  ";// 获得train[][]每一行数据，转化为字符串类型
            }
            ;
            bw.write(s + String.valueOf(logo[i]));// 加入标志位
            bw.newLine();
            i++;
        }
        ;
        bw.close();
    }

//	public static void main(String args[]) throws Exception {
//		K_Means app = new K_Means();// 创建一个类实例
//
////		 app.readtxt();
//		app.set();
//		app.initial();
//
//		app.plus();
//		app.center();
//		// 不停的循环
//		while (app.Flags == 0) {
//			app.DuplicateCenter();
//			app.plus();
//			app.center();
//			app.compare();
//		}
//		;
//
//		app.WrietTxt();
//		//
//		// for(int i=0;i<app.train.length;i++)//显示结果－测试用
//		// {
//		//	    	System.out.println(i+"----"+ app.logo[i]);
//		//        };
////		new MainFrame(app);
//	}
}
