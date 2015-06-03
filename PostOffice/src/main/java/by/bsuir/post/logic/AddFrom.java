/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.FromWho;
import by.bsuir.post.model.FromWhoDao;

/**
 *
 * @author notepad
 */
public class AddFrom {

    public static boolean add(FromWho entity) {
        return new FromWhoDao().creat(entity);
    }
}
