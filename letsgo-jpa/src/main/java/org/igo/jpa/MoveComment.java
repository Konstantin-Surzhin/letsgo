/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.igo.jpa;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "move_comments")
public class MoveComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private GameMove move;

    private Long id;

    private String comment;

    private User user;

    private List<MoveComment> comments;

    @Column(name = "move_comment")
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne
    public GameMove getMove() {
        return move;
    }

    public void setMove(GameMove move) {
        this.move = move;
    }

    /**
     * @return the comments
     */
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "in_replay_to_id")
    public List<MoveComment> getComments() {
        return comments;
    }

    /**
     * @param comments the comments to set
     */
    public void setComments(List<MoveComment> comments) {
        this.comments = comments;
    }

    /**
     * @return the user
     */
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

}
