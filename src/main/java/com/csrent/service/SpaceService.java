package com.csrent.service;

import com.csrent.model.Space;
import com.csrent.repository.SpaceJpaRepository;
import com.csrent.repository.SpaceRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SpaceService {
    @Autowired
    SpaceJpaRepository repository;


    public List<Space> getAll(){ return repository.findAll();}
    public Space add(Space space){ return repository.save(space);}
    public boolean existsById(Integer id){ return repository.existsById(id);}
    public void delete(Integer id){
        repository.deleteById(id);
    }
    public Space update(Space space){

        return repository.save(space);
    }

    public Space getSpace(Integer id){
        Optional<Space> space= repository.findById(id);
        if(space.isPresent()){
            return space.get();
        }
        return null;
    }



   public Space edit(Space space) {
       Space spaceBd = getSpace(space.getId());
           if (space.getName() != null) {
               spaceBd.setName(space.getName());
           }

           if (space.getCapacity() != null) {
               spaceBd.setCapacity(space.getCapacity());
           }

           if (space.getType() != null) {
               spaceBd.setType(space.getType());
           }

           return repository.save(spaceBd);

   }

   public boolean existByNameSpace(String name){
        return repository.existsByName(name);
   }
    public Space getSpaceByName(String name) {
         return repository.findByName(name);
    }
}
