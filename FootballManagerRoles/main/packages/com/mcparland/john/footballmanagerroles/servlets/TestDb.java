package com.mcparland.john.footballmanagerroles.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtilsBean2;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mcparland.john.footballmanagerroles.FootballManagerRoles;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;

/**
 * Servlet implementation class TestDb
 */
@WebServlet("/TestDb")
public class TestDb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FootballManagerRoles footballManagerRoles = (FootballManagerRoles) WebApplicationContextUtils
		.getWebApplicationContext(getServletContext()).getBean("footballManagerRoles");
		
		// Create a factory for disk-based file items
		FileItemFactory factory = new DiskFileItemFactory();

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		response.getWriter().append("<html><body>");
		// Parse the request
		try {
			List<FileItem> items = upload.parseRequest(request);
			for (FileItem item : items) {
				response.getWriter().append("<hr/>");				
				File f = File.createTempFile("fmr_tmp_", item.getName());
				item.write(f);
				PlayerRecommendations pr = footballManagerRoles.process(f);
				f.delete();
				response.getWriter().append(BeanUtilsBean2.getInstance().describe(pr.getPlayer())
						.toString().replaceAll(",", "<br/>"));
				response.getWriter().append("<br/><br/>Recomendations: <br/>");
				response.getWriter().append(pr.getRecommendations().getRecommendations()
						.toString().replaceAll(",", "<br/>"));				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.getWriter().append(e.getLocalizedMessage());
		}
		response.getWriter().append("</body></html>");		
		response.getWriter().close();
	}

}
