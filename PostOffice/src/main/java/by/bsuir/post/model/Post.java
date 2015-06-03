/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author notepad
 */
@Entity
@Table(name = "Post")
@NamedQueries({
    @NamedQuery(name = "Post.findAll", query = "SELECT p FROM Post p")})
public class Post implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "idFrom", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private FromWho idFrom;
    @JoinColumn(name = "idTo", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private ToWho idTo;
    @JoinColumn(name = "idCountry", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Country idCountry;

    public Post() {
    }

    public Post(Integer id) {
        this.id = id;
    }

    public Post(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Post(String name, FromWho idFrom, ToWho idTo, Country idCountry) {
        this.name = name;
        this.idFrom = idFrom;
        this.idTo = idTo;
        this.idCountry = idCountry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FromWho getIdFrom() {
        return idFrom;
    }

    public void setIdFrom(FromWho idFrom) {
        this.idFrom = idFrom;
    }

    public ToWho getIdTo() {
        return idTo;
    }

    public void setIdTo(ToWho idTo) {
        this.idTo = idTo;
    }

    public Country getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(Country idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Post)) {
            return false;
        }
        Post other = (Post) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.idCountry.getCountryName();
    }

}
