/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.domain.repository;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author devsys-b
 */

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
    
    List<Cliente> findByNome (String nome);
    List<Cliente> findByNomeContaining(String nome);

    public Cliente findByEmail(String email);
    
}
