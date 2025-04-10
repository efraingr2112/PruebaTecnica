package com.PruTec.model.entity.dao;

import com.PruTec.model.entity.dao.Dto.clienteDto;
import com.PruTec.model.entity.dao.cliente.cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends JpaRepository<cliente, Integer> {

    void deleteById(clienteDto cliente);
}
