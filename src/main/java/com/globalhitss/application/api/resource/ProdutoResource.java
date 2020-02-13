package com.globalhitss.application.api.resource;

import com.globalhitss.application.api.model.Produto;
import com.globalhitss.application.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    /**
     * Buscar todos produtos
     * @return Retorna lista de todos produtos
     */
    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

}
