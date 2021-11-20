//UI界面类
package OSC.E1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

public class Gui extends JPanel{
    //创建队列对应数组
    ArrayList<process> houbei = new ArrayList<process>();
    ArrayList<process> jiuxu = new ArrayList<process>();
    ArrayList<process> guaqi = new ArrayList<process>();
    ArrayList<process> CPU = new ArrayList<process>();
    ArrayList<process> zhongzhi = new ArrayList<process>();
    ArrayList<process> neicun = new ArrayList<process>();

    int count1 = 0;//对应后备队列指针
    int count2 = 0;//对应就绪队列指针
    int count3 = 0;//对应终止队列指针
    int count4 = 0;//对应是否对就绪队列中元素完成排序
    int count5 = 0;//对应挂起队列指针
    int count6 = 1;//对应已经占用的内存大小


    //初始化设置窗口
    public Gui(){
        //创建窗口组件
        JFrame frame = new JFrame("CPU调度模拟器");//窗口标题
        JPanel panel = new JPanel();//底层容器
        JLabel label1 = new JLabel("创建进程");
        JLabel label2 = new JLabel("进程名：");
        JTextField textField1 = new JTextField(4);
        JLabel label3 = new JLabel("运行时间：");
        JTextField textField2 = new JTextField(4);
        JLabel label4 = new JLabel("优先数：");
        JTextField textField3 = new JTextField(4);
        JButton button1 = new JButton("添加");
        JButton button2 = new JButton("清空");
        JLabel label5 = new JLabel("后备队列");
        JLabel label6 = new JLabel("进程名");
        JLabel label7 = new JLabel("运行时间");
        JLabel label8 = new JLabel("优先数");
        JTextArea textArea1 = new JTextArea(5,10);
        JTextArea textArea2 = new JTextArea(5,10);
        JTextArea textArea3 = new JTextArea(5,10);
        JLabel label9 = new JLabel("就绪队列");
        JLabel label10 = new JLabel("进程名");
        JLabel label11 = new JLabel("运行时间");
        JLabel label12 = new JLabel("优先数");
        JLabel label13 = new JLabel("PCB指针");
        JTextArea textArea4 = new JTextArea(5,10);
        JTextArea textArea5 = new JTextArea(5,10);
        JTextArea textArea6 = new JTextArea(5,10);
        JTextArea textArea7 = new JTextArea(5,10);
        JButton button3 = new JButton("运行");
        JButton button4 = new JButton("挂起");
        JButton button5 = new JButton("运行");
        JLabel label14 = new JLabel("CPU(道数：6)");
        JLabel label15 = new JLabel("运行进程名");
        JLabel label16 = new JLabel("运行时间");
        JLabel label17 = new JLabel("优先数");
        JTextField textField4 = new JTextField(4);
        JTextField textField5 = new JTextField(4);
        JTextField textField6 = new JTextField(4);
        JLabel label18 = new JLabel("挂起队列");
        JLabel label19 = new JLabel("进程名");
        JLabel label20 = new JLabel("运行时间");
        JLabel label21 = new JLabel("优先数");
        JTextArea textArea8 = new JTextArea(5,10);
        JTextArea textArea9 = new JTextArea(5,10);
        JTextArea textArea10 = new JTextArea(5,10);
        JButton button6 = new JButton("解挂");
        JLabel label22 = new JLabel("终止队列");
        JLabel label23 = new JLabel("进程名");
        JTextArea textArea11 = new JTextArea(5,10);
        JButton button7 = new JButton("排序");
        JLabel label24 = new JLabel("占用内存:");
        JTextField textField7 = new JTextField(4);
        JLabel label25 = new JLabel("模拟内存");
        JLabel label26 = new JLabel("PS: 模拟内存共16KB，其中操作系统占用1KB");

        Font font = new Font("宋体", Font.BOLD, 25);
        Font font1 = new Font("宋体", 0, 20);

        //内存管理
        Object[] columnNames = {"进程名","起址","长度"};
        Object[][] data = {
                {"  进程名","   起址","   长度"},
                {"操作系统",0,1},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""},
                {"","",""}
        };
        JTable table = new JTable(data, columnNames);
        table.setBounds(1250,60,300,650);
        table.setFont(font1);
        table.setShowGrid(true);
        table.setRowHeight(37);
        table.setRowHeight(0,58);
        table.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label25.setFont(font);
        label25.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label25.setBounds(1340,0,110,45);
        panel.add(table);
        panel.add(label25);

