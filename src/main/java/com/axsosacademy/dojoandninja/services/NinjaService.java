package com.axsosacademy.dojoandninja.services;


import com.axsosacademy.dojoandninja.models.Ninja;
import com.axsosacademy.dojoandninja.repositories.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {
    private final NinjaRepository ninjaRepository;
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // Get All Ninjas
    public List<Ninja> getAllNinjas() {
        return ninjaRepository.findAll();
    }

    // Add new Ninja
    public void addNewNinja(Ninja ninja) {
        ninjaRepository.save(ninja);
    }
}
