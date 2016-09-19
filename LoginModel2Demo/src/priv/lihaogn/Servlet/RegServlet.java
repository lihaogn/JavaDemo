package priv.lihaogn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import priv.lihaogn.Bean.User;
import priv.lihaogn.Bean.UserDao;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/RegServlet")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//获取用户信息
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String sex=request.getParameter("sex");
		//实例化userdao
		UserDao userDao=new UserDao();
		if(username!=null && !username.isEmpty()){
			if (userDao.userIsExist(username)) {
				//实例化一个user对象
				User user=new User();
				//赋值
				user.setUsername(username);
				user.setPassword(pwd);
				user.setSex(sex);
				//保存用户注册信息
				userDao.saveUser(user);
				request.setAttribute("info","注册成功！<br>");
			}else {
				request.setAttribute("info", "注册失败，此用户名已存在");
			}
		}
		//转发到message.jap页面
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
}
