package priv.lihaogn.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {

	//查询用户在数据库中是否存在，在注册时使用
	public boolean userIsExist(String username){
		//获取数据库连接对象
		Connection connection=DataBaseUtil.getConnection();
		//根据指定用户名查询用户信息
		String sql="select * from login_data where username=?";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, username);
			//执行查询，获取结果集合
			ResultSet rs=ps.executeQuery();
			//判断结果集是否有效
			if(!rs.next()){
				//如果无效，则此用户名可用
				return true;
			}
			//释放此resultset 对象的数据库和jdbc资源
			rs.close();
			//释放prepare。。。对象的数据库和jdbc资源
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			//关闭数据库连接
			DataBaseUtil.closeconn(connection);
		}
		return false;
	}
	
	//保存用户信息到数据库
	public void saveUser(User user){
		//获取数据库连接
		Connection connection=DataBaseUtil.getConnection();
		String sql="insert into login_data(username,password,sex) values(?,?,?)";
		try {
			PreparedStatement ps=connection.prepareStatement(sql);
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getSex());
			//更新操作
			ps.executeUpdate();
			ps.close();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DataBaseUtil.closeconn(connection);
		}
	}
	//查询用户信息以实现用户登陆
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
				//实例化一个用户对象
				user=new User();
				//对用户对象赋值
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
