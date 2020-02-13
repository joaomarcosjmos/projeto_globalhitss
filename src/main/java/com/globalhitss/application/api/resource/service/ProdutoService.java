package com.globalhitss.application.api.resource.service;

import com.globalhitss.application.api.model.Produto;
import com.globalhitss.application.api.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository pessoaRepository;

    public Produto atualizar(Long codigo, Produto produto){

        Produto produtoSalvo = buscarProdutoPeloCodigo(codigo);
        BeanUtils.copyProperties(produto, produtoSalvo, "codigo");

        return pessoaRepository.save(produtoSalvo);
    }

    public Produto buscarProdutoPeloCodigo(Long codigo) {
        Produto produtoSalvo = pessoaRepository.findOne(codigo);
        if (produtoSalvo == null){

            throw new EmptyResultDataAccessException(1);
        }
        return produtoSalvo;
    }

}
