package com.bezkoder.springjwt.repository;


import com.bezkoder.springjwt.models.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
//@RepositoryRestResource(path = "routes", collectionResourceRel = "routes")
public interface IRouteRepository extends JpaRepository <Route, Long> {
}
