package no.hvl.dat107.entity;

import java.util.List;
import jakarta.persistence.Entity;
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
	@Override
	public String toString() {
		return "Avdeling [avdelingId = " + avdelingId + ", navn = " + navn + ", sjefId = " + sjef + "]";
	}
	
}
