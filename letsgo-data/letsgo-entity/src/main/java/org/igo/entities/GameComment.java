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
    @NamedQuery(name = "GameComment.findAll", query = "SELECT g FROM GameComment g"),
    @NamedQuery(name = "GameComment.findById", query = "SELECT g FROM GameComment g WHERE g.id = :id"),
    @NamedQuery(name = "GameComment.findByComment", query = "SELECT g FROM GameComment g WHERE g.comment = :comment"),
    @NamedQuery(name = "GameComment.findByPostDateTime", query = "SELECT g FROM GameComment g WHERE g.postDateTime = :postDateTime")})
public class GameComment implements Serializable {

    private static final long serialVersionUID = 1L;
    private Long id;
    private String comment;
    private Date postDateTime;
    private Game gameId;
    private Collection<GameComment> gamesCommentsCollection;
    private GameComment inReplayToId;
    private Users userId;

    public GameComment() {
    }

    public GameComment(Long id) {
        this.id = id;
    }

    public GameComment(Long id, String comment, Date postDateTime) {
        this.id = id;
        this.comment = comment;
        this.postDateTime = postDateTime;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 255)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic(optional = false)
    @Column(name = "post_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }

    @JoinColumn(name = "game_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    public Game getGameId() {
        return gameId;
    }

    public void setGameId(Game gameId) {
        this.gameId = gameId;
    }

    @OneToMany(mappedBy = "inReplayToId")
    @XmlTransient
    public Collection<GameComment> getGamesCommentsCollection() {
        return gamesCommentsCollection;
    }

    public void setGamesCommentsCollection(Collection<GameComment> gamesCommentsCollection) {
        this.gamesCommentsCollection = gamesCommentsCollection;
    }

    @JoinColumn(name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    public GameComment getInReplayToId() {
        return inReplayToId;
    }

    public void setInReplayToId(GameComment inReplayToId) {
        this.inReplayToId = inReplayToId;
    }

    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
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
        if (!(object instanceof GameComment)) {
            return false;
        }
        GameComment other = (GameComment) object;
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
