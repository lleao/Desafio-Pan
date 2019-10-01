package br.com.lcmleao.desafiopan.repositories;

import br.com.lcmleao.desafiopan.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, BigInteger> {
    @Query(
        value = "SELECT COUNT(addr.id) > 0 FROM Address addr WHERE addr.zipCode = :cep"
    )
    Boolean existsByCEP(@Param("cep") String cep);

    @Query(
            value = "SELECT addr FROM Address addr WHERE addr.zipCode = :cep"
    )
    List<Address> findAllByCep(@Param("cep") String cep);
}
