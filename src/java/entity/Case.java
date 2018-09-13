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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "case_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Case.findAll", query = "SELECT c FROM Case c")
    , @NamedQuery(name = "Case.findByCaseID", query = "SELECT c FROM Case c WHERE c.caseID = :caseID")
    , @NamedQuery(name = "Case.findByContent", query = "SELECT c FROM Case c WHERE c.content = :content")
    , @NamedQuery(name = "Case.findByIdpeople", query = "SELECT c FROM Case c WHERE c.idpeople = :idpeople")
    , @NamedQuery(name = "Case.findByComment", query = "SELECT c FROM Case c WHERE c.comment = :comment")})
public class Case implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "caseID")
    private Integer caseID;
    @Size(max = 45)
    @Column(name = "content")
    private String content;
    @Basic(optional = false)
    @NotNull
    @Column(name = "idpeople")
    private int idpeople;
    @Size(max = 45)
    @Column(name = "comment")
    private String comment;
    @JoinTable(name = "people_has_case", joinColumns = {
        @JoinColumn(name = "case_caseID", referencedColumnName = "caseID")}, inverseJoinColumns = {
        @JoinColumn(name = "people_idpeople", referencedColumnName = "idpeople")})
    @ManyToMany
    private Collection<People> peopleCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "caseID")
    private Collection<Group1> group1Collection;
    @JoinColumn(name = "idpolice", referencedColumnName = "idpolice")
    @ManyToOne(optional = false)
    private Police idpolice;

    public Case() {
    }

    public Case(Integer caseID) {
        this.caseID = caseID;
    }

    public Case(Integer caseID, int idpeople) {
        this.caseID = caseID;
        this.idpeople = idpeople;
    }

    public Integer getCaseID() {
        return caseID;
    }

    public void setCaseID(Integer caseID) {
        this.caseID = caseID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getIdpeople() {
        return idpeople;
    }

    public void setIdpeople(int idpeople) {
        this.idpeople = idpeople;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @XmlTransient
    public Collection<People> getPeopleCollection() {
        return peopleCollection;
    }

    public void setPeopleCollection(Collection<People> peopleCollection) {
        this.peopleCollection = peopleCollection;
    }

    @XmlTransient
    public Collection<Group1> getGroup1Collection() {
        return group1Collection;
    }

    public void setGroup1Collection(Collection<Group1> group1Collection) {
        this.group1Collection = group1Collection;
    }

    public Police getIdpolice() {
        return idpolice;
    }

    public void setIdpolice(Police idpolice) {
        this.idpolice = idpolice;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (caseID != null ? caseID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Case)) {
            return false;
        }
        Case other = (Case) object;
        if ((this.caseID == null && other.caseID != null) || (this.caseID != null && !this.caseID.equals(other.caseID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Case[ caseID=" + caseID + " ]";
    }
    
}
