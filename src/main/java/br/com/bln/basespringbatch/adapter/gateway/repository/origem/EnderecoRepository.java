package br.com.bln.basespringbatch.adapter.gateway.repository.origem;


import br.com.bln.basespringbatch.domain.entity.origem.EnderecoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EnderecoRepository extends JpaRepository<EnderecoEntity, Long> {

    @Query("SELECT ps FROM EnderecoEntity ps")
    Page<EnderecoEntity> buscarTodasPorId(Pageable pageable);
}
