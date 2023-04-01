package no.hvl.dat107;
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

public class AnsattDAO {
	
	private EntityManagerFactory emf;
	
	
	public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3");
    }
	
	public Ansatt finnAnsattMedId(int id) {
        EntityManager em = emf.createEntityManager();
        Ansatt ansatt = null;
        
        try {
        	ansatt = em.find(Ansatt.class, id);
        	
        } finally {
            em.close();
        }
        return ansatt;
    }
	public Ansatt finnBrukernavn(String brukernavn) {
		Ansatt ansatt = null;
		EntityManager em = emf.createEntityManager();
		String query = "SELECT a FROM Ansatt a " + "WHERE a.brukernavn = :brukernavn";
		
		try {
			TypedQuery<Ansatt> queryString = em.createQuery(query, Ansatt.class);
			queryString.setParameter("brukernavn", brukernavn);
			ansatt = queryString.getSingleResult();
		} finally {
			em.close();
		}
		return ansatt;
	}
    public List<Ansatt> hentAnsattliste() {
    	String queryString = "SELECT a FROM Ansatt a";
		EntityManager em = emf.createEntityManager();
		List<Ansatt> list = null;
		
		try {
			TypedQuery<Ansatt> query = em.createQuery(queryString, Ansatt.class);
			list = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			em.close();
		}

		return list;
   
    }
    public void OppdaterAnsatt(String fornavn, String etternavn, String brukernavn, LocalDate ansDato, String stilling, int mndlonn) {
    	EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();

        try {
           Ansatt ansatt = em.find(Ansatt.class, ansattid);
           tx.begin();
           if (ansatt != null) {
        	   ansatt.setStilling(stilling);
        	   ansatt.setAnsattid(ansattid);
        	   ansatt.setAnsDato(ansDato);
        	   ansatt.setBrukernavn(brukernavn);
        	   ansatt.setEtternavn(etternavn);
        	   ansatt.setFornavn(fornavn);
        	   ansatt.setAnsDato(ansDato);
        	   ansatt.setMndlønn(mndlonn);
        	   ansatt.setStilling(stilling);
        	   em.merge(ansatt);
           }
        } finally {
        	em.close();
        }
        
    }
}
