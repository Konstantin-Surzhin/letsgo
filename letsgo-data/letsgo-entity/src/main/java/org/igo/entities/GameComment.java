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
import javax.validation.constraints.Size;

/**
 *
 * @author surzhin.konstantin
 */
@Entity
@Table(name = "GAME_COMMENTS", uniqueConstraints = {
    @UniqueConstraint(name = "uk_game_userDetail_comment", columnNames = {"game_id", "user_details_id", "comment"})})
@NamedQueries({
    @NamedQuery(name = "GameComment.findAll", query = "SELECT g FROM GameComment g")
    ,@NamedQuery(name = "GameComment.findById", query = "SELECT g FROM GameComment g WHERE g.id = :id")
    ,@NamedQuery(name = "GameComment.findByComment", query = "SELECT g FROM GameComment g WHERE g.comment = :comment")
    ,@NamedQuery(name = "GameComment.findByPostDateTime", query = "SELECT g FROM GameComment g WHERE g.postDateTime = :postDateTime")})
public class GameComment implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String comment;
    private Date postDateTime = Calendar.getInstance().getTime();
    private Game game;
    private Collection<GameComment> gameCommentCollection;
    private GameComment inReplayToId;
    private UserDetails userDetails;

    /**
     *
     */
    public GameComment() {
    }

    /**
     *
     * @param id
     */
    public GameComment(long id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param comment
     * @param postDateTime
     */
    public GameComment(long id, String comment, Date postDateTime) {
        this.id = id;
        this.comment = comment;
        this.postDateTime = new Date(postDateTime.getTime());
    }

    /**
     *
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Basic(optional = false)
    @Column(nullable = false, length = 255)
    @Size(min = 1, max = 255)
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
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
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_gameComment_game"), name = "game_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    public Game getGame() {
        return game;
    }

    /**
     *
     * @param game
     */
    public void setGame(Game game) {
        this.game = game;
    }

    /**
     *
     * @return
     */
    @OneToMany(mappedBy = "inReplayToId")
    public Collection<GameComment> getGameCommentCollection() {
        return gameCommentCollection;
    }

    /**
     *
     * @param gameCommentCollection
     */
    public void setGameCommentCollection(Collection<GameComment> gameCommentCollection) {
        this.gameCommentCollection = gameCommentCollection;
    }

    /**
     *
     * @return
     */
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_gameComment_in_replay_to_id"), name = "in_replay_to_id", referencedColumnName = "id")
    @ManyToOne
    public GameComment getInReplayToId() {
        return inReplayToId;
    }

    /**
     *
     * @param inReplayToId
     */
    public void setInReplayToId(GameComment inReplayToId) {
        this.inReplayToId = inReplayToId;
    }

    /**
     *
     * @return
     */
    @ManyToOne(optional = false)
    @JoinColumn(foreignKey = @ForeignKey(name = "fk_gameComment_userDetails"), name = "user_details_id", referencedColumnName = "id", nullable = false)
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
        int hash = 3;
        hash = 97 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 97 * hash + Objects.hashCode(this.comment);
        hash = 97 * hash + Objects.hashCode(this.postDateTime);
        hash = 97 * hash + Objects.hashCode(this.game);
        hash = 97 * hash + Objects.hashCode(this.gameCommentCollection);
        hash = 97 * hash + Objects.hashCode(this.inReplayToId);
        hash = 97 * hash + Objects.hashCode(this.userDetails);
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
        final GameComment other = (GameComment) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "org.igo.entities.GamesComments[ id=" + id + " ]";
    }

}
