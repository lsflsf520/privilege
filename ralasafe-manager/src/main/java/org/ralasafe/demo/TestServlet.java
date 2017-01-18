/**
 * Copyright (c) 2004-2011 Wang Jinbao(Julian Wong), http://www.ralasafe.com
 * Licensed under the MIT license: http://www.opensource.org/licenses/mit-license.php
 */
package org.ralasafe.demo;

import org.ralasafe.Ralasafe;
import org.ralasafe.user.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestServlet extends HttpServlet {
	private LoanMoneyManager loanManager=new LoanMoneyManager();
	
	protected void doGet( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {

		User user = new User();
		String uid = req.getParameter("uid");
		user.setId(uid);

		boolean result = Ralasafe.hasPrivilege(PrivConstant.RET_MONEY, user);
		req.setAttribute("result", result);

		RequestDispatcher rd=req.getRequestDispatcher( "test.jsp" );
		rd.forward( req, resp );
	}

	protected void doPost( HttpServletRequest req, HttpServletResponse resp )
			throws ServletException, IOException {
		doGet( req, resp );
	}
}
