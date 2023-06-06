package com.simplilearn.productportal.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.simplilearn.productportal.model.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/ProductServlet")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        HttpSession session = request.getSession();
		
        Product product = new Product();
		product.setpName(request.getParameter("pName"));
		product.setpDesc(request.getParameter("pDesc"));
		product.setpColour(request.getParameter("pColour"));
		product.setpQuantity(request.getParameter("pQuantity"));
		product.setpCostPrice(request.getParameter("pCostPrice"));
		product.setpSalePrice(request.getParameter("pSalePrice"));
		
        session.setAttribute("sName",  request.getParameter("pName"));
        session.setAttribute("sColour",  request.getParameter("pColour"));
        session.setAttribute("sDesc",  request.getParameter("pDesc"));
        session.setAttribute("sQuantity",  request.getParameter("pQuantity"));
        session.setAttribute("sCostPrice",  request.getParameter("pCostPrice"));
        session.setAttribute("sSalePrice",  request.getParameter("pSalePrice"));
		
  	    request.getRequestDispatcher("ProductDisplay.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
