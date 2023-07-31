package com.bezkoder.springjwt.repository;

import com.bezkoder.springjwt.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
//@RepositoryRestResource(path = "teams", collectionResourceRel = "teams")
public interface ITeamRepository extends JpaRepository<Team, Long> {



    @Query(value = "SELECT * FROM teams WHERE name LIKE %?1%", nativeQuery = true)
    List<Team> findTeamByName(String name);

    //Team findTeamById(Long id);
}
