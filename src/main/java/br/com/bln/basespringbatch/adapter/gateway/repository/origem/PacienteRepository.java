package br.com.bln.basespringbatch.adapter.gateway.repository.origem;

import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;

import br.com.bln.basespringbatch.domain.entity.origem.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PacienteRepository extends JpaRepository<PacienteEntity, Long> {


    @Query("SELECT ps FROM PacienteEntity ps")
    Page<PacienteEntity> buscarTodasPorId(Pageable pageable);
}
