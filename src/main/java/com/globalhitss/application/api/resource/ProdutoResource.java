package com.globalhitss.application.api.resource;

import com.globalhitss.application.api.event.RecursoCriadoEvent;
import com.globalhitss.application.api.model.Produto;
import com.globalhitss.application.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoResource {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ApplicationEventPublisher publisher;

    /**
     * Buscar todos produtos
     * @return Retorna lista de todos produtos
     */
    @GetMapping
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    /**
     * Buscar dados por código
     * @param codigo Recebe o código referente ao dado salvo
     * @return Retorna a informação buscado pelo código
     */
    @GetMapping("/{codigo}")
    public ResponseEntity<Produto> buscarPeloCodigo(@PathVariable Long codigo){
        Produto produto = produtoRepository.findOne(codigo);
        return produto != null ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    /**
     * Pesistir dados no BD
     * @param produto Dado informado para persistir bi BD
     * @param response Recebe a requisição
     * @Valid Usado na vaçidação dos campos
     * @return Retorna Locale do dado salvo
     *
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto, HttpServletResponse response){
        Produto produtoSalvo = produtoRepository.save(produto);
        publisher.publishEvent(new RecursoCriadoEvent(this, response, produtoSalvo.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoSalvo);
    }

    @DeleteMapping("/{codigo}")
    @ResponseStatus(HttpStatus.NO_CONTENT) //Retorna um código 204
    public void remover(@PathVariable Long codigo){
        produtoRepository.delete(codigo);
    }




}
