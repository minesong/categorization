package com.song.classification.fs.chi;

public class ChiSquare {
    /**
     * A 表示包含特征项 t 且属于类别 c 的文档频数， B 表示包
     * 含特征项 t 但不属于类别 c 的文档频数， C 表示属于类别 c 但不
     * 包含特征项 t 的文档频数， D 表示既不属于类别 c 也不包含特
     * 征项 t 的文档频数， N 表示语料中的文档总数
     */
    public String word;
    public double A;
    public double B;
    public double C;
    public double D;
    public double chisq;
    public ChiSquare() {

    }


    public ChiSquare(String word, double a, double b, double c, double d) {
        super();
        this.word = word;
        this.A = a;
        this.B = b;
        this.C = c;
        this.D = d;
        this.chisq = getChisq();
    }

    public double getChisq() {
        if (A == 0 && B == 0 && C == 0 && D == 0) {
            return 0;
        } else {
            return Math.pow((A * D - B * C) * 1.0, 2) * (A + B + C + D)
                    / ((A + C) * (A + B) * (B + D) * (C + D));
        }
    }
    public static void main(String[] args) {
        ChiSquare chiSquare = new ChiSquare("搀扶", 17, 1, 20936, 134784);
        System.out.println(chiSquare.toString());
    }
}