package no.hvl.dat107.dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class AvdelingDAO {
	
	private EntityManagerFactory emf;
	
	//Konstruktør
	public AvdelingDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3");
    }

	public Avdeling finnAvdelingMedId(int avdelingId) {
		EntityManager em = emf.createEntityManager();
        Avdeling avdeling = null;
        
        try {
        	avdeling = em.find(Avdeling.class, avdelingId);
        	
        } finally {
            em.close();
        }
        return avdeling;
	}
	
	public void leggTil(Avdeling avdeling, Ansatt sjef) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		try {
            tx.begin();
            em.persist(avdeling);
//            sjef.setAvdeling(avdeling);
//            em.merge(sjef);
            tx.commit();
        
        } catch (Throwable e) {
            e.printStackTrace();
            tx.rollback();
        } finally {
            em.close();
        }
	}	
	public List<Ansatt> skrivUtAllePaAvd(int id) {
	    EntityManager em = emf.createEntityManager();
		Avdeling avdeling = em.find(Avdeling.class, id);
		String query = "SELECT a FROM Ansatt a WHERE a.avdeling = :avdeling";
		List<Ansatt> ansatte = null;
			
		try {
			TypedQuery<Ansatt> queryString = em.createQuery(query, Ansatt.class);
			queryString.setParameter("avdeling", avdeling);
			avdeling = (Avdeling) queryString.getResultList();
				
				for (Ansatt a : ansatte) {
					if (a == avdeling.getSjef()) {
						System.out.println("Sjefen er: " + a.toString());
					} else {
						System.out.println(a.toString());
					}
				}
				
			} finally {
				em.close();
			}
		return ansatte;
	}
}
