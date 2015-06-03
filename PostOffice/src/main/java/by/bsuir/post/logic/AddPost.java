/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Post;
import by.bsuir.post.model.PostDao;
import by.bsuir.post.model.Town;
import by.bsuir.post.model.TownDao;
import java.util.List;

/**
 *
 * @author notepad
 */
public class AddPost {
    public static boolean add(Post entity){
        new PostDao().creat(entity);
        return true;
    }
}
