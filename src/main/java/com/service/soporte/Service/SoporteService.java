package com.service.soporte.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.soporte.Model.Soporte;
import com.service.soporte.Repository.SoporteRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SoporteService {
    @Autowired
    private SoporteRepository soporteRepository;

    //Listar usuarios
    public List<Soporte> findAll(){
        return soporteRepository.findAll();
    }

    //Listar usuario por ID
    public Soporte findById(long id){
        return soporteRepository.findById(id).get();
    }

    //guardar usuario por ID
    public Soporte save(Soporte usuario){
        return soporteRepository.save(usuario);
    }

    //Eliminar usuario
    public void delete(long id){
        soporteRepository.deleteById(id);
    }
}
