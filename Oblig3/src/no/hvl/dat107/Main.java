package no.hvl.dat107;

import java.util.Scanner;

import no.hvl.dat107.dao.AnsattDAO;
import no.hvl.dat107.dao.AvdelingDAO;
import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;
import no.hvl.dat107.entity.Prosjekt;

import java.time.LocalDate;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		AnsattDAO ansattDao = new AnsattDAO();
		AvdelingDAO avdelingDao = new AvdelingDAO();
		Scanner sc = new Scanner(System.in);

		String userInput, userInput2 = null; 
		boolean running = true;
	    Ansatt ansatt = null;
	
		
		System.out.println("--------------------------------------------------------------------");

		while (running) {
			System.out.println("A = Se liste over alle ansatte");
			System.out.println("B = Søke etter ansatt med id");
			System.out.println("C = Søke etter ansatt med brukernavn");
			System.out.println("D = Oppdatere en stilling");
			System.out.println("E = Søke etter avdeling med id");
			//System.out.println("F = Se liste over alle på en avdeling");
			System.out.println("F = Avslutt spørringen");
			

			userInput = sc.nextLine();

			switch (userInput) {
			case "A":
				ansattDao.hentAnsattliste();
				break;

			case "B":
				System.out.println("Skriv inn ID til ansatt: ");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnAnsattMedId(Integer.parseInt(userInput));

				if (ansatt != null) {
					System.out.println(ansatt.toString());
				} else {
					System.out.println("Finnes ikke");
				}
				break;

			case "C":
				System.out.println("Skriv inn brukernavn: ");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnBrukernavn(userInput);
				if (ansatt != null) {
					System.out.println(ansatt.toString());
				} else {
					System.out.println("Finnes ikke");
				}
				break;

			case "D":
				System.out.println("Skriv inn id: ");
				userInput = sc.nextLine();
				ansatt = ansattDao.finnAnsattMedId(Integer.parseInt(userInput));
				if (ansatt != null) {
					System.out.println("Skriv inn stilling: ");
					userInput2 = sc.nextLine();
					ansattDao.oppdaterStilling(userInput2, Integer.parseInt(userInput));
					System.out.println("Ansatt med id " + userInput + " har nå fått stillingen " + userInput2);
				} else {
					System.out.println("Finnes ikke");
				}
				break;
				
			case "E":
				System.out.print("Skriv inn avdelingens id ");
				userInput = sc.nextLine();
				System.out.println(avdelingDao.finnAvdelingMedId(Integer.parseInt(userInput)));

				break;
				
//			case "F":
//				//Funker ikkje
//				System.out.print("Skriv inn avdelingens id ");
//				userInput = sc.nextLine();
//				avdelingDao.skrivUtAllePaAvd(Integer.parseInt(userInput));
//				break;
		
			case "F":
				System.out.println("Avsluttet");
				System.out.println("--------------------------------------------------------------------");
				running = false;
				sc.close();
				break;
			}
		}
	}
}
