package swing;

import javax.swing.*;
import java.awt.*;

public class MenuDemo {
    static final int WIDTH = 300;
    static final int HEIGHT = 200;
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(WIDTH,HEIGHT);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("menu测试");

        //菜单
        JMenuBar jMenuBar = new JMenuBar();
        JMenu menu1 = new JMenu("文件");
        JMenu menu2 = new JMenu("编辑");
        JMenu menu3 = new JMenu("视图");
        jMenuBar.add(menu1);
        jMenuBar.add(menu2);
        jMenuBar.add(menu3);
        JMenuItem item1 = new JMenuItem("打开");
        JMenuItem item2 = new JMenuItem("保存");
        JMenuItem item3 = new JMenuItem("打印");
        JMenuItem item4 = new JMenuItem("退出");
        menu1.add(item1);
        menu1.add(item2);
        menu1.addSeparator();
        menu1.add(item3);
        menu1.addSeparator();
        menu1.add(item4);
        jf.setJMenuBar(jMenuBar);

        //按钮
        JPanel panel = new JPanel();
        JButton button1 = new JButton("确定");
        JButton button2 = new JButton("取消");
        button1.setBorder(BorderFactory.createLineBorder(Color.RED));
        panel.add(button1);
        panel.add(button2);
        jf.setContentPane(panel);

        //单选
        ButtonGroup bg1 = new ButtonGroup();
        JRadioButton jrb1= new JRadioButton("继续");
        JRadioButton jrb2= new JRadioButton("忽略");
        JRadioButton jrb3= new JRadioButton("跳过");
        bg1.add(jrb1);
        bg1.add(jrb2);
        bg1.add(jrb3);
        panel.add(jrb1);
        panel.add(jrb2);
        panel.add(jrb3);

        //复选框
        JCheckBox jc1 = new JCheckBox("苹果");
        JCheckBox jc2 = new JCheckBox("梨");
        JCheckBox jc3 = new JCheckBox("哈密瓜");
        panel.add(jc1);
        panel.add(jc2);
        panel.add(jc3);

        jf.setVisible(true);
    }
}
