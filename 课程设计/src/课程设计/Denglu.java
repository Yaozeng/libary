package 课程设计;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Denglu extends JFrame{
	JRadioButton j1,j2;
	JTextField f1;
	JPasswordField f2;
	JButton btn1,btn2;
	String username="",pwd="",user="";
	public Denglu(){
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(2,2));
		p1.add(new JLabel("用户名"));
		p1.add(f1=new JTextField(10));
		p1.add(new JLabel("密     码"));
		p1.add(f2=new JPasswordField(10));
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(1,2));
		p2.add(j1=new JRadioButton("管理员"));
		p2.add(j2=new JRadioButton("用     户"));
		ButtonGroup group=new ButtonGroup();
		group.add(j1);
		group.add(j2);
		JPanel p3=new JPanel();
		p3.add(btn1=new JButton("登录"));
		p3.add(btn2=new JButton("重置"));
		setLayout(new GridLayout(3,1));
		add(p1);
		add(p2);
		add(p3);
		j1.addActionListener(new ActionListener(){
             public void actionPerformed(ActionEvent e){
				user="管理员";
			}
		});
		j2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
				user="用     户";
			}
		});
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if(user.equals(""))
				{
					JOptionPane.showMessageDialog(null,"请选择身份");
				}
				else if(user.equals("管理员"))
				{
					if(f2.getText().toString().equals(DBUtil.selectPwd(f1.getText().toString(),user)))
					{
						Constant.username=f1.getText().toString();
						MainMenu1 m1=new MainMenu1();
						m1.setTitle("管理员客户端");
						m1.setSize(300,400);
						m1.setLocationRelativeTo(null);
						m1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						m1.setVisible(true);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"密码或账号错误");
					}
				}
				else{
					//System.out.println(DBUtil.selectPwd(f1.getText().toString(),user));
					if(f2.getText().toString().equals(DBUtil.selectPwd(f1.getText().toString(),user)))
					{
						Constant.username=f1.getText().toString();
						MainMenu5 m5=new MainMenu5();
						m5.setTitle("学生客户端");
						m5.setSize(300,400);
						m5.setLocationRelativeTo(null);
						m5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						m5.setVisible(true);
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null,"密码或账号错误");

					}
				}
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				f1.setText("");
				f2.setText("");
			}
		});
	}
	public static void main(String args[]){
		Denglu d1=new Denglu();
		d1.setTitle("图书借阅");
		d1.setSize(300,400);
		d1.setLocationRelativeTo(null);
		d1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		d1.setVisible(true);
		
	}
	                                                                                                       

}
