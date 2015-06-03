/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package by.bsuir.post.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author notepad
 */
@Entity
@Table(name = "Country")
@NamedQueries({
    @NamedQuery(name = "Country.findAll", query = "SELECT c FROM Country c")})
public class Country implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "countryName")
    private String countryName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sngParam")
    private boolean sngParam;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCountry")
    private List<Post> postList;
    @JoinColumn(name = "idAdress", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Adress idAdress;

    public Country() {
    }

    public Country(Integer id) {
        this.id = id;
    }

    public Country(String countryName, boolean sngParam, Adress adress) {
        this.countryName = countryName;
        this.sngParam = sngParam;
        this.idAdress = adress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public boolean getSngParam() {
        return sngParam;
    }

    public void setSngParam(boolean sngParam) {
        this.sngParam = sngParam;
    }

    public List<Post> getPostList() {
        return postList;
    }

    public void setPostList(List<Post> postList) {
        this.postList = postList;
    }

    public Adress getIdAdress() {
        return idAdress;
    }

    public void setIdAdress(Adress idAdress) {
        this.idAdress = idAdress;
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
        if (!(object instanceof Country)) {
            return false;
        }
        Country other = (Country) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "by.bsuir.post.entity.Country[ id=" + id + " ]";
    }

}
