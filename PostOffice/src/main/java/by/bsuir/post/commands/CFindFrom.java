/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.FindFrom;
import by.bsuir.post.manager.PageManager;
import by.bsuir.post.model.Post;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author notepad
 */
public class CFindFrom implements ICommand{
    private final static String PARAM_POST = "listPost";
    private final static String FORWARD_PAGE = PageManager.getInstance().getProperty(PageManager.FIND_POST_FROM);
    private final static String WRONG_PAGE = PageManager.getInstance().getProperty(PageManager.WRONG_PAGE);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        List<Post> listPost = null;
        System.out.println(request.getAttribute("lastName"));
        try {
            listPost = FindFrom.find((String) request.getAttribute("lastName"));
            request.setAttribute(PARAM_POST, listPost);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
        if (listPost.size() == 0) {
            return WRONG_PAGE;
        } else {
            return forwardPage = FORWARD_PAGE;
        }
    }
}
