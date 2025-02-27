package br.com.bln.basespringbatch.domain.batchs.job.step;


import br.com.bln.basespringbatch.domain.batchs.job.tasklet.PacienteDestinoCleanTasklet;
import br.com.bln.basespringbatch.domain.batchs.job.tasklet.PessoaDestinoCleanTasklet;
import br.com.bln.basespringbatch.domain.batchs.job.tasklet.UsuarioDestinoCleanTasklet;
import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CleanStep {

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Bean
    public Step cleanStepImp(
            PessoaDestinoCleanTasklet pessoaDestinoCleanTasklet,
            UsuarioDestinoCleanTasklet usuarioDestinoCleanTasklet,
            PacienteDestinoCleanTasklet pacienteDestinoCleanTasklet) {

        return stepBuilderFactory
                .get("PESSOA_DESTINO_CLEAN_STEP")
                .tasklet(pessoaDestinoCleanTasklet)
                .tasklet(usuarioDestinoCleanTasklet)
                .tasklet(pacienteDestinoCleanTasklet)
                .build();
    }
}
