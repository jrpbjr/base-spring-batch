package br.com.bln.basespringbatch.domain.batchs.job.itemwriter;

import br.com.bln.basespringbatch.domain.entity.destino.PacienteDestino;
import br.com.bln.basespringbatch.domain.entity.destino.PessoaDestinoEntity;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManagerFactory;

@Component
public class PacienteDestinoJpaItemWriter extends JpaItemWriter<PacienteDestino> implements InitializingBean {
    @Autowired
    @Qualifier("destinoEntityManagerFactory")
    private EntityManagerFactory entityManagerFactory;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.setEntityManagerFactory(entityManagerFactory);
        super.afterPropertiesSet();
    }
}
