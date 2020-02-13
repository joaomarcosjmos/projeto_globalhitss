package com.globalhitss.application.api.repository;

import com.globalhitss.application.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
