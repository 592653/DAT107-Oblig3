package no.hvl.dat107;

import java.time.LocalDate;
//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansattid; // @id her?
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansDato;
	private String stilling;
	private int mndlonn;

	// private List<Ansatt> ansatt;
	
	public Ansatt(int ansattid, String brukernavn, String fornavn, String etternavn, LocalDate ansDato, String stilling,
			int mndlonn) {
		this.ansattid = ansattid;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansDato = ansDato;
		this.stilling = stilling;
		this.mndlonn = mndlonn;
	}
	public Ansatt() {
		
	}

	public int getAnsattid() {
		return ansattid;
	}

	public void setAnsattid(int ansattid) {
		this.ansattid = ansattid;
	}

	public String getBrukernavn() {
		return brukernavn;
	}

	public void setBrukernavn(String brukernavn) {
		this.brukernavn = brukernavn;
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}

	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public LocalDate getAnsDato() {
		return ansDato;
	}

	public void setAnsDato(LocalDate ansDato) {
		this.ansDato = ansDato;
	}

	public String getStilling() {
		return stilling;
	}

	public void setStilling(String stilling) {
		this.stilling = stilling;
	}

	public int getMndlønn() {
		return mndlonn;
	}

	public void setMndlønn(int mndlønn) {
		this.mndlonn = mndlønn;
	}

//	public List<Ansatt> getAnsatt() {
//		return ansatt;
//	}
//
//	public void setAnsatt(List<Ansatt> ansatt) {
//		this.ansatt = ansatt;
//	}
	@Override
	public String toString() {
		return "Ansatt [ansattid = " + ansattid + ", brukernavn = " + brukernavn + ", fornavn = " + fornavn + ", etternavn = "
				+ etternavn + ", ansettelsesdato = " + ansDato + ", stilling = " + stilling + ", maanedslonn = " + mndlonn
				+ "]";
	}

	public void skrivUt() {

	}

}
