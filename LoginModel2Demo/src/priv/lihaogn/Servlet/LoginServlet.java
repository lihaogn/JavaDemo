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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		//获取用户信息
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		//实例化userdao对象
		UserDao userDao=new UserDao();
		//根据密码查询用户
		User user=userDao.login(username, pwd);
		//判断user是否为空
		if(user!=null){
			//将用户对象放进session中
			request.getSession().setAttribute("user", user);
			//转发到result.jsp页面
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			//登陆失败
			request.setAttribute("info", "登陆失败，用户名或密码错误");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
