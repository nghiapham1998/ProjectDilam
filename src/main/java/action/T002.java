package action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import common.Constant;
import dao.MstCustomerDAO;

/**
 * Servlet implementation class T002
 */
@WebServlet("/T002")
public class T002 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public T002() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession s = request.getSession();
		request.setAttribute("userId",s.getAttribute("userId"));
	
		String indexPage = request.getParameter("index");
		if(indexPage == null) {
		   indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		
		int count = MstCustomerDAO.getTotalCustomer();
		int endPage = count/15;
		if(count/3 != 0) {
			endPage++;
		}
		 System.out.println(count);
		request.setAttribute("endP", endPage);
		request.setAttribute("CustomerList", MstCustomerDAO.pagingMstCustomer(index));
		request.getRequestDispatcher(Constant.T001_Search).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		switch(action) {
		   case "delete": 
				String[] customerId = request.getParameterValues("cbCustomer");
				float[] ints = new float[customerId.length];
				for (int a = 0; a <customerId.length; a++) {   
				   try {
				      ints[a] = Float.parseFloat(customerId[a]);
				   } catch (Exception e) {
				       e.printStackTrace();
				   }
				}
			try {
				MstCustomerDAO.delete(ints);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				request.setAttribute("CustomerList", MstCustomerDAO.findAll());
 
			    response.sendRedirect("T002");

				
				break;
		}
		
	
	}

}
