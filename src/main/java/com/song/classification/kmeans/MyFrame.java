package com.song.classification.kmeans;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MyFrame extends JPanel {

    static K_Means kms = new K_Means();// 注意：定义静太对像,可在静太方法里

    public MyFrame() {
    }

    // 重写paint方法

    public void paint(Graphics g) {

        // 设置画笔颜色
        g.setColor(Color.BLUE);
        // 画坐标
        g.drawLine(10, 10, 10, 550);
        g.setColor(Color.RED);
        g.drawString("X", 15, 15);

        g.setColor(Color.BLUE);
        g.drawLine(10, 550, 750, 550);
        g.setColor(Color.RED);
        g.drawString("Y", 780, 550);

        // 画点
        for (int i = 0; i < kms.train.length; i++) {

            if (kms.logo[i] == 1) {
                g.setColor(Color.RED);
                g.fillRect((int) kms.train[i][0] + 150, (int) kms.train[i][1],
                        3, 3);

            }
            if (kms.logo[i] == 2) {
                g.setColor(Color.BLUE);
                g.fillRect((int) kms.train[i][0] + 150, (int) kms.train[i][1],
                        3, 3);

            }
            if (kms.logo[i] == 3) {
                g.setColor(Color.CYAN);
                g.fillRect((int) kms.train[i][0] + 150,
                        (int) kms.train[i][1] + 20, 3, 3);

            }

        }

    }

    /**
     * ******************************************88888 静态方法
     */
    public static void main(String[] args) {

        try {
            kms.readtxt();
        } catch (Exception e1) {
            System.out.print("文件读取成功……");
        }

        kms.initial();

        kms.plus();
        kms.center();
        // 不停的循环
        while (kms.Flags == 0) {
            kms.DuplicateCenter();
            kms.plus();
            kms.center();
            kms.compare();
        }

        try {
            kms.WrietTxt();
        } catch (Exception e) {
            e.printStackTrace();
        }

        K_Means kms = new K_Means();
        MyFrame jp = new MyFrame();

        // 窗体设置
        JFrame jf = new JFrame();

        // 将画布加入窗体
        jf.add(jp);
        jf.setTitle("K-Means");
        jf.setBounds(100, 50, 800, 600);

        // 关闭动作
        jf.setVisible(true);
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
