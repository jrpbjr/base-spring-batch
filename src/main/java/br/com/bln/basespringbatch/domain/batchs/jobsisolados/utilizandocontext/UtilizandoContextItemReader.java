package br.com.bln.basespringbatch.domain.batchs.jobsisolados.utilizandocontext;

import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PessoaRepository;
import br.com.bln.basespringbatch.domain.entity.origem.PessoaEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Log4j2
@Component
public class UtilizandoContextItemReader extends RepositoryItemReader<PessoaEntity> implements InitializingBean {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        setRepository(pessoaRepository);
        setMethodName("buscarTodasPorId");
        setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        setPageSize(UtilizandoContextStepConfiguration.CHUNK_SIZE);
        super.afterPropertiesSet();
    }

}
