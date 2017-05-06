package com.harrison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.domain.Skill;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

	Skill findByName(String name);

}
