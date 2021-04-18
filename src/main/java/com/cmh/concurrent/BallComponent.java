package com.cmh.concurrent;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

/**
 * 弹球面板类-填充颜色和大小
 *
 * Author: cmh
 * Date:2021/4/18 1:40 上午
 */
public class BallComponent extends JPanel {
    private static final int DEFAULT_WIDTH = 450;
    private static final int DEFAULT_HEIGHT = 350;

    /**
     * ？ 这个是干嘛用的？为啥要存在List里面？
     */
    List<Ball> balls = new ArrayList<>();

    /**
     * Add a ball to the component
     */
    public void add(Ball b) {
        balls.add(b);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g); //erase background
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            System.out.println("List的size是："+balls.size());
            g2.fill(b.getShape());
        }
    }

    public Dimension getPreferredSize() {
        return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
    }
}
