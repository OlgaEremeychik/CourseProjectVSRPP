/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.RemovePost;
import by.bsuir.post.manager.PageManager;
import by.bsuir.post.model.PostDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author notepad
 */
public class CRemovePost implements ICommand {

    private final static String WRONG_PAGE = PageManager.getInstance().getProperty(PageManager.WRONG_PAGE);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        try {
            if(!request.getParameter("id").equalsIgnoreCase("")){
            int id = Integer.valueOf(request.getParameter("id"));
            boolean result = RemovePost.remove(id);
            if (result == true) {
                forwardPage = new CShowPost().execute(request, response);
            } else {
                return forwardPage = WRONG_PAGE;
            }
            }
            else return WRONG_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return forwardPage;
    }

}
