package action;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.ConnectDb;
import common.Constant;
import dao.MstUserDAO;

/**
 * Servlet implementation class T001
 */
@WebServlet("/T001")
public class T001 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T001() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println(ConnectDb.getConnect());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/T001.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String userId = request.getParameter("userId");
	    String password = request.getParameter("password");
	    
	    // check userId khong đc rong
	    if(userId == null || userId.trim().length() == 0) {
	    	request.setAttribute("errorMessage", Constant.errorMessageUserId );
	    	request.getRequestDispatcher(Constant.T001_Login).forward(request, response);
	    }
	    // check password khong duoc rong
	    else if(password == null || password.trim().length() == 0) {
	    	request.setAttribute("errorMessage", Constant.errorMessagePassword );
	    	request.getRequestDispatcher(Constant.T001_Login).forward(request, response);
	    // check userId and Password khong dung
	    }else if (MstUserDAO.checkLogin(userId, password) != 1) {
	    	request.setAttribute("errorMessage", Constant.errorMessageUserIdAndPassword );
	    	request.getRequestDispatcher(Constant.T001_Login).forward(request, response);
	    }else {
	    	
	    	HttpSession session = request.getSession();
	    	session.setAttribute("userId", MstUserDAO.getUser(userId).getUSERNAME());
	    	response.sendRedirect("T002");
	    }
	}

}
