package br.com.lcmleao.desafiopan.repositories;

import br.com.lcmleao.desafiopan.entities.City;
import br.com.lcmleao.desafiopan.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface CityRepository extends JpaRepository<City, BigInteger> {
    @Query("SELECT c from City c where c.state = :state")
    List<City> queryCitiesByState(@Param("state") State state);
}
