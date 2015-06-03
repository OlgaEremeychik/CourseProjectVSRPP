/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Country;
import by.bsuir.post.model.CountryDao;

/**
 *
 * @author notepad
 */
public class AddCountry {
    public static boolean add(Country entity){
       return new CountryDao().creat(entity);
    }
}
