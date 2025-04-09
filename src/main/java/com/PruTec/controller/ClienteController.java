package com.PruTec.controller;


import com.PruTec.model.entity.dao.cliente;
import com.PruTec.servicio.ICliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        cliente clienteDelete=clienteService.findById(id);
         clienteService.delete(clienteDelete);

    }
    @GetMapping("cliente/{id}")
    @ResponseStatus(HttpStatus.OK)
    public cliente showById(@PathVariable Integer id){
        return clienteService.findById(id);
    }



}
