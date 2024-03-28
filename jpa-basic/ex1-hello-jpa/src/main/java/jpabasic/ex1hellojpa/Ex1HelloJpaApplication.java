package jpabasic.ex1hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Ex1HelloJpaApplication {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

		EntityManager em = emf.createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();

		try {
			//저장
			Team team = new Team();
			team.setName("TeamA");
//			team.getMembers().add(member);
			em.persist(team);

			Member member = new Member();
			member.setUsername("member1");
			em.persist(member);

			team.addMember(member);

			em.flush();
			em.clear();

			Team findTeam = em.find(Team.class, team.getId());
			List<Member> members = findTeam.getMembers();

			for (Member m : members) {
				System.out.println("m.getUsername() = " + m.getUsername());
			}

			tx.commit(); //반영해줌

		} catch (Exception e) {
			tx.rollback();
		} finally {
			em.close();
		}

		emf.close();
	}
}
