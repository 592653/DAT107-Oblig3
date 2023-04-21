package no.hvl.dat107.dao;
//Dette er en hjelpeklasse, DAO betyr Data Access Object
//Slik vi får tilgang til databasen

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import no.hvl.dat107.entity.Ansatt;

public class AnsattDAO {
	
	private EntityManagerFactory emf;
	
	
	public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3");
    }
	
	public Ansatt finnAnsattMedId(int ansattId) {
		EntityManager em = emf.createEntityManager();
		Ansatt ansatt = null;
        try {
        	ansatt = em.find(Ansatt.class, ansattId);
        	if(ansatt == null) {
				System.out.print("Finner ikkje ansatt med den id-en, prøv på nytt: ");
			}
        } finally {
            em.close();
        }
        return ansatt;
    }
	public Ansatt finnBrukernavn(String brukernavn) {
		Ansatt ansatt = null;
		EntityManager em = emf.createEntityManager();
		String query = "SELECT a FROM ansatt a " + "WHERE a.brukernavn = :brukernavn";
		
		try {
			TypedQuery<Ansatt> queryString = em.createQuery(query, Ansatt.class);
			queryString.setParameter("brukernavn", brukernavn);
			ansatt = queryString.getSingleResult();
			
			if(ansatt == null) {
				System.out.print("Finner ikkje brukernavnet, prøv igjen: ");
			}
		} finally {
			em.close();
		}
		return ansatt;
	}
    public List<Ansatt> hentAnsattliste() {
    	
		EntityManager em = emf.createEntityManager();
		List<Ansatt> ansattListe = null;
		
		try {
			String queryString = "SELECT a FROM ansatt a";
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			ansattListe = query.getResultList();
			for (Ansatt a : ansattListe) {
				System.out.println(a.toString());
		    }
	
		} finally {
			em.close();
		}
		return ansattListe;
    }
    
    public void leggTil(Ansatt leggTil) {
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

	public void oppdaterStilling (String stilling, int ansattId) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

        try {
           Ansatt ansatt = em.find(Ansatt.class, ansattId);
           tx.begin();
           if (ansatt != null) {
        	   ansatt.setStilling(stilling);
        	   em.merge(ansatt);
           }
        } catch (Throwable e) {
        	e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
        	em.close();
        }
	}
}
