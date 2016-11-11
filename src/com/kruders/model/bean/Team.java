package com.kruders.model.bean;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "team")
@AssociationOverrides({
		@AssociationOverride(name = "pk.club", joinColumns = @JoinColumn(name = "CLUBID")) })
public class Team {
	
	private TeamId pk = new TeamId();
	private Integer teamid;
	private String teamname;
	
	@EmbeddedId
	public TeamId getPk() {
		return pk;
	}

	public void setPk(TeamId pk) {
		this.pk = pk;
	}
	
	@Transient
	public Club getClub() {
		return getPk().getClub();
	}

	public void setClub(Club club) {
		getPk().setClub(club);
	}

	@Column(name = "teamid")
	public Integer getTeamid() {
		return teamid;
	}

	public void setTeamid(Integer teamid) {
		this.teamid = teamid;
	}

	@Column(name = "teamname")
	public String getTeamname() {
		return teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}
	
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Team team = (Team) o;

		if (getPk() != null ? !getPk().equals(team.getPk())
				: team.getPk() != null)
			return false;

		return true;
	}

	public int hashCode() {
		return (getPk() != null ? getPk().hashCode() : 0);
	}
}
