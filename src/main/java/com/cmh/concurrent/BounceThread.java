package com.cmh.concurrent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * Author: cmh
 * Date:2021/4/18 2:35 下午
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceTread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class BounceFrame extends JFrame {
        private BallComponent comp;
        public static final int STEPS = 1000000;
        public static final int DELAY = 3;

        public BounceFrame() {
            comp = new BallComponent();
            add(comp, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            addButton(buttonPanel, "Start", event -> addBall());
            addButton(buttonPanel, "Close", event -> System.exit(0));
            add(buttonPanel, BorderLayout.SOUTH);
            pack();


        }

        public void addButton(Container container, String title, ActionListener listener) {
            JButton button = new JButton(title);
            container.add(button);
            button.addActionListener(listener);
        }

        public void addBall() {
            Ball ball = new Ball();
            comp.add(ball);
            Runnable runnable = () -> {
                try {
                    for (int i = 1; i <= STEPS; i++) {
                        ball.move(comp.getBounds());
//                        comp.repaint();
                        comp.paint(comp.getGraphics());
                        Thread.sleep(DELAY);
                    }
                } catch (InterruptedException interruptedException) {

                }
            };
            Thread thread = new Thread(runnable);// status:NEW
            thread.start();//status:RUNNABLE
        }
    }

    /**
     * 总结：
     * 1、多次连续点击start的时候，部分球就原地不动了，为什么？
     * 2、
     */
}
