/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author scartlett
 */
@Embeddable
public class ChatPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "idchat")
    private int idchat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "groupID")
    private int groupID;

    public ChatPK() {
    }

    public ChatPK(int idchat, int groupID) {
        this.idchat = idchat;
        this.groupID = groupID;
    }

    public int getIdchat() {
        return idchat;
    }

    public void setIdchat(int idchat) {
        this.idchat = idchat;
    }

    public int getGroupID() {
        return groupID;
    }

    public void setGroupID(int groupID) {
        this.groupID = groupID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idchat;
        hash += (int) groupID;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ChatPK)) {
            return false;
        }
        ChatPK other = (ChatPK) object;
        if (this.idchat != other.idchat) {
            return false;
        }
        if (this.groupID != other.groupID) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.ChatPK[ idchat=" + idchat + ", groupID=" + groupID + " ]";
    }
    
}
