package br.com.bln.basespringbatch.adapter.gateway.repository.origem;


import br.com.bln.basespringbatch.domain.entity.origem.PessoaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {

    @Query("SELECT ps FROM PessoaEntity ps")
    Page<PessoaEntity> buscarTodasPorId(Pageable pageable);
}
