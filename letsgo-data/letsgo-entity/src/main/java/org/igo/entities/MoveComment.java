/*
 * Copyright (C) 2016 Surzhin.Konstantin
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
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
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
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "MOVE_COMMENTS", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"move_game_id", "user_details_id", "move_ndx", "move_comment"})})
@NamedQueries({
    @NamedQuery(name = "MoveComment.findAll", query = "SELECT m FROM MoveComment m")
    ,@NamedQuery(name = "MoveComment.findById", query = "SELECT m FROM MoveComment m WHERE m.id = :id")
    ,@NamedQuery(name = "MoveComment.findByMoveComment", query = "SELECT m FROM MoveComment m WHERE m.moveComment = :moveComment")
    ,@NamedQuery(name = "MoveComment.findByPostDateTime", query = "SELECT m FROM MoveComment m WHERE m.postDateTime = :postDateTime")})
public class MoveComment implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String moveComment;
    private Date postDateTime = Calendar.getInstance().getTime();
    private GameMove gamesMoves;
    private Collection<MoveComment> moveCommentCollection;
    private MoveComment inReplayToId;
    private UserDetails userDetails;

    /**
     *
     */
    public MoveComment() {
    }

    /**
     *
     * @param id
     */
    public MoveComment(long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param postDateTime
     */
    public MoveComment(long id, Date postDateTime) {
        this.id = id;
        this.postDateTime = new Date(postDateTime.getTime());
    }

    /**
     *
     * @return
     */
    @Id
    @Basic(optional = false)
    @Column(nullable = false)
    public long getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(long id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Column(name = "move_comment", length = 255)
    @Size(min = 1, max = 255)
    public String getMoveComment() {
        return moveComment;
    }

    /**
     *
     * @param moveComment
     */
    public void setMoveComment(String moveComment) {
        this.moveComment = moveComment;
    }

    /**
     *
     * @return
     */
    @Basic(optional = false)
    @Column(name = "post_date_time", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getPostDateTime() {
        return new Date(postDateTime.getTime());
    }

    /**
     *
     * @param postDateTime
     */
    public void setPostDateTime(Date postDateTime) {
        this.postDateTime = new Date(postDateTime.getTime());
    }

    /**
     *
     * @return
     */
    @JoinColumns({
        @JoinColumn(name = "move_game_id", referencedColumnName = "game_id")
        ,
        @JoinColumn(name = "move_ndx", referencedColumnName = "ndx")})
    @ManyToOne
    public GameMove getGamesMoves() {
        return gamesMoves;
    }

    /**
     *
     * @param gamesMoves
     */
    public void setGamesMoves(GameMove gamesMoves) {
        this.gamesMoves = gamesMoves;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "inReplayToId")
    public Collection<MoveComment> getMoveCommentCollection() {
        return moveCommentCollection;
    }

    /**
     *
     * @param moveCommentCollection
     */
    public void setMoveCommentCollection(Collection<MoveComment> moveCommentCollection) {
        this.moveCommentCollection = moveCommentCollection;
    }

    /**
     *
     * @return
     */
    @JoinColumn(name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    public MoveComment getInReplayToId() {
        return inReplayToId;
    }

    /**
     *
     * @param inReplayToId
     */
    public void setInReplayToId(MoveComment inReplayToId) {
        this.inReplayToId = inReplayToId;
    }

    /**
     *
     * @return
     */
    @ManyToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_moveComment_userDetails"), name = "user_details_id", referencedColumnName = "id")
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     *
     * @param userDetails
     */
    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.moveComment);
        hash = 53 * hash + Objects.hashCode(this.postDateTime);
        hash = 53 * hash + Objects.hashCode(this.gamesMoves);
        hash = 53 * hash + Objects.hashCode(this.moveCommentCollection);
        hash = 53 * hash + Objects.hashCode(this.inReplayToId);
        hash = 53 * hash + Objects.hashCode(this.userDetails);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final MoveComment other = (MoveComment) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.MovesComments[ id=" + id + " ]";
    }

}
