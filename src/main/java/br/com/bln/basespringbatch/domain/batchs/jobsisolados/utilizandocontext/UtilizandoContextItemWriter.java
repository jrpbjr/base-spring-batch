package br.com.bln.basespringbatch.domain.batchs.jobsisolados.utilizandocontext;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PessoaDestinoRepository;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class UtilizandoContextItemWriter extends RepositoryItemWriter<PessoaDestinoEntity>  {

    @Autowired
    private PessoaDestinoRepository pessoaDestinoRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        super.setRepository(pessoaDestinoRepository);
        super.afterPropertiesSet();
    }
}
