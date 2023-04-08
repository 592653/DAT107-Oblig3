package no.hvl.dat107.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import no.hvl.dat107.entity.Prosjekt;
import jakarta.persistence.EntityManager;

public class ProsjektDAO {
	private EntityManagerFactory emf;
	
	public void leggTil(Prosjekt leggTil) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
            tx.begin();
            em.persist(leggTil);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        
        }

}
	public Prosjekt finnProsjekt(int id) {
		EntityManager em = emf.createEntityManager();
		Prosjekt prosjekt = null;
		
		try {
			prosjekt = em.find(Prosjekt.class, id);
		} finally {
			em.close();
		}
		return prosjekt;
	}
	
}

	
