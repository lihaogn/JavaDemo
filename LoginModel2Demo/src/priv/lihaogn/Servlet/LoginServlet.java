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
		
		//��ȡ�û���Ϣ
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		//ʵ����userdao����
		UserDao userDao=new UserDao();
		//���������ѯ�û�
		User user=userDao.login(username, pwd);
		//�ж�user�Ƿ�Ϊ��
		if(user!=null){
			//���û�����Ž�session��
			request.getSession().setAttribute("user", user);
			//ת����result.jspҳ��
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}else {
			//��½ʧ��
			request.setAttribute("info", "��½ʧ�ܣ��û������������");
			request.getRequestDispatcher("message.jsp").forward(request, response);
		}
	}

}
