package br.com.bln.basespringbatch.application.configuration;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableJpaRepositories(
        entityManagerFactoryRef = "destinoEntityManagerFactory",
        transactionManagerRef = "destinoTransactionManager",
        basePackages = {"br.com.bln.basespringbatch.adapter.gateway.repository.destino"})
@EnableAutoConfiguration
@EnableTransactionManagement
public class DBDestinoConfiguration {

    @Primary
    @Bean(name = "destino-datasource")
    @ConfigurationProperties(prefix = "destino.datasource")
    public DataSource criarDatasourceDestino() {
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "destinoEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean batchEntityManagerFactory(EntityManagerFactoryBuilder builder,
                                                                            @Qualifier("destino-datasource") DataSource datasource) {

        Map<String, String> properties = new HashMap<>();
//        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL9Dialect");
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
        properties.put("hibernate.hbm2ddl.auto", "update");


        LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean = builder
                .dataSource(datasource)
//                .packages("br.com.bln.estudospringbatch.domain.entity.destino")
                .packages("br.com.bln.basespringbatch.domain.entity.destino")
                .persistenceUnit("persistenceUnitDestino")
                .properties(properties)
                .build();

//        localContainerEntityManagerFactoryBean.setJpaPropertyMap(Collections.singletonMap("javax.persistence.flushMode", "COMMIT"));
//        localContainerEntityManagerFactoryBean.setJpaPropertyMap(Collections.singletonMap("org.hibernate.flushMode", "COMMIT"));
//        localContainerEntityManagerFactoryBean.setJpaPropertyMap(Collections.singletonMap("hibernate.jdbc.batch_size", "300"));
//        localContainerEntityManagerFactoryBean.setJpaPropertyMap(Collections.singletonMap("org.hibernate.jdbc.batch_size", "300"));
        return localContainerEntityManagerFactoryBean;
    }

    @Primary
    @Bean(name = "destinoTransactionManager")
    public PlatformTransactionManager batchTransactionManager(@Qualifier("destinoEntityManagerFactory") EntityManagerFactory emFactory) {
        return new JpaTransactionManager(emFactory);
    }
}
