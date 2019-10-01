package br.com.lcmleao.desafiopan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.math.BigInteger;


@Entity
@Table(name = "ENDERECO")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
    @Id
    @GeneratedValue
    private BigInteger id;
    @ManyToOne
    private City city;
    @ManyToOne
    private State state;
    @Column(nullable = false)
    private String zipCode;
    @Column(nullable = false)
    private String address;
    @Column(nullable = false)
    private String neighborhood;

}
