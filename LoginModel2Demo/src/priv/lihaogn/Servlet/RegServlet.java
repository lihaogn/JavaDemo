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
		//��ȡ�û���Ϣ
		String username=request.getParameter("username");
		String pwd=request.getParameter("password");
		String sex=request.getParameter("sex");
		//ʵ����userdao
		UserDao userDao=new UserDao();
		if(username!=null && !username.isEmpty()){
			if (userDao.userIsExist(username)) {
				//ʵ����һ��user����
				User user=new User();
				//��ֵ
				user.setUsername(username);
				user.setPassword(pwd);
				user.setSex(sex);
				//�����û�ע����Ϣ
				userDao.saveUser(user);
				request.setAttribute("info","ע��ɹ���<br>");
			}else {
				request.setAttribute("info", "ע��ʧ�ܣ����û����Ѵ���");
			}
		}
		//ת����message.japҳ��
		request.getRequestDispatcher("message.jsp").forward(request, response);
	}
	
}
