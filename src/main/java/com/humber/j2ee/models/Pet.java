package com.humber.j2ee.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Pet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	//lombok doesn't recognize public enum Type {DOG,CAT,OTTER,CHIPMUNK}
	// so we define a type and then use it
	public enum Type {DOG, CAT, OTTER, CHIPMUNK}
	private Type type; // Enum field

	private String breed;

}
