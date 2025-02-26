package br.com.bln.basespringbatch.domain.batchs.job.tasklet;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PacienteDestinoRepository;
import br.com.bln.basespringbatch.adapter.gateway.repository.destino.PessoaDestinoRepository;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteDestinoCleanTasklet implements Tasklet {

    @Autowired
    private PacienteDestinoRepository pacienteDestinoRepository;

    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        pacienteDestinoRepository.deleteAll();
        return RepeatStatus.FINISHED;
    }
}
