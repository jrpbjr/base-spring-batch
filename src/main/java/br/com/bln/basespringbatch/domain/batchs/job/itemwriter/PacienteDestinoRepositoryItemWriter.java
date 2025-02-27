package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class PacienteDestinoRepositoryItemWriter {

    @Autowired
    private PacienteDestinoRepository pacienteDestinoRepository;

//    @Bean
//    public RepositoryItemWriter<PacienteDestino> writer() {
//        RepositoryItemWriter<PacienteDestino> writer = new RepositoryItemWriter<>();
//        writer.setRepository(pacienteDestinoRepository);
//        writer.setMethodName("save");
//        return writer;
//    }
}