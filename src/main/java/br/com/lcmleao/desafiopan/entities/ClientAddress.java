package br.com.lcmleao.desafiopan.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Builder
@Entity
@Table(name = "ENDERECO_CLIENTE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClientAddress {
    @Id
    @GeneratedValue
    private BigInteger id;
    @ManyToOne
    private Address address;
    @Column
    private String number;
    @Column
    private String complement;

}
