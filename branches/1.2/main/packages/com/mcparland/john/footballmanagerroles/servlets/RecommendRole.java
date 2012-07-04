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
import java.net.FileNameMap;
import java.net.URLConnection;
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
import org.apache.log4j.Logger;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.mcparland.john.footballmanagerroles.FootballManagerRoles;
import com.mcparland.john.footballmanagerroles.parser.PlayerTextParser;
import com.mcparland.john.footballmanagerroles.recommend.PlayerRecommendations;
import com.mcparland.john.footballmanagerroles.support.HtmlErrorReporter;
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
     * Logger for this class
     */
    private static final Logger LOGGER = Logger.getLogger(RecommendRole.class);

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
     * The bean which parses the file
     */
    private static final String PARSER_BEAN = "parser";

    /**
     * Bean for errors
     */
    private static final String ERROR_REPORTER_BEAN = "htmlErrorReporter";

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
        PlayerTextParser parser = (PlayerTextParser) WebApplicationContextUtils.getWebApplicationContext(
                getServletContext()).getBean(PARSER_BEAN);
        HtmlErrorReporter errorReporter = (HtmlErrorReporter) WebApplicationContextUtils.getWebApplicationContext(
                getServletContext()).getBean(ERROR_REPORTER_BEAN);
        errorReporter.setResponse(response);

        // Create a factory for disk-based file items
        FileItemFactory factory = new DiskFileItemFactory();

        // Create a new file upload handler
        ServletFileUpload upload = new ServletFileUpload(factory);
        // Parse the request
        List<FileItem> items = null;
        File f = null;
        try {
            items = upload.parseRequest(request);
            if (1 != items.size()) {
                errorReporter.report("More than one file was supplied.  Please upload just one file");
            } else {
                FileItem item = items.get(0);
                // Get the file onto the server
                f = File.createTempFile("fmr_tmp_" + System.currentTimeMillis(), item.getName());
                LOGGER.debug("Created temp file: " + f.getAbsolutePath());
                item.write(f);
                LOGGER.debug("Wrote temp file: " + f.getAbsolutePath());
                if (isRtfFile(f.getAbsolutePath())) {
                    // Process the file
                    PlayerRecommendations pr = footballManagerRoles.process(f);
                    pr.getPlayer().setName(parser.getPlayerNameFromFileName(item.getName()));

                    // Now show the result!
                    view.view(pr, response);
                } else {
                    errorReporter.report("Please upload an RTF file only");
                }
            }
        } catch (Throwable th) {
            LOGGER.error("Caught an unexpected throwable: " + th.getMessage());
            th.printStackTrace();
            errorReporter.report("Sorry, something unexpected has happened.  Please check your file and try again", th);
        } finally {
            LOGGER.debug("In finally");
            // Clean up
            if (null != f && f.exists() && f.isFile()) {
                f.delete();
                LOGGER.debug("Deleted file: " + f.getAbsolutePath());
            } else {
                LOGGER.warn("Did not delete file");
            }
            cleanUp(items);
            response.getWriter().close();
        }
    }

    /**
     * Clean up the items
     * 
     * @param items
     *            the items to clean up
     */
    public void cleanUp(List<FileItem> items) {
        LOGGER.debug("Cleaning up items");
        for (FileItem item : items) {
            item.delete();
            LOGGER.debug("Deleted item");
        }
    }

    /**
     * Get the Mime Type of the file. Obtained from
     * http://www.rgagnon.com/javadetails/java-0487.html
     * 
     * @param fileUrl
     *            the name of the file - needs full path
     * @return the type of the file
     * @throws java.io.IOException
     *             If there is any problem reading the file
     */
    public static String getMimeType(String fileUrl) throws java.io.IOException {
        FileNameMap fileNameMap = URLConnection.getFileNameMap();
        String type = fileNameMap.getContentTypeFor(fileUrl);

        return type;
    }

    /**
     * Is the given file an RTF file?
     * 
     * @param filePath
     *            the path to the file including its name
     * @return true if the file is RTF, false otherwise
     * @throws IOException
     *             If there is any problem checking the file
     */
    public boolean isRtfFile(String filePath) throws IOException {
        LOGGER.info("Uploaded file: "+filePath);
        LOGGER.info("Mime Type: "+getMimeType(filePath));
        final String mimeType = getMimeType(filePath);
        if (null == mimeType) {
            final String extension = filePath.substring(filePath.length()-4);
            LOGGER.info("Extension: "+extension);
            return ".rtf".equals(extension.toLowerCase());
        } else {
            return "application/rtf".equals(mimeType);   
        }
    }

}
