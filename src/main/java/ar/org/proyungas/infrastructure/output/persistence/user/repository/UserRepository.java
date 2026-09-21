package ar.org.proyungas.infrastructure.output.persistence.user.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Page<UserEntity> findAll(Specification<UserEntity> specification, Pageable pageable);
}

