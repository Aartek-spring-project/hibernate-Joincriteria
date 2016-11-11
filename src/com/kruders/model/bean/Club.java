package com.kruders.model.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "Club")
public class Club {
	
    private int clubid;
	private String name;
	private Set<Team> team = new HashSet<Team>(0);
	
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "clubid")
	public int getClubid() {
		return clubid;
	}

	public void setClubid(int clubid) {
		this.clubid = clubid;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.club", cascade=CascadeType.ALL)
	public Set<Team> getTeam() {
		return team;
	}

	public void setTeam(Set<Team> team) {
		this.team = team;
	}
}
