package br.com.integration.open.shift.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EntityScan(basePackages = {"br.com.integration"})
@EnableJpaRepositories(basePackages = {"br.com.integration"})
@EnableTransactionManagement
public class RepositoryConfig {

}