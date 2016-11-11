package com.kruders.core;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.kruders.model.bean.Club;
import com.kruders.model.bean.Team;
import com.kruders.util.HibernateUtil;
public class Main {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Object object;
		try {
			
			/*Criteria criteria = session.createCriteria(Club.class);
			criteria.setFetchMode("Team", FetchMode.JOIN);
			List list = criteria.list();*/
			
			
            Criteria criteria = session.createCriteria(Club.class,"club")
			.createAlias("club.team","team")
			.add(Restrictions.eq("club.name", "Arsenal"))
			.add(Restrictions.eq("team.teamname", "Team A"));
			List list = criteria.list();

            Iterator itr = list.iterator();
            System.out.println("\n");
            if (list.size() == 0) {
                    System.out.println("No Result Found !");
            } 
            while (itr.hasNext()) {
                    object = (Object) itr.next();
                    System.out.println("Club Name : "
                                    + ((Club) object).getName());
                    for(Team team: ((Club) object).getTeam()) {
                    	System.out.println("Team Name : " + team.getTeamname());
                    }
            }
    } catch (HibernateException e) {

            e.printStackTrace();
    } finally {
            session.close();
    }
	}
}
