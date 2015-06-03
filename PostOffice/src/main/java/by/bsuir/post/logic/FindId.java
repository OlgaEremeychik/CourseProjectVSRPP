/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Post;
import by.bsuir.post.model.PostDao;

/**
 *
 * @author notepad
 */
public class FindId {
    public static Post find(int id){
        return new PostDao().findById(id);
    }
}
