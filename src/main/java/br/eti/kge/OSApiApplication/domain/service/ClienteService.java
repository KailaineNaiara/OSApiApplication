/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.domain.service;

import br.eti.kge.OSApiApplication.domain.exception.DomainException;
import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author devsys-b
 */
@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;
    
    public Cliente salvar(Cliente cliente){
        Cliente clienteExistente = clienteRepository.findByEmail (cliente.getEmail());
        
        if (clienteExistente != null && !clienteExistente.equals(cliente)){
            throw new DomainException("Ja existe um cliente cadastrado com esse email !");
            
            
        }
        
        return clienteRepository.save(cliente);
    }
    
    public void excluir (Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
