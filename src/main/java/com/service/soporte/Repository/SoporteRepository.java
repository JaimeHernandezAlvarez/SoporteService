package com.service.soporte.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.service.soporte.Model.Soporte;

@Repository
public interface SoporteRepository  extends JpaRepository<Soporte,Long>{

}
