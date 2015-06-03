/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.manager;

import java.util.ResourceBundle;

/**
 *
 * @author notepad
 */
public class PageManager {

    private static PageManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "pages";

    public final static String ALL_POST_PAGE = "ALL_POST_PAGE";
    public final static String ADD_POST_PAGE = "ADD_POST_PAGE";
    public final static String FIND_POST_ID = "FIND_POST_ID";
    public final static String FIND_POST_FROM = "FIND_POST_FROM";
    public final static String WRONG_PAGE = "WRONG_PAGE";

    public static PageManager getInstance() {
        if (instance == null) {
            instance = new PageManager();
            instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
