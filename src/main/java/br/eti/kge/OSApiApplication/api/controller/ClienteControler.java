/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author devsys-b
 */

@RestController
public class ClienteControler {
    
    @PersistenceContext
            private EntityManager manager;
    
    List <Cliente> listaClientes;
    
    @GetMapping ("/clientes")
    public List<Cliente> listas(){
        
        //Linguagem JPQL (Tipo SQL só que Jakarta)
        return manager.createQuery ("From Cliente", Cliente.class).getResultList();
    }
}

