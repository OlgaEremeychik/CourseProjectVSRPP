/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.FindId;
import by.bsuir.post.manager.PageManager;
import by.bsuir.post.model.Post;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author notepad
 */
public class CFindId implements ICommand {

    private final static String PARAM_POST = "post";
    private final static String FORWARD_PAGE = PageManager.getInstance().getProperty(PageManager.FIND_POST_ID);
    private final static String WRONG_PAGE = PageManager.getInstance().getProperty(PageManager.WRONG_PAGE);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        Post post = null;
        int id = (int) request.getAttribute("id");
        try {
            post = FindId.find(id);
            request.setAttribute(PARAM_POST, post);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (post == null) {
            return WRONG_PAGE;
        } else {
            return forwardPage = FORWARD_PAGE;
        }
    }

}
