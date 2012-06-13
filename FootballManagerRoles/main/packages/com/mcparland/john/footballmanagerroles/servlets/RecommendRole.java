/*
 * A program to determine the best role for footballer in the Football Manager game
 * Copyright (C) 2011-12  John McParland (johnmmcparland@gmail.com)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details. 
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.mcparland.john.footballmanagerroles.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mcparland.john.footballmanagerroles.FootballManagerRoles;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;
import com.mcparland.john.footballmanagerroles.view.FootballManagerRolesView;

/**
 * Controller for the Football Manager Roles application
 * <p>
 * Controls the flow between input and output
 * </p>
 * 
 * @author Dariusz Majewski (initial, including the main file upload aspect)
 * @author John McParland (johnmmcparland@gmail.com)
 */
@WebServlet("/RecommendRole")
public class RecommendRole extends HttpServlet {

    /**
     * @see {@link java.io.Serializable}
     */
    private static final long serialVersionUID = 1L;

    /**
     * The bean which is the "model" of the application
     */
    private static final String MODEL_BEAN = "footballManagerRoles";

    /**
     * The bean which is the "view" of the application
     */
    private static final String VIEW_BEAN = "footballManagerRolesView";

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    @SuppressWarnings("unchecked")
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        // Get the beans we need
        FootballManagerRoles footballManagerRoles = (FootballManagerRoles) WebApplicationContextUtils
                .getWebApplicationContext(getServletContext()).getBean(MODEL_BEAN);
        FootballManagerRolesView view = (FootballManagerRolesView) WebApplicationContextUtils.getWebApplicationContext(
                getServletContext()).getBean(VIEW_BEAN);

        // Create a factory for disk-based file items
        FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        response.getWriter().append("<html><body>");
        // Parse the request
        try {
            List<FileItem> items = upload.parseRequest(request);
            for (FileItem item : items) {
                // Get the file inot the server
                response.getWriter().append("<hr/>");
                File f = File.createTempFile("fmr_tmp_", item.getName());
                item.write(f);

                // Process the file
                PlayerRecommendations pr = footballManagerRoles.process(f);

                // Clean up
                f.delete();

                // Now show the result!
                view.view(pr, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().append(e.getLocalizedMessage());
        }
        response.getWriter().append("</body></html>");
        response.getWriter().close();
    }

}
