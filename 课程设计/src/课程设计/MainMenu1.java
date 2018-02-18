package 课程设计;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MainMenu1 extends JFrame{
	JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	Vector<String> v =new Vector<String>();
	public MainMenu1(){
		//
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(4,1));
		p1.add(btn1=new JButton("图书管理"));
		p1.add(btn2=new JButton("借书管理"));
		p1.add(btn3=new JButton("还书管理"));
		p1.add(btn4=new JButton("预约管理"));
		final JPanel p2=new JPanel();
		p2.setLayout(new BorderLayout(1,1));
		JPanel p3=new JPanel();
		p3.setLayout(new GridLayout(1,2));
		p3.add(btn5=new JButton("增加图书"));
		p3.add(btn6=new JButton("查找删除修改图书"));
		p3.setVisible(true);
		final JPanel p4=new JPanel();
		p4.setLayout(new GridLayout(6,2));
		p4.add(jl1=new JLabel("isbn号"));
		p4.add(jtf1=new JTextField(10));
		p4.add(jl2=new JLabel("书名"));
		p4.add(jtf2=new JTextField(10));
		p4.add(jl3=new JLabel("作者"));
		p4.add(jtf3=new JTextField(10));
		p4.add(jl4=new JLabel("出版社"));
		p4.add(jtf4=new JTextField(10));
		p4.add(jl5=new JLabel("出版时间"));
		p4.add(jtf5=new JTextField(10));
		p4.add(btn10=new JButton("增加"));
		btn10.setVisible(false);
		p4.setVisible(true);
		final JPanel p5=new JPanel();
		p5.setLayout(new BorderLayout(1,1));
		final JPanel p6=new JPanel();
		p6.setLayout(new GridLayout(1,3));
		p6.add(jl6=new JLabel("书名"));
		p6.add(jtf6=new JTextField(10));
		p6.add(btn7=new JButton("查询"));
		p6.setVisible(false);
		final JPanel p7=new JPanel();
		p7.setLayout(new GridLayout(1,2));
		p7.add(btn8=new JButton("删除"));
		p7.add(btn9=new JButton("修改"));
		p7.setVisible(false);
		p5.add(p6,BorderLayout.NORTH);
		p5.add(p4,BorderLayout.CENTER);
		p5.add(p7,BorderLayout.SOUTH);
		p2.add(p3,BorderLayout.NORTH);
		p2.add(p5,BorderLayout.CENTER);
		setLayout(new BorderLayout(1,1));
		add(p1,BorderLayout.WEST);
		add(p2,BorderLayout.CENTER);
		//图书管理
		btn1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				p4.setVisible(true);
				p6.setVisible(false);
				p7.setVisible(false);
				btn10.setVisible(true);
			}
		});
		btn2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu2 m2=new MainMenu2();
				m2.setTitle("管理员客户端");
				m2.setSize(300,400);
				m2.setLocationRelativeTo(null);
				m2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m2.setVisible(true);
				dispose();
			}
		});
		btn3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu3 m3=new MainMenu3();
				m3.setTitle("管理员客户端");
				m3.setSize(300,400);
				m3.setLocationRelativeTo(null);
				m3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m3.setVisible(true);
				dispose();
			}
		});
		btn4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				MainMenu4 m4=new MainMenu4();
				m4.setTitle("管理员客户端");
				m4.setSize(300,400);
				m4.setLocationRelativeTo(null);
				m4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				m4.setVisible(true);
				dispose();
			}
		});
		btn5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				p4.setVisible(true);
				p6.setVisible(false);
				p7.setVisible(false);
				btn10.setVisible(true);
			}
		});
		btn6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				p4.setVisible(true);
				p6.setVisible(true);
				p7.setVisible(true);
				btn10.setVisible(false);
			}
		});
		btn7.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				v=DBUtil.selectAllfrombook(jtf6.getText().toString());
				jtf1.setText(v.elementAt(0));
				jtf2.setText(v.elementAt(1));
				jtf3.setText(v.elementAt(2));
				jtf4.setText(v.elementAt(3));
				jtf5.setText(v.elementAt(4));
			}
		});
		btn8.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str1="delete from BookInformation where isbn='"+jtf1.getText().toString()+"' and bookname='"+jtf2.getText().toString()+"'";
				DBUtil.update(str1);
			}
		});
		btn9.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str2="delete from BookInformation where isbn='"+v.elementAt(0)+"' and bookname='"+v.elementAt(1)+"'";
				String str3="insert into BookInformation values ('"+jtf1.getText().toString()+"','"+jtf2.getText().toString()+"','"+jtf3.getText().toString()+"','"+jtf4.getText().toString()+"','"+jtf5.getText().toString()+"')";
				DBUtil.update(str2);
				DBUtil.update(str3);
			}
		});
		btn10.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String str="insert into BookInformation values ('"+jtf1.getText().toString()+"','"+jtf2.getText().toString()+"','"+jtf3.getText().toString()+"','"+jtf4.getText().toString()+"','"+jtf5.getText().toString()+"')";
				DBUtil.update(str);
			}
		});
	
	}

}
