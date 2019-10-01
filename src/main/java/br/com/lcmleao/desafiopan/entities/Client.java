package br.com.lcmleao.desafiopan.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Builder
@Entity
@Data
@Table(
    name = "CLIENTE",
    uniqueConstraints=@UniqueConstraint(columnNames={"cpf"})
)
@NoArgsConstructor
@AllArgsConstructor
public class Client {
    @Id
    @GeneratedValue
    private BigInteger id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String cpf;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<ClientAddress> addresses;
}
