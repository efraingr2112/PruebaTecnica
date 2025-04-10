package com.PruTec.servicio;

import com.PruTec.model.entity.dao.Dto.ClienteDto;
import com.PruTec.model.entity.dao.cliente.Cliente;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public interface IClienteService {

    List<Cliente> listAlll();

    Cliente save(ClienteDto cliente);

    Cliente findById(Integer id);

    void delete(Cliente cliente);

    boolean existsById(Integer id);

}