package ar.org.proyungas.infrastructure.output.persistence.role.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.RoleEntity;


@Repository
public interface RoleRepository extends JpaRepository<RoleEntity, Integer>{

}
