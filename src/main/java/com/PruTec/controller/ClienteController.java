package com.PruTec.controller;


import com.PruTec.model.entity.dao.cliente;
import com.PruTec.servicio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1")
public class ClienteController {
    @Autowired
    private ICliente clienteService;

    @PostMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente create(@RequestBody cliente Cliente){
       return  clienteService.save(Cliente);

    }
    @PutMapping("cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public cliente update(@RequestBody cliente Cliente){
        return  clienteService.save(Cliente);

    }
    @DeleteMapping("cliente/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try{
            cliente clienteDelete=clienteService.findById(id);
            clienteService.delete(clienteDelete);
            return new ResponseEntity<>(clienteDelete, HttpStatus.NO_CONTENT);
        }catch (DataAccessException exDt){
            response.put("Texto", exDt.getMessage());
            response.put("Texto", null);

            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public cliente showById(@PathVariable Integer id){
        return clienteService.findById(id);
    }



}
