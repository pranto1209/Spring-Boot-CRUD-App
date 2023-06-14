package com.masumpranto.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masumpranto.main.model.Programmer;

@Repository
public interface ProgrammerRepo extends JpaRepository<Programmer, Integer> {

}
