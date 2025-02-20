package br.com.bln.basespringbatch.adapter.gateway.repository.destino;


import br.com.bln.basespringbatch.domain.entity.destino.UsuarioDestinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDestinoRepository extends JpaRepository<UsuarioDestinoEntity, Long> {

}
