package com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.model.Actor;
import com.model.Movie;

public class TestController {

public static void main(String[] args) {
		
		EntityManagerFactory emf=Persistence.createEntityManagerFactory("EP");

		EntityManager em=emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		Actor a1=new Actor();
		
		Movie m1=new Movie(103,"Singham1");
		m1.setActor(a1);//use when show the relation from movie
		Movie m2=new Movie(104,"Drishyam1");
		m2.setActor(a1);
		
		
		
		List<Movie> movieList=new ArrayList<Movie>();
		movieList.add(m1);
		movieList.add(m2);
		
		a1.setId(2);
		a1.setName("Vijay");
		a1.setMovies(movieList);
		
		//em.persist(m1);
		//em.persist(m2);
		em.persist(a1);
		
		
		em.getTransaction().commit();
		
		
}
}
