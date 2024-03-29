package jpabasic.ex1hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDateTime;
import java.util.List;

public class Ex1HelloJpaApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			Member member = new Member();
			member.setUsername("user1");

			em.persist(member);

			em.flush();
			em.clear();

			tx.commit(); //반영해줌

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
