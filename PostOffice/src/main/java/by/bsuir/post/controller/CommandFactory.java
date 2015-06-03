/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.controller;

import by.bsuir.post.commands.CAddPost;
import by.bsuir.post.commands.CFindFrom;
import by.bsuir.post.commands.CFindId;
import by.bsuir.post.commands.CRedirect;
import by.bsuir.post.commands.CRemovePost;
import by.bsuir.post.commands.CShowPost;
import by.bsuir.post.commands.ICommand;
import by.bsuir.post.manager.CommandManager;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author notepad
 */
public class CommandFactory {

    private static final String COMMAND_PARAMETER = "command";
    private static CommandFactory instance = null;
    private Map<String, ICommand> commands
            = new HashMap<String, ICommand>();

    private CommandFactory() {
        commands.put(CommandManager.getInstance().getProperty(CommandManager.SHOW_ALL), new CShowPost());
        commands.put(CommandManager.getInstance().getProperty(CommandManager.REMOVE_POST), new CRemovePost());
        commands.put(CommandManager.getInstance().getProperty(CommandManager.REDIRECT), new CRedirect());
        commands.put(CommandManager.getInstance().getProperty(CommandManager.ADD_POST), new CAddPost());
        commands.put(CommandManager.getInstance().getProperty(CommandManager.FIND_ID), new CFindId());
        commands.put(CommandManager.getInstance().getProperty(CommandManager.FIND_FROM), new CFindFrom());
    }

    public ICommand getCommand(HttpServletRequest request) {
        String action = request.getParameter(COMMAND_PARAMETER);
        ICommand command = commands.get(action);
        return command;
    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            instance = new CommandFactory();
        }
        return instance;
    }
}
