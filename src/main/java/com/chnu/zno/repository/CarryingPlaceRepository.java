package com.chnu.zno.repository;

import com.chnu.zno.model.CarryingPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarryingPlaceRepository extends JpaRepository<CarryingPlace, Integer> {
}
