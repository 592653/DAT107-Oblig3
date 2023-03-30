package no.hvl.dat107;

public class Main {
	//Lag et lite Main-program for å teste at alt er satt opp riktig. 
	//Hent f.eks. ut en ansatt og skriv ut på skjermen. 
	//(EntityManagerFactory, EntityManager, try, find(), finally, close).

	public static void main(String[] args) {
//		AnsattDAO dao = new AnsattDAO();
//		
//     	Ansatt ans = dao.finnAnsattMedId(2);
//		System.out.println(ans);
//		
//		List<Ansatt> hmmm = dao.hentAnsattliste(1);
//		hmmm.forEach(System.out::println);
		
		AnsattDAO ansattDAO = new AnsattDAO();
		
		System.out.println(ansattDAO.finnAnsattMedId(1));

	}

}
