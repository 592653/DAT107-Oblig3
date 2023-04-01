package no.hvl.dat107.entity;

import java.util.List;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

//@Entity @Table(schema = "")
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektid;
	private String navn;  
	private String beskrivelse;
	
	@OneToMany(mappedBy="prosjekt")
	private List<Prosjektdeltagelse> deltagelser;
	
	//Legg til get og settere?

}
