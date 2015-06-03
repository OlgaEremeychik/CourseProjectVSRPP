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
public class CommandManager {

    private static CommandManager instance;
    private ResourceBundle resourceBundle;
    private static final String BUNDLE_NAME = "commands";

    public final static String SHOW_ALL = "SHOW_ALL";
    public final static String REMOVE_POST = "REMOVE_POST";
    public final static String REDIRECT = "REDIRECT";
    public final static String ADD_POST = "ADD_POST";
    public final static String FIND_ID = "FIND_ID";
    public final static String FIND_FROM = "FIND_FROM";

    public static CommandManager getInstance() {
        if (instance == null) {
            instance = new CommandManager();
            instance.resourceBundle
                    = ResourceBundle.getBundle(BUNDLE_NAME);
        }
        return instance;
    }

    public String getProperty(String key) {
        return (String) resourceBundle.getObject(key);
    }
}
