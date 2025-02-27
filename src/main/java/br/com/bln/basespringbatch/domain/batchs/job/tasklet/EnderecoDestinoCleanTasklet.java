package br.com.bln.basespringbatch.domain.batchs.job.tasklet;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.CaracteristicasDestinoRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.destino.EnderecoDestinoRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EnderecoDestinoCleanTasklet implements Tasklet {

    @Autowired
    private EnderecoDestinoRepository enderecoDestinoRepository;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        enderecoDestinoRepository.deleteAll();
        return RepeatStatus.FINISHED;


    }
}
