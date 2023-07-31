package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Employed;
import com.bezkoder.springjwt.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "employees", collectionResourceRel = "employees")
public interface IEmployedRepository extends JpaRepository<Employed, Long> {



}
