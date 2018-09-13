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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author scartlett
 */
@Entity
@Table(name = "group_")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Group1.findAll", query = "SELECT g FROM Group1 g")
    , @NamedQuery(name = "Group1.findByGroupID", query = "SELECT g FROM Group1 g WHERE g.groupID = :groupID")
    , @NamedQuery(name = "Group1.findByIdpeople", query = "SELECT g FROM Group1 g WHERE g.idpeople = :idpeople")
    , @NamedQuery(name = "Group1.findByIdpolice", query = "SELECT g FROM Group1 g WHERE g.idpolice = :idpolice")
    , @NamedQuery(name = "Group1.findByChatNum", query = "SELECT g FROM Group1 g WHERE g.chatNum = :chatNum")})
public class Group1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupID")
    private Integer groupID;
    @Column(name = "idpeople")
    private Integer idpeople;
    @Column(name = "idpolice")
    private Integer idpolice;
    @Column(name = "chatNum")
    private Integer chatNum;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "group1")
    private Collection<Chat> chatCollection;
    @JoinColumn(name = "caseID", referencedColumnName = "caseID")
    @ManyToOne(optional = false)
    private Case caseID;

    public Group1() {
    }

    public Group1(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getGroupID() {
        return groupID;
    }

    public void setGroupID(Integer groupID) {
        this.groupID = groupID;
    }

    public Integer getIdpeople() {
        return idpeople;
    }

    public void setIdpeople(Integer idpeople) {
        this.idpeople = idpeople;
    }

    public Integer getIdpolice() {
        return idpolice;
    }

    public void setIdpolice(Integer idpolice) {
        this.idpolice = idpolice;
    }

    public Integer getChatNum() {
        return chatNum;
    }

    public void setChatNum(Integer chatNum) {
        this.chatNum = chatNum;
    }

    @XmlTransient
    public Collection<Chat> getChatCollection() {
        return chatCollection;
    }

    public void setChatCollection(Collection<Chat> chatCollection) {
        this.chatCollection = chatCollection;
    }

    public Case getCaseID() {
        return caseID;
    }

    public void setCaseID(Case caseID) {
        this.caseID = caseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (groupID != null ? groupID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Group1)) {
            return false;
        }
        Group1 other = (Group1) object;
        if ((this.groupID == null && other.groupID != null) || (this.groupID != null && !this.groupID.equals(other.groupID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Group1[ groupID=" + groupID + " ]";
    }
    
}
