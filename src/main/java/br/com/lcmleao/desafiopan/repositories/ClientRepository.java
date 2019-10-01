package br.com.lcmleao.desafiopan.repositories;

import br.com.lcmleao.desafiopan.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, BigInteger> {
    @Query("SELECT cli FROM Client cli WHERE cli.cpf = :cpf")
    public Optional<Client> queryByCPF(@Param("cpf") @NotNull String cpf);
}
