package br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBatchProcessing
public class MigrarCaracteristicasJob {

    @Autowired
    protected JobBuilderFactory jobBuilderFactory;
    @Bean
    public Job jobMigrarCaracteristicasImp(Step cleanStepImp,
                                    Step stepMigrarCaracteristicasDestino) {
        return jobBuilderFactory
                .get("JOB_MIGRAR_CARACTERISTICAS_DESTINO")
                .start(cleanStepImp)
                .next(stepMigrarCaracteristicasDestino)
                .build();
    }

}
