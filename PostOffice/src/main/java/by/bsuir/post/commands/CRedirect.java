/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.ReadAll;
import by.bsuir.post.logic.ShowPost;
import by.bsuir.post.manager.PageManager;
import by.bsuir.post.model.Country;
import by.bsuir.post.model.Post;
import by.bsuir.post.model.Town;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author notepad
 */
public class CRedirect implements ICommand {

    private final static String PARAM_COUNTRY = "listCountry";
    private final static String PARAM_TOWN = "listTown";
    private final static String FORWARD_PAGE_ADD = PageManager.getInstance().getProperty(PageManager.ADD_POST_PAGE);
    private final static String FORWAD_PAGE_FIND_ID = PageManager.getInstance().getProperty(PageManager.FIND_POST_ID);
    private final static String FORWARD_PAGE_FIND_FROM = PageManager.getInstance().getProperty(PageManager.FIND_POST_FROM);
    private final static String WRONG_PAGE = PageManager.getInstance().getProperty(PageManager.WRONG_PAGE);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        if (request.getParameter("hidden").equalsIgnoreCase("add")) {
            List<Town> listTown = null;
            List<Country> listCountry = null;
            listTown = ReadAll.readTown();
            listCountry = ReadAll.readCountry();
            request.setAttribute(PARAM_TOWN, listTown);
            request.setAttribute(PARAM_COUNTRY, listCountry);
            forwardPage = FORWARD_PAGE_ADD;
            return forwardPage;
        } else if (request.getParameter("hidden").equalsIgnoreCase("find_id")) {
            if (!request.getParameter("id").equalsIgnoreCase("")) {
                request.setAttribute("id", Integer.valueOf(request.getParameter("id")));
                forwardPage = new CFindId().execute(request, response);
                return forwardPage;
            } else {
                return WRONG_PAGE;
            }
        } else if (request.getParameter("hidden").equalsIgnoreCase("find_from")) {
            request.setAttribute("lastName", request.getParameter("lastName"));
            forwardPage = new CFindFrom().execute(request, response);
            return forwardPage;
        } else if (request.getParameter("hidden").equalsIgnoreCase("back")) {
            System.out.println("ASDASDASD");
            forwardPage = "/index.jsp";
            return forwardPage;
        }
        return WRONG_PAGE;
    }

}
