package com.jpql.hellojpql;

import jakarta.persistence.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class HellojpqlApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member1 = new Member();
			member1.setUsername("관리자");
			em.persist(member1);

			Member member2 = new Member();
			member2.setUsername("관리자");
			em.persist(member2);

			em.flush();
			em.clear();

			String query = "select locate('de', 'abcdef') From Member m";
			List<Integer> result = em.createQuery(query, Integer.class)
					.getResultList();

			for (Integer s : result) {
				System.out.println("s = " + s);
			}

			tx.commit(); //반영해줌

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			em.close();
		}

		emf.close();
	}

}
