package com.axsosacademy.dojoandninja.repositories;


import com.axsosacademy.dojoandninja.models.Dojo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface DojoRespository extends CrudRepository<Dojo, Long> {
    List<Dojo> findAll();
}
