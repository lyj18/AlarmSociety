/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author scartlett
 */
@Entity
@Table(name = "people")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "People.findAll", query = "SELECT p FROM People p")
    , @NamedQuery(name = "People.findByIdpeople", query = "SELECT p FROM People p WHERE p.idpeople = :idpeople")
    , @NamedQuery(name = "People.findByName", query = "SELECT p FROM People p WHERE p.name = :name")
    , @NamedQuery(name = "People.findByPassword", query = "SELECT p FROM People p WHERE p.password = :password")
    , @NamedQuery(name = "People.findById", query = "SELECT p FROM People p WHERE p.id = :id")
    , @NamedQuery(name = "People.findByTelephone", query = "SELECT p FROM People p WHERE p.telephone = :telephone")})
public class People implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpeople")
    private Integer idpeople;
    @Size(max = 45)
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @Size(max = 45)
    @Column(name = "ID")
    private String id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "telephone")
    private String telephone;
    @ManyToMany(mappedBy = "peopleCollection")
    private Collection<Case> caseCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpeople")
    private Collection<Chat> chatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpeople")
    private Collection<Comment> commentCollection;

    public People() {
    }

    public People(Integer idpeople) {
        this.idpeople = idpeople;
    }

    public People(Integer idpeople, String telephone) {
        this.idpeople = idpeople;
        this.telephone = telephone;
    }

    public Integer getIdpeople() {
        return idpeople;
    }

    public void setIdpeople(Integer idpeople) {
        this.idpeople = idpeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @XmlTransient
    public Collection<Case> getCaseCollection() {
        return caseCollection;
    }

    public void setCaseCollection(Collection<Case> caseCollection) {
        this.caseCollection = caseCollection;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    @XmlTransient
    public Collection<Comment> getCommentCollection() {
        return commentCollection;
    }

    public void setCommentCollection(Collection<Comment> commentCollection) {
        this.commentCollection = commentCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpeople != null ? idpeople.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof People)) {
            return false;
        }
        People other = (People) object;
        if ((this.idpeople == null && other.idpeople != null) || (this.idpeople != null && !this.idpeople.equals(other.idpeople))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.People[ idpeople=" + idpeople + " ]";
    }
    
}
