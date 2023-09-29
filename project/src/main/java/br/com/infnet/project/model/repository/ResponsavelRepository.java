package br.com.infnet.project.model.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.infnet.project.model.domain.Responsavel;

@Repository
public interface ResponsavelRepository extends CrudRepository<Responsavel, Integer> {
}