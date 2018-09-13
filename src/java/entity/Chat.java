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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
@Table(name = "chat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chat.findAll", query = "SELECT c FROM Chat c")
    , @NamedQuery(name = "Chat.findByIdchat", query = "SELECT c FROM Chat c WHERE c.chatPK.idchat = :idchat")
    , @NamedQuery(name = "Chat.findByGroupID", query = "SELECT c FROM Chat c WHERE c.chatPK.groupID = :groupID")
    , @NamedQuery(name = "Chat.findByContext", query = "SELECT c FROM Chat c WHERE c.context = :context")
    , @NamedQuery(name = "Chat.findByTime", query = "SELECT c FROM Chat c WHERE c.time = :time")})
public class Chat implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ChatPK chatPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "context")
    private String context;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time")
    @Temporal(TemporalType.DATE)
    private Date time;
    @JoinColumn(name = "idpolice__", referencedColumnName = "idpolice")
    @ManyToOne
    private Police idpolice;
    @JoinColumn(name = "groupID", referencedColumnName = "groupID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Group1 group1;
    @JoinColumn(name = "idpeople__", referencedColumnName = "idpeople")
    @ManyToOne(optional = false)
    private People idpeople;

    public Chat() {
    }

    public Chat(ChatPK chatPK) {
        this.chatPK = chatPK;
    }

    public Chat(ChatPK chatPK, String context, Date time) {
        this.chatPK = chatPK;
        this.context = context;
        this.time = time;
    }

    public Chat(int idchat, int groupID) {
        this.chatPK = new ChatPK(idchat, groupID);
    }

    public ChatPK getChatPK() {
        return chatPK;
    }

    public void setChatPK(ChatPK chatPK) {
        this.chatPK = chatPK;
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

    public Group1 getGroup1() {
        return group1;
    }

    public void setGroup1(Group1 group1) {
        this.group1 = group1;
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
        hash += (chatPK != null ? chatPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chat)) {
            return false;
        }
        Chat other = (Chat) object;
        if ((this.chatPK == null && other.chatPK != null) || (this.chatPK != null && !this.chatPK.equals(other.chatPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Chat[ chatPK=" + chatPK + " ]";
    }
    
}
