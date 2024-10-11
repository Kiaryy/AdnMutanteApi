package com.example.AdnMutanteApi.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.AdnMutanteApi.model.Human;


@Repository
public interface HumanRepository extends JpaRepository<Human, Long> {
}
