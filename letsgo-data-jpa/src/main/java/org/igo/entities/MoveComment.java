/*
 * Copyright (C) 2016 kostya surzhin
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.igo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author kostya surzhin
 */
@Entity
@Table(name = "moves_comments",
        uniqueConstraints = @UniqueConstraint(columnNames = {"move_game_id", "user_id", "move_ndx", "move_comment"})
)
public class MoveComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private GameMove move;

    private Long id;

    private String comment;

    private Date postTime;

    private User user;

    private List<MoveComment> comments;

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
    @Id
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    public GameMove getMove() {
        return move;
    }

    /**
     *
     * @param move
     */
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

    /**
     * @return the postTime
     */
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "post_date_time", nullable = false)
    public Date getPostTime() {
        return postTime;
    }

    /**
     * @param postTime the postTime to set
     */
    public void setPostTime(Date postTime) {
        this.postTime = postTime;
    }

}
