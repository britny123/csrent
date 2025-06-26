package com.csrent.repository;

import com.csrent.model.Space;
import org.springframework.stereotype.Repository;

@Repository
public class SpaceRepository extends CRUDMemory<Space>{

    public SpaceRepository() {

        data.add(new Space(1, "Grabación In", "Cabina de grabación", 20));
        data.add(new Space(2, "TV Group", "Estudio de televisión", 100));
        data.add(new Space(3, "Ballet Vero", "Salón de Ballet", 50));
        data.add(new Space(4, "Esteban Record", "Estudio de grabación", 24));
    }

    @Override
    public Space edit(Space space) {
        for (Space element : data) {
            if(element.getId().intValue() == space.getId().intValue()){
                if(space.getName()!=null){
                    element.setName(space.getName());
                }
                if(space.getType()!=null){
                    element.setType(space.getType());
                }
                if(space.getCapacity() !=null){
                    element.setCapacity(space.getCapacity());
                }
                return element;
            }
        }
        return space;
    }
}
