package com.PruTec.model.entity.dao;

import com.PruTec.model.entity.dao.cliente.Cliente;
import org.springframework.data.repository.CrudRepository;

public interface ClienteDao extends CrudRepository<Cliente, Integer> {
}