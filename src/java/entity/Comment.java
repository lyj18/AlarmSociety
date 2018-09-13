/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author scartlett
 */
@Entity
@Table(name = "comment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Comment.findAll", query = "SELECT c FROM Comment c")
    , @NamedQuery(name = "Comment.findByIdcomment", query = "SELECT c FROM Comment c WHERE c.idcomment = :idcomment")
    , @NamedQuery(name = "Comment.findByContext", query = "SELECT c FROM Comment c WHERE c.context = :context")
    , @NamedQuery(name = "Comment.findByTime", query = "SELECT c FROM Comment c WHERE c.time = :time")})
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idcomment")
    private Integer idcomment;
    @Size(max = 45)
    @Column(name = "context")
    private String context;
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "idpolice_", referencedColumnName = "idpolice")
    @ManyToOne(optional = false)
    private Police idpolice;
    @JoinColumn(name = "idpeople_", referencedColumnName = "idpeople")
    @ManyToOne(optional = false)
    private People idpeople;

    public Comment() {
    }

    public Comment(Integer idcomment) {
        this.idcomment = idcomment;
    }

    public Integer getIdcomment() {
        return idcomment;
    }

    public void setIdcomment(Integer idcomment) {
        this.idcomment = idcomment;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Police getIdpolice() {
        return idpolice;
    }

    public void setIdpolice(Police idpolice) {
        this.idpolice = idpolice;
    }

    public People getIdpeople() {
        return idpeople;
    }

    public void setIdpeople(People idpeople) {
        this.idpeople = idpeople;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcomment != null ? idcomment.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Comment)) {
            return false;
        }
        Comment other = (Comment) object;
        if ((this.idcomment == null && other.idcomment != null) || (this.idcomment != null && !this.idcomment.equals(other.idcomment))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Comment[ idcomment=" + idcomment + " ]";
    }
    
}
