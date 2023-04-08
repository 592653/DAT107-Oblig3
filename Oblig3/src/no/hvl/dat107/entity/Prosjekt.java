package no.hvl.dat107.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity 
@Table(schema = "")
public class Prosjekt {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int prosjektid;
	private String navn;  
	private String beskrivelse;
	
	//Et prosjekt kan ha mange deltagelser (ansatte)
//	@OneToMany(mappedBy="prosjekt")
//	private List<Prosjektdeltagelse> deltagelser;
	
	//@JoinTable?
	//Legg til get og settere?

}
