package com.chnu.zno.repository;

import com.chnu.zno.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialtyRepository extends JpaRepository<Session, Integer> {
}
