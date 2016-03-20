
package com.eg.learning.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.eg.learning.domain.CidadeEntity;

@RepositoryRestResource(collectionResourceRel = "cidades", path = "cidades", exported = true)
public interface CidadeRepository extends PagingAndSortingRepository<CidadeEntity, Long> {

	List<CidadeEntity> findByNomeIgnoreCase(String nome);
}