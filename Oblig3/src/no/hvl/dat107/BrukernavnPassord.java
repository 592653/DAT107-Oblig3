package no.hvl.dat107;

import java.util.Map;

public class BrukernavnPassord {

	public static final String BRUKERNAVN = ""; //Fyll ut her selv før man kjører husk h fremfor
	public static final String PASSORD    = "";  //Fylll ut her også
	public static final String URL        = "jdbc:postgresql://ider-database.westeurope.cloudapp.azure.com:5432/" + BRUKERNAVN;

	public static Map<String, String> getServerConfig() {
		if (PASSORD.equals("") || BRUKERNAVN.equals("")) {
			throw new RuntimeException("Brukernavn og/eller passord i ServerSetup filen er ikke fylt ut.\nFyll dem ut og prøv igjen");
		}
		return Map.of("jakarta.persistence.jdbc.user", BRUKERNAVN, "jakarta.persistence.jdbc.password", PASSORD, "jakarta.persistence.jdbc.url", URL);
	}

	private BrukernavnPassord() {

	}
}
