package ziozio.controller.ajax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ziozio.service.face.DuplicateCheckService;
import ziozio.service.impl.EmailCheckService;
import ziozio.utils.paramparser.InvalidParamException;

/**
 * Servlet implementation class EmailCheck
 */
@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private DuplicateCheckService checker = EmailCheckService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		try {
			boolean isDuplicated = checker.isDuplicated(req);
			if (isDuplicated) checker.sendErrorMessage(resp);
			else checker.sendOkMessage(resp);
		} catch (InvalidParamException e) {
			checker.sendErrorMessage(resp);
		}
	}
	
}
