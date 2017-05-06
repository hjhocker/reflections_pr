package com.harrison.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import com.harrison.enums.Proficiency;
import com.harrison.enums.ProficiencyConverter;

@Entity
@Table(name = "skill")
public class Skill implements Serializable {

	private static final long serialVersionUID = -3549482610894840527L;

	@Id
	@Column(name = "name")
	private String name;

	@NotBlank
	@Column(name = "years_of_experience")
	private float yearsOfExperience;

	@NotNull
	@Column(name = "proficiency")
	@Convert(converter = ProficiencyConverter.class)
	private Proficiency proficiency;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(float yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public Proficiency getProficiency() {
		return proficiency;
	}

	public void setProficiency(Proficiency proficiency) {
		this.proficiency = proficiency;
	}

}
