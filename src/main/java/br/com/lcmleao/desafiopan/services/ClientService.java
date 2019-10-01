package br.com.lcmleao.desafiopan.services;

import br.com.lcmleao.desafiopan.entities.Client;
import br.com.lcmleao.desafiopan.entities.ClientAddress;
import br.com.lcmleao.desafiopan.presenters.ClientAddressVO;
import br.com.lcmleao.desafiopan.presenters.ClientVO;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

public interface ClientService {
    public Optional<ClientVO> queryByID(BigInteger id);
    public Optional<ClientVO> queryByCPF(String cpf);
    public List<ClientVO> queryAll();

    public Optional<ClientVO> saveClient(Client c);
    public Optional<ClientVO> updateClient(Client c);

    public Optional<ClientVO> updateClientAddress(BigInteger id, ClientAddress cAddr);
}
