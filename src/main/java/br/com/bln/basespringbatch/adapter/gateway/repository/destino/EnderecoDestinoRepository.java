package br.com.bln.basespringbatch.adapter.gateway.repository.destino;


import br.com.bln.basespringbatch.domain.entity.destino.EnderecoDestino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoDestinoRepository extends JpaRepository<EnderecoDestino, Long> {

    @Query("SELECT endereco.id FROM EnderecoDestino endereco")
    List<Object[]> mapDeParams();




}