        //总窗口设置
        panel.setBackground(Color.lightGray);
        panel.setLayout(null);
        panel.setPreferredSize(new Dimension(1650, 870));
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(70,80,1650, 870);
        frame.setVisible(true);

        //创建进程模块设置
        label1.setFont(font);
        label1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label1.setBounds(170,0,110,45);
        label2.setFont(font1);
        label2.setBounds(0,50,100,30);
        label3.setFont(font1);
        label3.setBounds(150,50,100,30);
        label4.setFont(font1);
        label4.setBounds(320,50,100,30);
        label24.setFont(font1);
        label24.setBounds(150,100,100,30);
        label26.setFont(font1);
        label26.setBounds(10,150,500,30);
        textField1.setBounds(75,50,50,30);
        textField1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField2.setBounds(250,50,50,30);
        textField2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField3.setBounds(400,50,50,30);
        textField3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField7.setBounds(250,100,50,30);
        textField7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button1.setBounds(120,200,70,35);
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {//添加队列添加按钮实现
                int n = Integer.parseInt(textField7.getText());
                int lenth = 0;
                if(Integer.parseInt(textField7.getText()) > 16-count6) {
                    JOptionPane.showMessageDialog(null,"进程所占用内存超过剩余内存！无法添加进程！","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else {
                    for(int i = 0;i <= 16;i++){
                        if(table.getModel().getValueAt(i,2) == ""){
                            lenth+=1;
                            if(lenth == Integer.parseInt(textField7.getText())){
                                houbei.add(new process(textField1.getText(), Integer.parseInt(textField2.getText()), Integer.parseInt(textField3.getText()), Integer.parseInt(textField7.getText())));
                                process temp = houbei.get(count1);
                                count1++;
                                String name = temp.PID;
                                int time = temp.Time;
                                int rank = temp.Rank;
                                textArea1.append("       " + name + "       ");
                                textArea2.append("        " + time + "         ");
                                textArea3.append("        " + rank + "         ");
                                table.getModel().setValueAt(textField1.getText(),i+1-lenth,0);
                                table.getModel().setValueAt(i-lenth,i+1-lenth,1);
                                table.getModel().setValueAt(1,i+1-lenth,2);
                                for(int j = 0;j < lenth-1;j++){
                                    table.getModel().setValueAt(j+2,i+2+j-lenth,2);
                                }
                                count6+=lenth;
                                lenth = 0;
                                break;
                            }
                            if(i==16){
                                JOptionPane.showMessageDialog(null,"无合适内存空间存放进程！","提示",JOptionPane.PLAIN_MESSAGE);
                            }
                        }
                        else {
                         lenth = 0 ;
                        }
                    }
                }
            }
        });
        button2.setBounds(300,200,70,35);
        button2.addActionListener(new ActionListener() {//添加队列时清空按钮实现
            @Override
            public void actionPerformed(ActionEvent e) {
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField7.setText("");
            }
        });
        panel.add(label1);
        panel.add(label2);
        panel.add(textField1);
        panel.add(label3);
        panel.add(textField2);
        panel.add(label4);
        panel.add(textField3);
        panel.add(button1);
        panel.add(button2);
        panel.add(label24);
        panel.add(textField7);
        panel.add(label26);


        //后备队列模块设置
        label5.setFont(font);
        label5.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label5.setBounds(825,0,110,45);
        label6.setFont(font1);
        label6.setBounds(650,50,100,30);
        label7.setFont(font1);
        label7.setBounds(850,50,100,30);
        label8.setFont(font1);
        label8.setBounds(1050,50,100,30);
        textArea1.setLineWrap(true);
        textArea1.setBounds(650,80,60,120);
        textArea1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea2.setLineWrap(true);
        textArea2.setBounds(860,80,60,120);
        textArea2.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea3.setLineWrap(true);
        textArea3.setBounds(1050,80,60,120);
        textArea3.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button3.setBounds(855,210,70,35);//后备队列添加至就绪队列  采用FCFS方式进行调度
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int j = 6 - count2;
                if (count1 == 0){
                    JOptionPane.showMessageDialog(null,"后备队列无进程！无法添加！","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if(count2  == 6){
                        JOptionPane.showMessageDialog(null,"就绪队列已满！无法添加！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        textArea1.setText("");
                        textArea2.setText("");
                        textArea3.setText("");
                        process temp;
                        for (int i = 0;i< j ;i++){
                            int n = 0;
                            temp = houbei.get(n);
                            jiuxu.add(temp);
                            textArea4.append("       " + temp.PID + "       ");
                            textArea5.append("        " + temp.Time + "         ");
                            textArea6.append("        " + temp.Rank + "         ");
                            count1 --;
                            count2 ++;
                            houbei.remove(n);
                        }
                        for (int i =0;i < count1 ;i++){
                            textArea1.append("       " + houbei.get(i).PID + "       ");
                            textArea2.append("       " + houbei.get(i).Time + "       ");
                            textArea3.append("       " + houbei.get(i).Rank + "       ");
                        }
                    }
                }
            }
        });
        panel.add(label5);
        panel.add(label6);
        panel.add(label7);
        panel.add(label8);
        panel.add(textArea1);
        panel.add(textArea2);
        panel.add(textArea3);
        panel.add(button3);

        //就绪队列模块设置
        label9.setFont(font);
        label9.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label9.setBounds(170,255,110,45);
        label10.setFont(font1);
        label10.setBounds(30,305,100,30);
        label11.setFont(font1);
        label11.setBounds(160,305,100,30);
        label12.setFont(font1);
        label12.setBounds(290,305,100,30);
        label13.setFont(font1);
        label13.setBounds(420,305,100,30);
        textArea4.setLineWrap(true);
        textArea4.setBounds(30,335,60,120);
        textArea4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea5.setLineWrap(true);
        textArea5.setBounds(170,335,60,120);
        textArea5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea6.setLineWrap(true);
        textArea6.setBounds(290,335,60,120);
        textArea6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea7.setLineWrap(true);
        textArea7.setBounds(425,335,60,120);
        textArea7.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button4.setBounds(95,465,70,35);//就绪队列挂起按钮
        button4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count2 == 0) {
                    JOptionPane.showMessageDialog(null, "就绪队列为空！无法挂起进程！", "提示", JOptionPane.PLAIN_MESSAGE);
                }
                else {
                        process temp = jiuxu.get(0);
                        jiuxu.remove(0);
                        count2--;
                        guaqi.add(temp);
                        count5 ++;
                        textArea8.append("       " + temp.PID + "       ");
                        textArea9.append("       " + temp.Time + "       ");
                        textArea10.append("       " + temp.Rank + "       ");
                        textArea4.setText("");
                        textArea5.setText("");
                        textArea6.setText("");
                        for (int i =0;i < count2 ;i++){
                            textArea4.append("       " + jiuxu.get(i).PID + "       ");
                            textArea5.append("        " + jiuxu.get(i).Time + "        ");
                            textArea6.append("        " + jiuxu.get(i).Rank + "        ");
                    }
                }
            }
        });
        button5.setBounds(355,465,70,35);//就绪队列进入CPU运行按钮 采用优先级调度的方式
        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count2 == 0){
                    JOptionPane.showMessageDialog(null,"就绪队列中无进程！无法调用至CPU！","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if(count4 == 0){
                        JOptionPane.showMessageDialog(null,"请先对就绪队列进行排序！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                            count4 --;
                            CPU.add(jiuxu.get(0));
                            jiuxu.get(0).setTime(jiuxu.get(0).getTime() - 1);
                            jiuxu.get(0).setRank(jiuxu.get(0).getRank() + 1);
                            textField4.setText(CPU.get(0).getPID());
                            textField5.setText(String.valueOf(CPU.get(0).getTime()));
                            textField6.setText(String.valueOf(CPU.get(0).getRank()));
                            textArea4.setText("");
                            textArea5.setText("");
                            textArea6.setText("");
                        for (int i =0;i < count2 ;i++){
                            textArea4.append("       " + jiuxu.get(i).PID + "       ");
                            textArea5.append("        " + jiuxu.get(i).Time + "        ");
                            textArea6.append("        " + jiuxu.get(i).Rank + "        ");
                        }
                        CPU.remove(0);
                        if (jiuxu.get(0).Time == 0){
                            zhongzhi.add(jiuxu.get(0));
                            count3 ++;
                            jiuxu.remove(0);
                            count2--;
                            textArea11.append("       " + zhongzhi.get(count3-1).PID + "       ");
                            for(int i = 0;i<=16;i++){
                                if(Objects.equals((String) table.getModel().getValueAt(i, 0), zhongzhi.get(count3 - 1).PID)) {
                                    for(int j = 0;j<zhongzhi.get(count3-1).Memory;j++){
                                        table.getModel().setValueAt("",i+j,0);
                                        table.getModel().setValueAt("",i+j,1);
                                        table.getModel().setValueAt("",i+j,2);
                                    }
                                    break;
                                }
                            }
                            count6-=zhongzhi.get(count3-1).Memory;
                            JOptionPane.showMessageDialog(null,"进程"+zhongzhi.get(count3 -1).getPID()+"已经完成！占用的内存已经释放！","提示",JOptionPane.PLAIN_MESSAGE);
                            textArea4.setText("");
                            textArea5.setText("");
                            textArea6.setText("");
                            for (int i =0;i < count2 ;i++){
                                textArea4.append("       " + jiuxu.get(i).PID + "       ");
                                textArea5.append("        " + jiuxu.get(i).Time + "        ");
                                textArea6.append("        " + jiuxu.get(i).Rank + "        ");
                            }
                        }
                        }
                    }
                }
        });
        button7.setBounds(225,465,70,35);//对就绪队列中元素进行排序按钮
        button7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(count2 == 0){
                    textArea7.setText("");
                    JOptionPane.showMessageDialog(null,"就绪队列中无进程！无法排序！","提示",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if (count4 == 1){
                        textArea7.setText("");
                        JOptionPane.showMessageDialog(null,"已完成排序！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                        count4 ++;
                        for (int end = jiuxu.size() - 1; end > 0; end--) {//采用冒泡排序
                        for(int i =0;i < count2-1 ;i++){
                            if(jiuxu.get(i).getRank()>jiuxu.get(i+1).getRank()){
                                process temp1;
                                process temp2;
                                temp1 = jiuxu.get(i);
                                temp2 = jiuxu.get(i+1);
                                jiuxu.set(i,temp2);
                                jiuxu.set(i+1,temp1);
                            }
                        }
                        }
                        textArea4.setText("");
                        textArea5.setText("");
                        textArea6.setText("");
                        for (int i =0;i < count2 ;i++){
                            textArea4.append("       " + jiuxu.get(i).PID + "       ");
                            textArea5.append("        " + jiuxu.get(i).Time + "        ");
                            textArea6.append("        " + jiuxu.get(i).Rank + "        ");
                        }
                        textArea7.setText("       " + jiuxu.get(1).PID + "       ");
                        JOptionPane.showMessageDialog(null,"已完成排序！","提示",JOptionPane.PLAIN_MESSAGE);
                    }
                }
            }
        });
        panel.add(label9);
        panel.add(label10);
        panel.add(label11);
        panel.add(label12);
        panel.add(label13);
        panel.add(textArea4);
        panel.add(textArea5);
        panel.add(textArea6);
        panel.add(textArea7);
        panel.add(button4);
        panel.add(button5);
        panel.add(button7);

        //CPU版块设置
        label14.setFont(font);
        label14.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label14.setBounds(805,255,170,45);
        label15.setFont(font1);
        label15.setBounds(650,305,100,30);
        label16.setFont(font1);
        label16.setBounds(860,305,100,30);
        label17.setFont(font1);
        label17.setBounds(1050,305,100,30);
        textField4.setBounds(680,360,50,30);
        textField4.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField5.setBounds(865,360,50,30);
        textField5.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textField6.setBounds(1050,360,50,30);
        textField6.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(label14);
        panel.add(label15);
        panel.add(label16);
        panel.add(label17);
        panel.add(textField4);
        panel.add(textField5);
        panel.add(textField6);


        //挂起队列版块设置
        label18.setFont(font);
        label18.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label18.setBounds(170,520,110,45);
        label19.setFont(font1);
        label19.setBounds(30,570,100,30);
        label20.setFont(font1);
        label20.setBounds(190,570,100,30);
        label21.setFont(font1);
        label21.setBounds(350,570,100,30);
        textArea8.setLineWrap(true);
        textArea8.setBounds(30,605,60,120);
        textArea8.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea9.setLineWrap(true);
        textArea9.setBounds(195,605,60,120);
        textArea9.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        textArea10.setLineWrap(true);
        textArea10.setBounds(350,605,60,120);
        textArea10.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        button6.setBounds(190,760,70,35);
        button6.addActionListener(new ActionListener() {//挂起队列解挂按钮
            @Override
            public void actionPerformed(ActionEvent e) {
                if(guaqi.size() == 0){
                    JOptionPane.showMessageDialog(null,"挂起队列为空！无法解挂！" ,"提示",JOptionPane.PLAIN_MESSAGE);
                }
                else{
                    if(count2 == 6){
                        JOptionPane.showMessageDialog(null,"就绪队列已满！无法解挂！" ,"提示",JOptionPane.PLAIN_MESSAGE);
                    }
                    else{
                    count4 = 0;
                    jiuxu.add(guaqi.get(0));
                    count2 ++;
                    guaqi.remove(0);
                    count5 --;
                    textArea8.setText("");
                    textArea9.setText("");
                    textArea10.setText("");
                    for (int i =0;i < count5 ;i++){
                        textArea8.append("       " + guaqi.get(i).PID + "       ");
                        textArea9.append("        " + guaqi.get(i).Time + "        ");
                        textArea10.append("        " + guaqi.get(i).Rank + "        ");
                    }
                    textArea4.setText("");
                    textArea5.setText("");
                    textArea6.setText("");
                    for (int i =0;i < count2 ;i++){
                        textArea4.append("       " + jiuxu.get(i).PID + "       ");
                        textArea5.append("        " + jiuxu.get(i).Time + "        ");
                        textArea6.append("        " + jiuxu.get(i).Rank + "        ");
                    }
                }
            }
            }
        });
        panel.add(label18);
        panel.add(label19);
        panel.add(label20);
        panel.add(label21);
        panel.add(textArea8);
        panel.add(textArea9);
        panel.add(textArea10);
        panel.add(button6);

        //终止队列版块设置
        label22.setFont(font);
        label22.setBorder(BorderFactory.createRaisedSoftBevelBorder());
        label22.setBounds(830,520,110,45);
        label23.setFont(font1);
        label23.setBounds(845,570,100,30);
        textArea11.setLineWrap(true);
        textArea11.setBounds(845,605,60,120);
        textArea11.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panel.add(label22);
        panel.add(label23);
        panel.add(textArea11);

    }

    public static void main(String[] args){
        Gui ui = new Gui();
    }
}