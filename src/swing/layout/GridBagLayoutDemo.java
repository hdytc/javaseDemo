package swing.layout;

import javax.swing.*;
import java.awt.*;

public class GridBagLayoutDemo {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(300,200);
        setLocationCenter(jf);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setTitle("习题测试");
        JPanel jPanel = new JPanel();
        jf.setContentPane(jPanel);
        //布局管理器要在setContentPane后设置才有效
        jf.setLayout(new GridBagLayout());

        JButton okButton =new JButton("确认");
        JButton cancelButton =new JButton("放弃");
        JLabel titleLabel = new JLabel("测试窗口");
        JLabel nameLabel = new JLabel("用户名");
        JLabel passwordLabel = new JLabel("密码");
        final JTextField nameInput = new JTextField(15);
        final JTextField passwordInput = new JTextField(15);

        jPanel.add(titleLabel,getGridBagConstraints(0,0,4,1));
        jPanel.add(nameLabel,getGridBagConstraints(0,1,1,1));
        jPanel.add(passwordLabel,getGridBagConstraints(0,2,1,1));
        jPanel.add(nameInput,getGridBagConstraints(2,1,1,1));
        jPanel.add(passwordInput,getGridBagConstraints(2,2,1,1));
        jPanel.add(okButton,getGridBagConstraints(0,3,1,1));
        jPanel.add(cancelButton,getGridBagConstraints(2,3,1,1));

        //设置不能调整大小
        jf.setResizable(false);
        jf.setVisible(true);
    }
    private static void setLocationCenter(JFrame jFrame) {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int x = (screenSize.width - jFrame.getWidth())/2;
        int y = (screenSize.height - jFrame.getWidth())/2;
        jFrame.setLocation(x,y);
    }

    private static GridBagConstraints getGridBagConstraints(int x, int y, int w, int h) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.NONE;
        constraints.anchor = GridBagConstraints.EAST;
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.gridwidth = w;
        constraints.gridheight = h;
        return constraints;
    }
}
