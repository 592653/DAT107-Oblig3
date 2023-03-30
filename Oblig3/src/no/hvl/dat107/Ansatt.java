package no.hvl.dat107;

import java.util.Date;
//import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3")
public class Ansatt {

	@Id
	// @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id; // @id her?
	private String brukernavn;
	private String fornavn;
	private String etternavn;
	private Date ansDato;
	private String stilling;
	private int mndlonn;

	// private List<Ansatt> ansatt;
	
	public Ansatt(int id, String brukernavn, String fornavn, String etternavn, Date ansDato, String stilling,
			int mndlonn) {
		this.id = id;
		this.brukernavn = brukernavn;
		this.fornavn = fornavn;
		this.etternavn = etternavn;
		this.ansDato = ansDato;
		this.stilling = stilling;
		this.mndlonn = mndlonn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getAnsDato() {
		return ansDato;
	}

	public void setAnsDato(Date ansDato) {
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
		return "Ansatt [ansattid=" + id + ", brukernavn=" + brukernavn + ", fornavn=" + fornavn + ", etternavn= "
				+ etternavn + ", ansettelsesdato=" + ansDato + ", stilling=" + stilling + ",maanedslonn=" + mndlonn
				+ "]";
	}

	public void skrivUt() {

	}

}
