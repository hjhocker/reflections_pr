package com.harrison.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ProficiencyConverter implements AttributeConverter<Proficiency, String> {

	@Override
	public String convertToDatabaseColumn(Proficiency attribute) {
		switch (attribute) {
			case BEGINNER:
				return "BEGINNER";
			case INTERMEDIATE:
				return "INTERMEDIATE";
			case ADVANCED:
				return "ADVANCED";
			case EXPERT:
				return "EXPERT";
			default:
				throw new IllegalArgumentException("Unknown Proficiency Level: " + attribute); 
		}
	}

	@Override
	public Proficiency convertToEntityAttribute(String dbData) {
		switch (dbData) {
		case "BEGINNER":
			return Proficiency.BEGINNER;
		case "INTERMEDIATE":
			return Proficiency.INTERMEDIATE;
		case "ADVANCED":
			return Proficiency.ADVANCED;
		case "EXPERT":
			return Proficiency.EXPERT;
		default:
			throw new IllegalArgumentException("Unknown Proficiency Level: " + dbData); 
	}
	}

}
