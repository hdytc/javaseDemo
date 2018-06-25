package swing.pane;

import javax.swing.*;

public class RootPaneDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300, 200);
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

        JRootPane jRootPane = new JRootPane();
        jf.setContentPane(jRootPane);
        //不设置在jframe上而是pane上。
        jRootPane.setJMenuBar(jMenuBar);

        jf.setVisible(true);
    }
}
