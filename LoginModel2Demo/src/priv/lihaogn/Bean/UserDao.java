package priv.lihaogn.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	//��ѯ�û������ݿ����Ƿ���ڣ���ע��ʱʹ��
	public boolean userIsExist(String username){
		//��ȡ���ݿ����Ӷ���
		Connection connection=DataBaseUtil.getConnection();
		//����ָ���û�����ѯ�û���Ϣ
		String sql="select * from login_data where username=?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			//ִ�в�ѯ����ȡ�������
			ResultSet rs=ps.executeQuery();
			//�жϽ�����Ƿ���Ч
			if(!rs.next()){
				//�����Ч������û�������
				return true;
			}
			//�ͷŴ�resultset ��������ݿ��jdbc��Դ
			rs.close();
			//�ͷ�prepare��������������ݿ��jdbc��Դ
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//�ر����ݿ�����
			DataBaseUtil.closeconn(connection);
		}
		return false;
	}
	
	//�����û���Ϣ�����ݿ�
	public void saveUser(User user){
		//��ȡ���ݿ�����
		Connection connection=DataBaseUtil.getConnection();
		String sql="insert into login_data(username,password,sex) values(?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			//���²���
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeconn(connection);
		}
	}
	//��ѯ�û���Ϣ��ʵ���û���½
	public User login(String username,String password){
		
		User user=null;
		Connection conn=DataBaseUtil.getConnection();
		String sql="select * from login_data where username=? and password=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password);
			//
			ResultSet rSet=ps.executeQuery();
			//
			if(rSet.next()){
				//ʵ����һ���û�����
				user=new User();
				//���û�����ֵ
				user.setUsername(rSet.getString("username"));
				user.setPassword(rSet.getString("password"));
				user.setSex(rSet.getString("sex"));
			}
			rSet.close();
			ps.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeconn(conn);
		}
		
		return user;
	}
	
	
	
	
}
