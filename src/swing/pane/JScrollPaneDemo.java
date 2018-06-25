package swing.pane;

import javax.swing.*;

public class JScrollPaneDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300, 200);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("习题测试");

        JTextArea jTextArea = new JTextArea("1111111111111111112222222222222222222333333333333333333333454444444444");
        JScrollPane pane = new JScrollPane(jTextArea);
        jf.setContentPane(pane);
        jf.setVisible(true);
    }
}
