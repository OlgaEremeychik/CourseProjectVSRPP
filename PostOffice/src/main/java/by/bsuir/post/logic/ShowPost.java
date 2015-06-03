/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Post;
import by.bsuir.post.model.PostDao;
import java.util.List;

/**
 *
 * @author notepad
 */
public class ShowPost {
    public static List<Post> show(){
        List<Post> listPost = null;
        listPost = new PostDao().read();
        return listPost;
    }
}
