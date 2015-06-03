/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.ShowPost;
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
public class CShowPost  implements ICommand{
    private final static String PARAM = "listPost";
    private final static String FORWARD_PAGE = PageManager.getInstance().getProperty(PageManager.ALL_POST_PAGE);
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        try {
            List<Post> list = ShowPost.show();
            request.setAttribute(PARAM, list);
            forwardPage = FORWARD_PAGE;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return forwardPage;
    }
    
}
