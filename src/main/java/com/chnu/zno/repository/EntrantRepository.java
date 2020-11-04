package com.chnu.zno.repository;

import com.chnu.zno.model.Entrant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntrantRepository extends JpaRepository<Entrant, Integer> {
}
