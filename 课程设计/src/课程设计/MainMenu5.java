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
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainMenu5 extends JFrame {
	JButton btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10;
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf6;
	Vector<String> v =new Vector<String>();
	public MainMenu5(){
	JPanel p1=new JPanel();
	p1.setLayout(new GridLayout(3,1));
	p1.add(btn2=new JButton("借书管理"));
	p1.add(btn3=new JButton("还书管理"));
	p1.add(btn4=new JButton("预约管理"));
	final JPanel p2=new JPanel();
	p2.setLayout(new BorderLayout(1,1));
	final JPanel p3=new JPanel();
	p3.setLayout(new GridLayout(1,2));
	p3.add(btn5=new JButton("已借图书"));
	p3.add(btn6=new JButton("可借图书"));
	p3.setVisible(true);
	final JPanel p4=new JPanel();
	final JTextArea jta=new JTextArea(16,15);
	JScrollPane scroll=new JScrollPane(jta);
	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
	p4.add(scroll);  
	p4.setVisible(true);
	final JPanel p5=new JPanel();
	p5.setLayout(new BorderLayout(1,1));
	final JPanel p6=new JPanel();
	p6.setLayout(new GridLayout(1,3));
	p6.add(jl6=new JLabel("书名"));
	p6.add(jtf6=new JTextField(10));
	p6.add(btn7=new JButton("查询"));
	p6.setVisible(false);
	final JPanel p8=new JPanel();
	p8.setLayout(new GridLayout(4,2));
	p8.add(jl1=new JLabel("学号"));
	p8.add(jtf1=new JTextField(10));
	p8.add(jl2=new JLabel("书名"));
	p8.add(jtf2=new JTextField(10));
	p8.add(jl3=new JLabel("借书时间"));
	p8.add(jtf3=new JTextField(10));
	p8.add(jl4=new JLabel("还书时间"));
	p8.add(jtf4=new JTextField(10));
	p8.setVisible(false);
	final JPanel p7=new JPanel();
	p7.setLayout(new GridLayout(1,2));
	p7.add(btn8=new JButton("续借"));
	p7.add(btn9=new JButton("删除"));
	p7.setVisible(false);
	p5.add(p6,BorderLayout.NORTH);
	p5.add(p8,BorderLayout.CENTER);
	p5.add(p7,BorderLayout.SOUTH);
	p2.add(p3,BorderLayout.NORTH);
	p2.add(p5,BorderLayout.CENTER);
	p2.add(p4,BorderLayout.SOUTH);
	setLayout(new BorderLayout(1,1));
	add(p1,BorderLayout.WEST);
	add(p2,BorderLayout.CENTER);
	btn2.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p4.setVisible(true);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
		}
	});
	btn3.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			MainMenu6 m6=new MainMenu6();
			m6.setTitle("学生客户端");
			m6.setSize(300,400);
			m6.setLocationRelativeTo(null);
			m6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m6.setVisible(true);
			dispose();
		}
	});
	btn4.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			MainMenu7 m7=new MainMenu7();
			m7.setTitle("学生客户端");
			m7.setSize(300,400);
			m7.setLocationRelativeTo(null);
			m7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			m7.setVisible(true);
			dispose();
		}
	});
	btn5.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p4.setVisible(true);
			p6.setVisible(false);
			p7.setVisible(false);
			p8.setVisible(false);
		    String str2="select * from brrowbook where Readerno='"+Constant.username+"'";
		    v=DBUtil.selectAllfrombrrowBook1(str2);
		    String str0="学号  书名  借书时间  还书时间\n";
		    for(int i=0;i<v.size();i++){
		    	str0=str0+v.elementAt(i)+" ";
		    	if((i+1)%4==0)
		    	{
		    		str0+="\n";
		    	}
		    }
		    jta.setText(str0);
		}
	});
	btn6.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			p4.setVisible(false);
			p6.setVisible(true);
			p7.setVisible(true);
			p8.setVisible(true);
		}
	});
	btn7.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			v=DBUtil.selectAllfrombrrowBook(jtf6.getText().toString());
			jtf1.setText(v.elementAt(0));
			jtf2.setText(v.elementAt(1));
			jtf3.setText(v.elementAt(2));
			jtf4.setText(v.elementAt(3));
		}
	});
	btn8.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			//String str2="delete from brrowbook where Readerno='"+v.elementAt(0)+"' and bookname='"+v.elementAt(1)+"'";
			String str3="insert into brrowbook values ('"+jtf1.getText().toString()+"','"+jtf2.getText().toString()+"','"+jtf3.getText().toString()+"','"+jtf4.getText().toString()+"')";
			//DBUtil.update(str2);
			DBUtil.update(str3);
		}
	});
	btn9.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			String str1="delete from brrowbook where Readerno='"+jtf1.getText().toString()+"' and bookname='"+jtf2.getText().toString()+"'";
			DBUtil.update(str1);
		}
	});
	}
}
