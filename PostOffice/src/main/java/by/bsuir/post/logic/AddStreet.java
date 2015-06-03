/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Street;
import by.bsuir.post.model.StreetDao;

/**
 *
 * @author notepad
 */
public class AddStreet {
    public static boolean add(Street entity){
        return new StreetDao().creat(entity);
    }
}
