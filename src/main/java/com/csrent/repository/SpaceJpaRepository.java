package com.csrent.repository;

import com.csrent.model.Space;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpaceJpaRepository extends JpaRepository<Space,Integer> {

    boolean existsByName(String name );
    Space findByName(String name);

}
