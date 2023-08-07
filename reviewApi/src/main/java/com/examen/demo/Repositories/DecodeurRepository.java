package com.examen.demo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examen.demo.Entities.Decodeur;

public interface DecodeurRepository extends JpaRepository<Decodeur, Long>{

	 Decodeur findByAddrMac(String addrMac);
}
