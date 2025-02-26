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
public class MigrarPacienteJob {


    @Autowired
    protected JobBuilderFactory jobBuilderFactory;
    @Bean
    public Job jobMigrarPacienteImp(Step cleanStepImp,
                                    Step stepMigrarPacienteDestino) {
        return jobBuilderFactory
                .get("JOB_MIGRAR_PACIENTE_DESTINO")
                .start(cleanStepImp)
                .next(stepMigrarPacienteDestino)
                .build();
    }
//    @Bean
//    public Job jobMigrarPessoaImp(Step cleanStepImp,
//                                  Step stepMigrarPessoaDestino,
//                                  Step stepMigrarUsuarioDestino) {
//        return jobBuilderFactory
//                .get("JOB_MIGRAR_PESSOA_DESTINO")
//                .start(cleanStepImp)
//                .next(stepMigrarPessoaDestino)
//                .next(stepMigrarUsuarioDestino)
//                .build();
//    }




}
