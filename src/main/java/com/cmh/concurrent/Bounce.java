package com.cmh.concurrent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

/**
 * 核心类-绘制图形并使球弹跳
 *
 * Author: cmh
 * Date:2021/4/18 1:39 上午
 */
public class Bounce {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class BounceFrame extends JFrame {
        private BallComponent comp;
        public static final int STEPS = 5000000;
        public static final int DELAY = 8;

        public BounceFrame() {
            setTitle("Bounce");
            comp = new BallComponent();
            add(comp, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            addButton(buttonPanel, "Start", event -> addBall());
            addButton(buttonPanel, "Close", event -> System.exit(0));
            add(buttonPanel, BorderLayout.SOUTH);
            pack();
        }

        /**
         * Adds a button to a container
         */
        public void addButton(Container c, String title, ActionListener listener) {
            JButton button = new JButton(title);
            c.add(button);
            button.addActionListener(listener);
        }

        /**
         * Adds a bouncing ball to the panel and makes it bounce N times
         */
        public void addBall() {
            try {
                Ball ball = new Ball();
                comp.add(ball);
                for (int i = 1; i <= STEPS; i++) {
                    ball.move(comp.getBounds());
                    comp.paint(comp.getGraphics());
                    Thread.sleep(DELAY);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
