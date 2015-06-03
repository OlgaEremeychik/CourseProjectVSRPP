/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.ToWho;
import by.bsuir.post.model.ToWhoDao;

/**
 *
 * @author notepad
 */
public class AddTo {

    public static boolean add(ToWho entity) {
        return new ToWhoDao().creat(entity);
    }
}
