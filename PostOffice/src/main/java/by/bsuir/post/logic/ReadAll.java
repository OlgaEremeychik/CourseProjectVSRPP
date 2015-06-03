/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.logic;

import by.bsuir.post.model.Adress;
import by.bsuir.post.model.AdressDao;
import by.bsuir.post.model.Country;
import by.bsuir.post.model.CountryDao;
import by.bsuir.post.model.Street;
import by.bsuir.post.model.StreetDao;
import by.bsuir.post.model.Town;
import by.bsuir.post.model.TownDao;
import java.util.List;

/**
 *
 * @author notepad
 */
public class ReadAll {
    public static List<Adress> readAdress(){
       return new AdressDao().read();
    }
    public static List<Country> readCountry(){
        return new CountryDao().read();
    }
    public static List<Town> readTown(){
        return new TownDao().read();
    }
    public static List<Street> readStreet(){
        return new StreetDao().read();
    }
}
