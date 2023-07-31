package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
//@RepositoryRestResource(path = "assignments", collectionResourceRel = "assignments")
public interface IAssignmentRepository  extends JpaRepository<Assignment, Long> {

}
