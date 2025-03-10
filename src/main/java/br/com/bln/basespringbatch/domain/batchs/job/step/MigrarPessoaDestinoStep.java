package br.com.bln.basespringbatch.domain.batchs.job.step;

import br.com.bln.basespringbatch.domain.batchs.job.itemreader.PessoaOrigemItemReader;
import br.com.bln.basespringbatch.domain.batchs.job.itemwriter.PessoaDestinoRepositoryItemWriter;
import br.com.bln.basespringbatch.domain.batchs.job.listner.executionlistener.MapDeParaPessoaExecutionListener;
import br.com.bln.basespringbatch.domain.batchs.jobsisolados.migrarpessoa.UsuarioDestinoProcessor;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.builder.SimpleStepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MigrarPessoaDestinoStep {

    public static final int CHUNK_SIZE = 20000;

    @Autowired
    protected StepBuilderFactory stepBuilderFactory;

    @Autowired
    protected UsuarioDestinoProcessor usuarioDestinoProcessor;

    @Bean
    public Step migrarPessoaDestinoStepImp(PessoaOrigemItemReader pessoaOrigemItemReader,
                                           ItemProcessor pessoaOrigemToPessoaDestinoProcessor,
                                           PessoaDestinoRepositoryItemWriter pessoaDestinoJpaItemWriter,
                                           MapDeParaPessoaExecutionListener mapDeParaPessoaExecutionListener) {

        SimpleStepBuilder simpleStepBuilder = stepBuilderFactory
                .get("MIGRAR_PESSOA_UTILIZANDO_MAP_NO_LISTNER_STEP")
                .chunk(CHUNK_SIZE)
                .reader(pessoaOrigemItemReader)
                .processor(pessoaOrigemToPessoaDestinoProcessor)
                .writer(pessoaDestinoJpaItemWriter);

        simpleStepBuilder.listener(mapDeParaPessoaExecutionListener);

        return simpleStepBuilder.build();
    }
}
