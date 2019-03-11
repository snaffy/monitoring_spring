package pl.ki.wex.monitoring;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.ki.wex.monitoring.dao.HttpTraceRepository;

@ComponentScan
@EnableAutoConfiguration
@EnableAdminServer
@EnableJpaRepositories(basePackageClasses = HttpTraceRepository.class)
public class MonitoringApplication {
    public static void main(String[] args) {
        SpringApplication.run(MonitoringApplication.class, args);
    }
}

