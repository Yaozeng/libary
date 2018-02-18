package �γ����;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
public class DBUtil 
	{
	    public static Connection getConnection()
		{
			Connection con=null;
			try
			{			
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/libary?useUnicode=true&characterEncoding=UTF-8&useSSL=false","root","yaozwin1115");  		    
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			return con;
		}
	    
	    
	    //֪��ѧ����ѧ�ŵõ���������
	    public static String selectPwd(String S_Num,String user)
	    {
			String result=null;
			String sql="";
			try
			{
				Connection con=getConnection();			
				Statement st=con.createStatement();
				if(user=="����Ա")
				{
			     sql="select passpord from manager where managerid='"+S_Num+"'";
				}
				else{
				 sql="select passpord from ReaderInformation where ReaderNo='"+S_Num+"'";
				}
				ResultSet rs=st.executeQuery(sql);
				if(rs.next())
				{
					result=rs.getString(1);
				}
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
	    	return result;   	
	    }
	    public static Vector<String> selectAllfrombook(String BookName)
	    {
	    	Vector<String> v =new Vector<String>();
	    	int lenght=0;
	    	try
			{
	    	//�����ں�̨��ӡ    		
				Connection con=getConnection();				
				Statement st=con.createStatement();
				String sql="select isbn,Bookname,Authorname,press,pressDate from BookInformation where Bookname like '%"+BookName+"%'";
				ResultSet rs=st.executeQuery(sql);				
				while(rs.next()){//���������Ϣ��ӵ�����������								
					//String[] middle=new String[6];				
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));
					v.add(rs.getString(4));	
					v.add(rs.getString(5));
				}			
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return v; 
	    } 
	    public static Vector<String> selectAllfrombrrowBook(String BookName)
	    {
	    	Vector<String> v =new Vector<String>();
	    	int lenght=0;
	    	try
			{
	    	//�����ں�̨��ӡ    		
				Connection con=getConnection();				
				Statement st=con.createStatement();
				String sql="select * from brrowbook where bookname like '"+BookName+"' and Readerno like'"+Constant.username+"'";
				ResultSet rs=st.executeQuery(sql);				
				while(rs.next()){//���������Ϣ��ӵ�����������								
					//String[] middle=new String[6];				
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));
					v.add(rs.getString(4));				
				}			
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return v; 
	    } 
	    public static Vector<String> selectAllfromlosebook(String BookName)
	    {
	    	Vector<String> v =new Vector<String>();
	    	int lenght=0;
	    	try
			{
	    	//�����ں�̨��ӡ    		
				Connection con=getConnection();				
				Statement st=con.createStatement();
				String sql="select Readerno,bookname,losstime from loss where bookname like '%"+BookName+"%' and Readerno='"+Constant.username+"'";
				ResultSet rs=st.executeQuery(sql);				
				while(rs.next()){//���������Ϣ��ӵ�����������								
					//String[] middle=new String[6];				
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));			
				}			
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return v; 
	    } 
	    public static void update(String sql)
	    {
	    	try
			{
				Connection con=getConnection();			
				Statement st=con.createStatement();			
				st.executeUpdate(sql);	
				JOptionPane.showMessageDialog(null,"�ɹ�");
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
				JOptionPane.showMessageDialog(null,"ʧ��");
			}
	    }


		public static Vector<String> selectAllfromreturnBook(String BookName) {
	    	Vector<String> v =new Vector<String>();
	    	int lenght=0;
	    	try
			{
	    	//�����ں�̨��ӡ    		
				Connection con=getConnection();				
				Statement st=con.createStatement();
				String sql="select Readerno,bookname,returntime from returnbook where bookname like '%"+BookName+"%' and Readerno='"+Constant.username+"'";
				ResultSet rs=st.executeQuery(sql);				
				while(rs.next()){//���������Ϣ��ӵ�����������								
					//String[] middle=new String[6];				
					v.add(rs.getString(1));
					v.add(rs.getString(2));
					v.add(rs.getString(3));			
				}			
				rs.close();
				st.close();
				con.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
			return v; 
		}
		  public static Vector<String> selectAllfromsubscribeBook(String BookName)
		    {
		    	Vector<String> v =new Vector<String>();
		    	int lenght=0;
		    	try
				{
		    	//�����ں�̨��ӡ    		
					Connection con=getConnection();				
					Statement st=con.createStatement();
					String sql="select * from subscribe where bookname like '"+BookName+"' and Readerno like'"+Constant.username+"'";
					ResultSet rs=st.executeQuery(sql);				
					while(rs.next()){//���������Ϣ��ӵ�����������								
						//String[] middle=new String[6];				
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getString(3));			
					}			
					rs.close();
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return v; 
		    } 
		  public static Vector<String> selectAllfrombrrowBook1(String sql)
		    {
		    	Vector<String> v =new Vector<String>();
		    	int lenght=0;
		    	try
				{
		    	//�����ں�̨��ӡ    		
					Connection con=getConnection();				
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);				
					while(rs.next()){//���������Ϣ��ӵ�����������								
						//String[] middle=new String[6];				
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getString(3));
						v.add(rs.getString(4));				
					}			
					rs.close();
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return v; 
		    } 
		  public static Vector<String> selectAllfromreturnBook1(String sql)
		    {
		    	Vector<String> v =new Vector<String>();
		    	int lenght=0;
		    	try
				{
		    	//�����ں�̨��ӡ    		
					Connection con=getConnection();				
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);				
					while(rs.next()){//���������Ϣ��ӵ�����������								
						//String[] middle=new String[6];				
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getString(3));			
					}			
					rs.close();
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return v; 
		    } 
		  public static Vector<String> selectAllfromlosebook1(String sql)
		    {
		    	Vector<String> v =new Vector<String>();
		    	int lenght=0;
		    	try
				{
		    	//�����ں�̨��ӡ    		
					Connection con=getConnection();				
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);				
					while(rs.next()){//���������Ϣ��ӵ�����������								
						//String[] middle=new String[6];				
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getString(3));			
					}			
					rs.close();
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return v; 
		    } 
		  public static Vector<String> selectAllfromsubscribeBook1(String sql)
		    {
		    	Vector<String> v =new Vector<String>();
		    	int lenght=0;
		    	try
				{
		    	//�����ں�̨��ӡ    		
					Connection con=getConnection();				
					Statement st=con.createStatement();
					ResultSet rs=st.executeQuery(sql);				
					while(rs.next()){//���������Ϣ��ӵ�����������								
						//String[] middle=new String[6];				
						v.add(rs.getString(1));
						v.add(rs.getString(2));
						v.add(rs.getString(3));		
					}			
					rs.close();
					st.close();
					con.close();
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
				
				return v; 
		    } 
	    
	    
}


