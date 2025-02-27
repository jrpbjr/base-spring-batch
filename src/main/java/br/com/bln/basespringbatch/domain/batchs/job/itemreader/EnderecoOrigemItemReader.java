package br.com.bln.basespringbatch.domain.batchs.job.itemreader;

import br.com.bln.basespringbatch.adapter.gateway.repository.origem.CaracteristicasRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.origem.EnderecoRepository;
import br.com.bln.basespringbatch.domain.batchs.jobsisolados.visualizarciclodevida.CicloDeVidaStepConfiguration;
import br.com.bln.basespringbatch.domain.entity.origem.EnderecoEntity;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Log4j2
@Component
public class EnderecoOrigemItemReader extends RepositoryItemReader<EnderecoEntity> implements InitializingBean {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Override
    public void afterPropertiesSet() throws Exception {
        setRepository(enderecoRepository);
        setMethodName("buscarTodasPorId");
        setSort(Collections.singletonMap("id", Sort.Direction.ASC));
        setPageSize(CicloDeVidaStepConfiguration.CHUNK_SIZE);
        super.afterPropertiesSet();
    }


}
