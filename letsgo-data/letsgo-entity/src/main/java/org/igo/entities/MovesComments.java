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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "moves_comments", catalog = "letsgo", schema = "", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"move_game_id", "user_id", "move_ndx", "move_comment"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MovesComments.findAll", query = "SELECT m FROM MovesComments m"),
    @NamedQuery(name = "MovesComments.findById", query = "SELECT m FROM MovesComments m WHERE m.id = :id"),
    @NamedQuery(name = "MovesComments.findByMoveComment", query = "SELECT m FROM MovesComments m WHERE m.moveComment = :moveComment"),
    @NamedQuery(name = "MovesComments.findByPostDateTime", query = "SELECT m FROM MovesComments m WHERE m.postDateTime = :postDateTime")})
public class MovesComments implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(nullable = false)
    private Long id;
    @Size(max = 255)
    @Column(name = "move_comment", length = 255)
    private String moveComment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "post_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date postDateTime;
    @JoinColumns({
        @JoinColumn(name = "move_game_id", referencedColumnName = "game_id"),
        @JoinColumn(name = "move_ndx", referencedColumnName = "ndx")})
    @ManyToOne
    private GamesMoves gamesMoves;
    @OneToMany(mappedBy = "inReplayToId")
    private Collection<MovesComments> movesCommentsCollection;
    @JoinColumn(name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    private MovesComments inReplayToId;
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @ManyToOne
    private Users userId;

    public MovesComments() {
    }

    public MovesComments(Long id) {
        this.id = id;
    }

    public MovesComments(Long id, Date postDateTime) {
        this.id = id;
        this.postDateTime = postDateTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMoveComment() {
        return moveComment;
    }

    public void setMoveComment(String moveComment) {
        this.moveComment = moveComment;
    }

    public Date getPostDateTime() {
        return postDateTime;
    }

    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = postDateTime;
    }

    public GamesMoves getGamesMoves() {
        return gamesMoves;
    }

    public void setGamesMoves(GamesMoves gamesMoves) {
        this.gamesMoves = gamesMoves;
    }

    @XmlTransient
    public Collection<MovesComments> getMovesCommentsCollection() {
        return movesCommentsCollection;
    }

    public void setMovesCommentsCollection(Collection<MovesComments> movesCommentsCollection) {
        this.movesCommentsCollection = movesCommentsCollection;
    }

    public MovesComments getInReplayToId() {
        return inReplayToId;
    }

    public void setInReplayToId(MovesComments inReplayToId) {
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
        if (!(object instanceof MovesComments)) {
            return false;
        }
        MovesComments other = (MovesComments) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "org.igo.entities.MovesComments[ id=" + id + " ]";
    }
    
}
