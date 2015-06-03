/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.model;

import java.util.List;

/**
 *
 * @author notepad
 */
public abstract class AbstractDao<T> {

    public abstract boolean creat(T entity);

    public abstract List<T> read();

    public abstract boolean update(T entity);

    public abstract boolean delete(T entity);

    public abstract boolean delete(int id);
}
