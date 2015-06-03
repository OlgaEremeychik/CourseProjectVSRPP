/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Post;
import by.bsuir.post.model.PostDao;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author notepad
 */
public class FindFrom {
    public static List<Post> find(String lastName){
       List<Post> listPost = null;
       List<Post> list = new ArrayList<Post>();
       listPost = new PostDao().read();
       for(Post post : listPost){
           if(post.getIdFrom().getLastName().equalsIgnoreCase(lastName))
               list.add(post);
       }
       return list;
    }
}
