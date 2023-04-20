package no.hvl.dat107.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(schema = "oblig3", name = "Avdeling")
public class Avdeling {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int avdelingId;
	public String navn;
	
	//En avdeling må ha en sjef
	@OneToOne
	@JoinColumn(name = "sjef", referencedColumnName = "ansattId")
	public Ansatt sjef;
	
	// en ansatt har en avdeling, en avdeling har mange ansatte
    //@OneToMany(mappedBy = "avdeling", fetch = FetchType.EAGER, cascade = CascadeType.ALL,
	//	       orphanRemoval = true)
    //@JoinColumn
	private List<Ansatt> ansatte;
	
	public Avdeling() {
		
	}
	public Avdeling(int avdelingId, String navn, Ansatt sjef) {
		this.avdelingId = avdelingId;
		this.navn = navn;
		this.sjef = sjef;
	}
	
	public int getAvdelingId() {
		return avdelingId;
	}
	public void setAvdelingId(int avdelingId) {
		this.avdelingId = avdelingId;
	}
	public String getNavn() {
		return navn;
	}
	public void setNavn(String navn) {
		this.navn = navn;
	}
	public Ansatt getSjef() {
		return sjef;
	}
	public void setSjef(Ansatt sjef) {
		this.sjef = sjef;
	}
	
	public List<Ansatt> getAnsatte() {
		return ansatte;
	}
	public void setAnsatte(List<Ansatt> ansatte) {
		this.ansatte = ansatte;
	}
	@Override
	public String toString() {
		return "Avdeling [avdelingId = " + avdelingId + ", navn = " + navn + ", sjefId = " + sjef + "]";
	}
	
}
