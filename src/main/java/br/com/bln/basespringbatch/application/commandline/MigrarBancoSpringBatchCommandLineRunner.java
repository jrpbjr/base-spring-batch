package br.com.bln.basespringbatch.application.commandline;


import br.com.bln.basespringbatch.application.utils.FileHelper;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;

@Log4j2
@Component
@Order(1)
public class MigrarBancoSpringBatchCommandLineRunner implements CommandLineRunner {

    @PersistenceContext(unitName = "persistenceUnitDestino")
    private EntityManager entityManagerDestino;

    @Override
    @Transactional(value = "destinoTransactionManager")
    public void run(String... args) throws Exception {
//        Boolean existeCargaOrigem = (Boolean) entityManagerDestino.createNativeQuery("SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_name = 'batch_job_instance')").getSingleResult();
        BigInteger resultado = (BigInteger) entityManagerDestino.createNativeQuery("SELECT EXISTS (SELECT 1 FROM information_schema.tables WHERE table_schema = 'DB_DESTINO' AND table_name = 'BATCH_JOB_INSTANCE') AS tabela_existe").getSingleResult();
        boolean existeCargaOrigem = resultado.intValue() == 1;


        if (!existeCargaOrigem) {
            log.info("## Criando tabelas Spring Batch no DB_DESTINO...");
            try {
                String scriptTabelas = FileHelper.getFileInResources("db/banco-destino-spring-batch-db-postgresql.sql");
                Query nativeQuery = entityManagerDestino.createNativeQuery(scriptTabelas);
                nativeQuery.executeUpdate();
            } catch (Exception e) {
                log.error("## Erro ao migrar scrips para o banco de destino.");
                e.printStackTrace();
                throw e;
            }
        }
    }
}
