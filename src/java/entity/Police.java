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
@Table(name = "police")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Police.findAll", query = "SELECT p FROM Police p")
    , @NamedQuery(name = "Police.findByIdpolice", query = "SELECT p FROM Police p WHERE p.idpolice = :idpolice")
    , @NamedQuery(name = "Police.findByPassword", query = "SELECT p FROM Police p WHERE p.password = :password")})
public class Police implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpolice")
    private Integer idpolice;
    @Size(max = 45)
    @Column(name = "password")
    private String password;
    @OneToMany(mappedBy = "idpolice")
    private Collection<Chat> chatCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpolice")
    private Collection<Comment> commentCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpolice")
    private Collection<Case> caseCollection;

    public Police() {
    }

    public Police(Integer idpolice) {
        this.idpolice = idpolice;
    }

    public Integer getIdpolice() {
        return idpolice;
    }

    public void setIdpolice(Integer idpolice) {
        this.idpolice = idpolice;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    @XmlTransient
    public Collection<Case> getCaseCollection() {
        return caseCollection;
    }

    public void setCaseCollection(Collection<Case> caseCollection) {
        this.caseCollection = caseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpolice != null ? idpolice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Police)) {
            return false;
        }
        Police other = (Police) object;
        if ((this.idpolice == null && other.idpolice != null) || (this.idpolice != null && !this.idpolice.equals(other.idpolice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Police[ idpolice=" + idpolice + " ]";
    }
    
}
