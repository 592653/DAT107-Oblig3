package no.hvl.dat107;

import java.util.Scanner;

import no.hvl.dat107.dao.AnsattDAO;

import java.util.List;

public class Main extends AnsattDAO {
	private static Scanner scanner = new Scanner(System.in);

	// Lag et lite Main-program for å teste at alt er satt opp riktig.
	// Hent f.eks. ut en ansatt og skriv ut på skjermen.
	// (EntityManagerFactory, EntityManager, try, find(), finally, close).

	public static void main(String[] args) {
		AnsattDAO ansattDAO = new AnsattDAO();
//		String userInput = null;
//		String userInput2 = null;
//		userInput = scanner.nextLine();
		leggTilAnsatt();
	
//        List<Ansatt> AlleAnsatt = ansattDAO.hentAnsattliste();    
		System.out.println("Ansatt med id 2: \n" + ansattDAO.finnAnsattMedId(2));	
		System.out.println("Ansatt med brukernavn Lyma: \n" + ansattDAO.finnBrukernavn("Lyma"));	
		System.out.println("Liste over alle ansatte: \n" + ansattDAO.hentAnsattliste());
	}
		
//			System.out.println("Skriv inn stilling");
//			userInput2 = read.nextLine();
//			ansattDAO.OppdaterStillingAnsatt(userInput2, Integer.parseInt(userInput));
//			System.out.println("Stilling har blitt endret til: " + read);
//			read.close();
//		
	private static void leggTilAnsatt() {
		System.out.println("Vennligst skriv inn følgende informasjon: ");
		System.out.print("Skriv inn Fornavn: ");
		String fornavn = scanner.nextLine();

		System.out.print("Skriv inn Etternavn: ");
		String etternavn = scanner.nextLine();
		
		System.out.print("Skriv inn de 2 første bokstav i fornavnet ditt + 2 siste i etternavnet");
		String brukernavn = scanner.nextLine();

		System.out.print("Skriv inn ansettelsesdato: ");
		String ansDato = scanner.nextLine();

		System.out.print("Skriv inn stilling: ");
		String stilling = scanner.nextLine();

		System.out.print("Skriv inn månedslønn: ");
		String mndlonn = scanner.nextLine();
		int lonnint;
		OppdaterAnsatt(fornavn, etternavn, brukernavn, ansDato, stilling, mndlonn);
		try {
			lonnint = Integer.parseInt(mndlonn);
		} catch (NumberFormatException e) {
			System.out.println(
					"Input " + mndlonn + " inneholder andre ting enn tall, prøv igjen eller skriv '0' for å avslutte");
			leggTilAnsatt();
			return;
		}
	
		//scanner.close();
	
	}
}
