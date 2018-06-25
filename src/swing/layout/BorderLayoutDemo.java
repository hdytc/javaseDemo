package swing.layout;

import javax.swing.*;
import java.awt.*;

public class BorderLayoutDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300,200);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("习题测试");

        JPanel jPanel = new JPanel();
        jf.setContentPane(jPanel);

        //布局管理器要在setContentPane后设置才有效
        BorderLayout layout = new BorderLayout();
        jf.setLayout(layout);

        JButton b1 =new JButton("生活");
        JButton b2 =new JButton("工作");
        JButton b3 =new JButton("睡觉");
        JButton b4 =new JButton("购物");
        JButton b5 =new JButton("饮食");
        jPanel.add(b1,BorderLayout.NORTH);
        jPanel.add(b2,BorderLayout.SOUTH);
        jPanel.add(b3,BorderLayout.EAST);
        jPanel.add(b4,BorderLayout.WEST);
        jPanel.add(b5,BorderLayout.CENTER);

        jf.setVisible(true);
    }
}
