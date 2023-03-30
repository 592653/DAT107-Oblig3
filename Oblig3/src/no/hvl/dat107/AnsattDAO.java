package no.hvl.dat107;
//Dette er en hjelpeklasse, DAO betyr Data Access Object
//Slik vi får tilgang til databasen

import java.util.Map;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class AnsattDAO {
	
	private EntityManagerFactory emf;
	
	public AnsattDAO() {
        emf = Persistence.createEntityManagerFactory("oblig3", BrukernavnPassord.getServerConfig());
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
//    public List<Ansatt> hentAnsattliste(int id) {
//        
//        EntityManager em = emf.createEntityManager();
//        
//        try {
//        	
//        	String jpqlQuery = """
//        			SELECT a 
//        			FROM ansatt a 
//        			WHERE a.ansatt.id IS NOT NULL
//        			AND a.ansId LIKE :id""";
//        	
//			TypedQuery<Ansatt> query = em.createQuery(jpqlQuery, Ansatt.class);
//			query.setParameter("ansId", id);
//
//			return query.getResultList();
//        	
//        } finally {
//            em.close();
//        }
//    }

}
