package swing.layout;

import javax.swing.*;
import java.awt.*;

/**
 * 九宫格布局
 */
public class GirdLayoutDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300,200);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("习题测试");

        JPanel jPanel = new JPanel();
        jf.setContentPane(jPanel);

        //布局管理器要在setContentPane后设置才有效
        jf.setLayout(new GridLayout(3,3));

        JButton b1 =new JButton("生活");
        JButton b2 =new JButton("工作");
        JButton b3 =new JButton("睡觉");
        JButton b4 =new JButton("购物");
        JButton b5 =new JButton("饮食");
        JButton b6 =new JButton("1");
        JButton b7 =new JButton("2");
        JButton b8 =new JButton("3");
        JButton b9 =new JButton("4");
        jPanel.add(b1);
        jPanel.add(b2);
        jPanel.add(b3);
        jPanel.add(b4);
        jPanel.add(b5);
        jPanel.add(b6);
        jPanel.add(b7);
        jPanel.add(b8);
        jPanel.add(b9);

        //需要重新打包
        jf.pack();
        jf.setVisible(true);
    }
}
