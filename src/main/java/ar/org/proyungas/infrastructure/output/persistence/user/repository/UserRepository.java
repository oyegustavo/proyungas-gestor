package ar.org.proyungas.infrastructure.output.persistence.user.repository;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.org.proyungas.infrastructure.output.persistence.entities.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Page<UserEntity> findAll(Specification<UserEntity> specification, Pageable pageable);
    @Query("SELECT u FROM UserEntity u WHERE LOWER(u.username) LIKE LOWER(CONCAT('%', :username, '%'))")
    Optional<UserEntity> findByUsernameLikeIgnoreCase(@Param("username") String username);
    Optional<UserEntity> findByUsername(String username);
}