package com.harrison.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.harrison.domain.Name;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {

}
