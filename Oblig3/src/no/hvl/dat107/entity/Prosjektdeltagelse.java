package no.hvl.dat107.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(schema = "Oblig3")
public class Prosjektdeltagelse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int timer;
	
	public void utskrift() {
		
	}

}
