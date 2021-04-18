package com.cmh.myswing.tenSection;

import javax.swing.*;
import java.awt.*;

public class NotHelloWorld {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new NotHelloWordFrame();
            frame.setTitle("天气不错");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }

    static class NotHelloWordFrame extends JFrame {
        public NotHelloWordFrame() {
            add(new NotHelloWorldComponent());
            pack();
        }
    }

    static class NotHelloWorldComponent extends JComponent {
        public static final int MESSAGE_X = 75;
        public static final int MESSAGE_Y = 100;

        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        @Override
        protected void paintComponent(Graphics g) {
            g.drawString("了解下Swing", MESSAGE_X, MESSAGE_Y);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        }
    }
}
