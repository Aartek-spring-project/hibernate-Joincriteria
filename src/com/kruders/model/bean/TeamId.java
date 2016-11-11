package com.kruders.model.bean;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class TeamId implements Serializable{
	private Club club;

	@ManyToOne
	public Club getClub() {
		return club;
	}

	public void setClub(Club club) {
		this.club = club;
	}
	
	public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TeamId teamId = (TeamId) o;

        if (club != null ? !club.equals(teamId.club) : teamId.club != null) return false;
        
        return true;
    }

    public int hashCode() {
        int result;
        result = (club != null ? club.hashCode() : 0);
        result = 23 * result;
        return result;
    }
	
}
