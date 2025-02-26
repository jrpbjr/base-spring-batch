package br.com.bln.basespringbatch.domain.batchs.job.itemreader;

import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PacienteRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.PessoaRepository;
import br.com.bln.basespringbatch.domain.batchs.jobsisolados.visualizarciclodevida.CicloDeVidaStepConfiguration;
import br.com.bln.basespringbatch.domain.entity.origem.PacienteEntity;
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
public class PacienteOrigemItemReader extends RepositoryItemReader<PacienteEntity> implements InitializingBean {

    @Autowired
    private PacienteRepository PacienteRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        setRepository(PacienteRepository);
        setMethodName("buscarTodasPorId");
        setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        setPageSize(CicloDeVidaStepConfiguration.CHUNK_SIZE);
        super.afterPropertiesSet();
    }

}
