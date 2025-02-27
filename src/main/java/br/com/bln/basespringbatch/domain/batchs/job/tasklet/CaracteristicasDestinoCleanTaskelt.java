package br.com.bln.basespringbatch.domain.batchs.job.tasklet;

import br.com.bln.basespringbatch.adapter.gateway.repository.destino.CaracteristicasDestinoRepository;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CaracteristicasDestinoCleanTaskelt  implements Tasklet {
    @Autowired
    private CaracteristicasDestinoRepository caracteristicasDestinoRepository;


    @Override
    public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
        caracteristicasDestinoRepository.deleteAll();
        return RepeatStatus.FINISHED;


    }
}
