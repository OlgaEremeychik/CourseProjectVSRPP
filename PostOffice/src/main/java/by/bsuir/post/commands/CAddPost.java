/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.commands;

import by.bsuir.post.logic.AddAdress;
import by.bsuir.post.logic.AddCountry;
import by.bsuir.post.logic.AddFrom;
import by.bsuir.post.logic.AddPost;
import by.bsuir.post.logic.AddStreet;
import by.bsuir.post.logic.AddTo;
import by.bsuir.post.logic.ReadAll;
import by.bsuir.post.manager.PageManager;
import by.bsuir.post.model.Adress;
import by.bsuir.post.model.Country;
import by.bsuir.post.model.FromWho;
import by.bsuir.post.model.Post;
import by.bsuir.post.model.Street;
import by.bsuir.post.model.ToWho;
import by.bsuir.post.model.Town;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 *
 * @author notepad
 */
public class CAddPost implements ICommand {

    private final static String FORWARD_PAGE = PageManager.getInstance().getProperty(PageManager.ALL_POST_PAGE);
   // private final static String WRONG_PAGE = PageManager.WRONG_PAGE;

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forwardPage = null;
        Post post = null;
        FromWho from = null;
        ToWho to = null;
        Country country = null;
        Town town = null;
        Street street = null;
        Adress adress = null;
       /* if (request.getParameter("fromLastName").equalsIgnoreCase("")) {
            return WRONG_PAGE;
        }*/
        from = new FromWho(request.getParameter("fromLastName"), request.getParameter("fromName"), request.getParameter("fromSurName"));
        to = new ToWho(request.getParameter("toLastName"),request.getParameter("toName"),request.getParameter("toSurName"));
        street = new Street(request.getParameter("street"));
        for (Town t : ReadAll.readTown()) {
            if (t.getName().equalsIgnoreCase(request.getParameter("town"))) {
                town = t;
            }
        }
        AddStreet.add(street);
        adress = new Adress(Integer.valueOf(request.getParameter("house")), Integer.valueOf(request.getParameter("flat")), street, town);
        AddAdress.add(adress);
        for (Country c : ReadAll.readCountry()) {
            if (c.getCountryName().equalsIgnoreCase(request.getParameter("country"))) {
                country = c;
                country.setIdAdress(adress);
            }
        }
        AddFrom.add(from);
        AddTo.add(to);
        AddCountry.add(country);
        post = new Post(request.getParameter("name"), from, to, country);
        AddPost.add(post);
        forwardPage = new CShowPost().execute(request, response);
        return forwardPage;
    }
}
