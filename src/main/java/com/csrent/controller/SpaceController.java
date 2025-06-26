package com.csrent.controller;


import com.csrent.model.Space;
import com.csrent.service.SpaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/space")
public class SpaceController {

    @Autowired
    SpaceService service;


    @GetMapping
    public ResponseEntity<?> getAll() {
        List<?> spaces = service.getAll();
        if (spaces == null || spaces.isEmpty()) {
            return ResponseEntity.ok("No hay Espacios Creativos registrados");
           // return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(service.getAll()); 

    }

    //Retornar un Space según su id
    @GetMapping("{id}")
    public ResponseEntity<?> getSpace(@PathVariable Integer id) {
       if(service.existsById(id)){
           return ResponseEntity.ok(service.getSpace(id));
       }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encuentra un espacio creativo con el id "+id);
        //return ResponseEntity.ok("No se encuentra un espacio creativo con el id "+id);
       // return ResponseEntity.notFound().build();
    }
    @GetMapping("/name/{name}")
    public ResponseEntity<?> getSpaceByName(@PathVariable String name) {
        if(service.existByNameSpace(name)){
            return ResponseEntity.status(HttpStatus.FOUND).body("Ese nombre ya está registrado");
        }
        return ResponseEntity.ok(service.getSpaceByName(name));
    }

    @PatchMapping
    public ResponseEntity<Space> patchSpace(@RequestBody Space space){
        return ResponseEntity.ok(service.edit(space));
    }

    @PostMapping
    public ResponseEntity<?> postSpace(@RequestBody Space space) {
        Space created = service.add(space);
        if (created == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("No se pudo crear el espacio creativo. Verifique los datos ingresados.");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(created);

    }
    @PutMapping
    public ResponseEntity<?> putSpace(@RequestBody Space space) {
        if (space.getId() == null || !service.existsById(space.getId())) {
            return ResponseEntity.notFound().build(); // 404 Not Found si no existe
        }

        Space updated = service.update(space);
        return ResponseEntity.ok(updated); // 200 OK con el objeto actualizado
    }
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteSpace(@PathVariable Integer id){
        if(service.existsById(id)){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }



    /**Aquí queda el código que estaba comentado en la versión anterior
     * cuando se usaba un ArrayList<Space> para manejar los espacios creativos.
     * de SpaceController, pero que no se usa actualmente.
     * Se puede eliminar si no se necesita.
     */

   /* @GetMapping("/space/{name}")
    public Space getSpaceByName(@PathVariable String name) {
        //ArrayList<Space> tempSpaces= new ArrayList<Space>();
        for (int element = 0; element < spaces.size(); element++) {
            if (spaces.get(element).getName().equalsIgnoreCase(name)) {
              return spaces.get(element); // tempSpaces.add(spaces.get(element));
            }
        }
        return new Space();//tempSpaces;
    }*/
/*
    @GetMapping("/space/name/{name}")
    public List<Space> getSpaceByName(@PathVariable String name) {
        List<Space> tempSpaces= new ArrayList<Space>();
        for (int element = 0; element < spaces.size(); element++) {
            if (spaces.get(element).getName().equalsIgnoreCase(name)) {
                tempSpaces.add(spaces.get(element));
            }
        }
        return tempSpaces;
    }
*/
    //Agregue un Space al arreglo


    //Método que actualice la información de un elemento contenido en el ArrayList



//Método que actualice la información de un elemento contenido en el ArrayList
/*@PutMapping("/space")
public Space putSpace(@RequestBody Space space) {
    for (int element = 0; element < this.spaces.size(); element++) {
        if (spaces.get(element).getId() == space.getId()) {
            return spaces.set(element, space);
        }
    }
    return new Space();
}*/
    //Un método que elimine un usuario por su id



    /*
    @DeleteMapping("/space/{id}")
    public Space deleteSpace(@PathVariable int id){
        for(int element=0; element < spaces.size(); element++){
            if(spaces.get(element).getId() == id){
                return spaces.remove(element);
            }
        }
        return new Space();
    }
*/

    //Método que reciba un objeto y verifique cuáles atributros traen información
    //Solo modifica los atributos que correspondan

    /*public Space patchSpace (Space space){
        for (int element = 0; element < spaces.size(); element++) {
            if (!spaces.isEmpty()) {
                if(spaces.get(element).getId() == space.getId()) {
                    spaces.set(element, space);
                    return spaces.get(element);
                }
            }
        }
        return new Space();
    }*/




}
