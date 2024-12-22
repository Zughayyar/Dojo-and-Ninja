package com.axsosacademy.dojoandninja.services;

import com.axsosacademy.dojoandninja.models.Dojo;
import com.axsosacademy.dojoandninja.repositories.DojoRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DojoService {
    private final DojoRespository dojoRespository;
    public DojoService(DojoRespository dojoRespository) {
        this.dojoRespository = dojoRespository;
    }

    // Get All Dojos
    public List<Dojo> getAllDojos() {
        return dojoRespository.findAll();
    }

    // Add new Dojo
    public void addDojo(Dojo dojo) {
        dojoRespository.save(dojo);
    }

    // Get Dogo by Id
    @Transactional
    public Dojo getDojoById(Long id) {
        return dojoRespository.findById(id).orElse(null);
    }

}
