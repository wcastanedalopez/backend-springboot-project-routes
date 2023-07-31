package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Assignment;
import com.bezkoder.springjwt.models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@RepositoryRestResource(path = "registrations", collectionResourceRel = "registrations")
public interface IRegistrationRepository  extends JpaRepository<Registration, Long> {

    Optional<Registration> findTopByOrderByCreatedAtDesc();

    //Optional<Registration> findById(Long id);
}
