/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Adress;
import by.bsuir.post.model.AdressDao;

/**
 *
 * @author notepad
 */
public class AddAdress {
    public static boolean add(Adress entity){
        return new AdressDao().creat(entity);
    }
}
