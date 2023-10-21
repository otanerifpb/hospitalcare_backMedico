package br.edu.ifpb.pdist.back.repository;

import  br.edu.ifpb.pdist.back.model.Medico;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicoRepository extends JpaRepository<Medico, Integer> {
    Optional<Medico> findByCrm(String string);

}
