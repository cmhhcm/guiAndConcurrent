package com.cmh.myswing.tenSection;

import javax.swing.*;
import java.awt.*;

public class SimpleFrameTest {
    public static void main(String[] args){
        EventQueue.invokeLater(()->{
            SimpleFrame frame  = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            //关闭所有框架装饰
            frame.setUndecorated(true);
            //设置位置
            frame.setLocation(600,800);





        });
    }
    static class SimpleFrame extends JFrame {
        private static final int DEFAULT_WIDTH = 300;
        private static final int DEFAULT_HEIGHT = 200;

        public SimpleFrame() {
            //确定合适的框架大小，应该根据不同屏幕分辨率自适应
            Toolkit kit = Toolkit.getDefaultToolkit();
            Dimension screenSize = kit.getScreenSize();
            int screenWidth = screenSize.width;
            int screenHeight = screenSize.height;

//            setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
            setSize(screenWidth/2,screenHeight/2);
            setLocationByPlatform(true);

            //设置图标
            Image img = new ImageIcon("icon.gif").getImage();
            setIconImage(img);
        }
    }
}
