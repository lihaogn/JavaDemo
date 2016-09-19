package priv.lihaogn.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import priv.lihaogn.Bean.User;

/**
 * Servlet implementation class UserExitServlet
 */
@WebServlet("/UserExitServlet")
public class UserExitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserExitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//��ȡsession
		HttpSession session=request.getSession();
		//��ȡ�û�����
		User user=(User)session.getAttribute("user");
		//�ж��û��Ƿ���Ч
		if(user!=null){
			//���û������session���
			session.removeAttribute("user");
			//������ʾ��Ϣ
			request.setAttribute("info", user.getUsername()+"�ѳɹ��˳�");
		}
		//ת��ҳ��
		request.getRequestDispatcher("message,jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}