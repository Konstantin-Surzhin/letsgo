/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pl
 */
@Entity
@Table(name = "game_comments")
public class GameComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private Game game;
    private Long id;
    private User user;
    private String comment;
    private List<GameComment> comments;

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return "jpa.GameComments[ id=" + id + " ]";
    }

    /**
     * @return the comment
     */
    @Column(name = "comment")
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the comments
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "in_replay_to_id")
    public List<GameComment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<GameComment> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne
    @JoinColumn(name = "game_id")
    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }
}
