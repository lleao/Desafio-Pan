package br.com.lcmleao.desafiopan.repositories;

import br.com.lcmleao.desafiopan.entities.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;

@Repository
public interface StateRepository extends JpaRepository<State, BigInteger> {
}
