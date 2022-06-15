/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.eti.kge.OSApiApplication.api.controller;

import br.eti.kge.OSApiApplication.domain.model.Cliente;
import br.eti.kge.OSApiApplication.domain.model.OrdemServico;
import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoRepository;
import br.eti.kge.OSApiApplication.domain.repository.OrdemServicoService;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



/**
 *
 * @author devsys-b
 */

@RestController
@RequestMapping("/ordem-servico")

public class OrdemServiçoController {

    @Autowired
    private OrdemServicoService ordemServicoService;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrdemServico criar(@RequestBody OrdemServico ordemServico) {
        return ordemServicoService.criar(ordemServico);
    }

    @DeleteMapping("/ordem-servico/{ordemservicoID}")
    public ResponseEntity<Void> excluir(@PathVariable Long ordemservicoID) {

        if (!ordemServicoRepository.existsById(ordemservicoID)) {
            return ResponseEntity.notFound().build();
        }

        OrdemServicoService.excluir(ordemservicoID);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/ordem-servico/{ordemservicoID}")
    public ResponseEntity<Cliente> atualizar(@Valid @PathVariable Long ordemservicoID,
            @RequestBody Cliente ordemservico) {

        if (!ordemServicoRepository.existsById(ordemservicoID)) {
            return ResponseEntity.notFound().build();
        }
        ordemservico.setId(ordemservicoID);
        ordemservico = OrdemServicoService.salvar(ordemservico);
        return ResponseEntity.ok(ordemservico);
    }
    
    @GetMapping ("/ordem-servico/{ordemservicoID}")
    
    public ResponseEntity<Object>buscar(@PathVariable Long ordemservicoID){
        
        Optional<OrdemServico>OrdemServico = ordemServicoRepository.findById(ordemservicoID);
        
        if (OrdemServico.isPresent()){
            return ResponseEntity.ok(OrdemServico.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
