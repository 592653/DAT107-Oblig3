package no.hvl.dat107.entity;

import java.time.LocalDate;
import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
@Table(schema = "oblig3", name = "ansatt")
public class Ansatt{

	@Id //Primærnøkkel
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ansattId; 
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private LocalDate ansdato;
	private String stilling;
	private int mndlonn;
	//En ansatt må jobbe i en avdeling
	//@OneToOne
	private Integer avdelingId;
	
	
	
	public Ansatt(int ansattId, String brukernavn, String fornavn, String etternavn, LocalDate ansDato, String stilling,
			int mndlonn, Integer avdelingId) {
		this.ansattId = ansattId;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansdato = ansDato;
		this.stilling = stilling;
		this.mndlonn = mndlonn;
		this.avdelingId = avdelingId;
	}
	public Ansatt() {
		
	}

	public int getAnsattId() {
		return ansattId;
	}

	public void setAnsattId(int ansattId) {
		this.ansattId = ansattId;
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

	public LocalDate getAnsdato() {
		return ansdato;
	}

	public void setAnsDato(LocalDate ansdato) {
		this.ansdato = ansdato;
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

	public Integer getAvdelingId() {
		return avdelingId;
	}
	public void setAvdelingId(Integer avdelingId) {
		this.avdelingId = avdelingId;
	}
	@Override
	public String toString() {
		return "Ansatt [ansattid = " + ansattId + ", brukernavn = " + brukernavn + ", fornavn = " + fornavn + ", etternavn = "
				+ etternavn + ", ansettelsesdato = " + ansdato + ", stilling = " + stilling + ", maanedslonn = " + mndlonn
				+ "]";
	}

	public void skrivUt() {
		System.out.println("AnsattID: " + ansattId + " BrukerNavn: " +brukernavn + " Fornavn: " + fornavn +" Etternavn: "+ etternavn 
				+ " ansattelsesdato: " + ansdato +" Stilling: " + stilling + " Månedslønn: " + mndlonn + "\n");
	}

}
