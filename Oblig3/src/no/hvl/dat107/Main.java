package no.hvl.dat107;

//import java.util.Scanner;

public class Main {
	//Lag et lite Main-program for å teste at alt er satt opp riktig. 
	//Hent f.eks. ut en ansatt og skriv ut på skjermen. 
	//(EntityManagerFactory, EntityManager, try, find(), finally, close).

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();
	//	Scanner read = new Scanner(System.in);
//		
//     	Ansatt ans = dao.finnAnsattMedId(2);
//		System.out.println(ans);
//		
//		List<Ansatt> hmmm = dao.hentAnsattliste(1);
//		hmmm.forEach(System.out::println);
		
		
		System.out.println(ansattDAO.finnAnsattMedId(1));
		
		//ansattDAO.start();

	}

}
