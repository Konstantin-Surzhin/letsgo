/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "games_comments", catalog = "letsgo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"game_id", "user_id", "comment"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GamesComments.findAll", query = "SELECT g FROM GamesComments g"),
    @NamedQuery(name = "GamesComments.findById", query = "SELECT g FROM GamesComments g WHERE g.id = :id"),
    @NamedQuery(name = "GamesComments.findByComment", query = "SELECT g FROM GamesComments g WHERE g.comment = :comment"),
    @NamedQuery(name = "GamesComments.findByPostDateTime", query = "SELECT g FROM GamesComments g WHERE g.postDateTime = :postDateTime")})
public class GamesComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(nullable = false, length = 255)
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDateTime;
    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Games gameId;
    @OneToMany(mappedBy = "inReplayToId")
    private Collection<GamesComments> gamesCommentsCollection;
    @JoinColumn(name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    private GamesComments inReplayToId;
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Users userId;

    public GamesComments() {
    }

    public GamesComments(Long id) {
        this.id = id;
    }

    public GamesComments(Long id, String comment, Date postDateTime) {
        this.id = id;
        this.comment = comment;
        this.postDateTime = postDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }

    public Games getGameId() {
        return gameId;
    }

    public void setGameId(Games gameId) {
        this.gameId = gameId;
    }

    @XmlTransient
    public Collection<GamesComments> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GamesComments> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    public GamesComments getInReplayToId() {
        return inReplayToId;
    }

    public void setInReplayToId(GamesComments inReplayToId) {
        this.inReplayToId = inReplayToId;
    }

    public Users getUserId() {
        return userId;
    }

    public void setUserId(Users userId) {
        this.userId = userId;
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
        if (!(object instanceof GamesComments)) {
            return false;
        }
        GamesComments other = (GamesComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesComments[ id=" + id + " ]";
    }
    
}
