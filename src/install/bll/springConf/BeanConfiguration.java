package install.bll.springConf;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import java.nio.file.Paths;
import java.util.Properties;

/**
 * @author kevin
 *
 */
@Configuration
@ComponentScan(basePackages = "install.service")
@EnableTransactionManagement()
@EnableJpaRepositories(basePackages = "install.dao")
public class BeanConfiguration {

    /**
     * create parameters to connect to the database
     */
    install.bll.springConf.Configuration conf = new install.bll.springConf.Configuration("sa", " ", "jdbc:h2:file:" + Paths.get(System.getenv("APPDATA"), "certytech", "certyprint", "db") + "/certyprint;CIPHER=AES;AUTO_SERVER=TRUE");

    /**
     * create bean datasource with parameter
     * @return
     */
    @Bean
    public BasicDataSource dataSource() {
        BasicDataSource bean = new BasicDataSource();
        bean.setInitialSize(2);
        bean.setDriverClassName("org.h2.Driver");
        bean.setUrl(conf.getUrl());
        bean.setUsername(conf.getUser());
        bean.setPassword(conf.getPass());
        bean.setMaxTotal(8);
        return bean;
    }

    /**
     * create bean to process annotated bean for the persistence
     * @return
     */
    @Bean
    public PersistenceAnnotationBeanPostProcessor pabpp() {
        PersistenceAnnotationBeanPostProcessor bean = new PersistenceAnnotationBeanPostProcessor();
        return bean;
    }

    /**
     * create bean entitymanagerfactory with datasource
     * @return
     */
    @Bean
    public EntityManagerFactory entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
        bean.setPackagesToScan("install.bo");
        bean.setDataSource(dataSource());
        bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        Properties jpaProperties = new Properties();
        jpaProperties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
        jpaProperties.put("hibernate.dll-auto", "update");
        jpaProperties.put("hibernate.show_sql", true);
        jpaProperties.put("hibernate.format_sql", true);
        jpaProperties.put("hibernate.hbm2ddl.auto", "update");
        jpaProperties.put("hibernate.generateDdl", true);
        jpaProperties.put("database", "H2");
        bean.setJpaProperties(jpaProperties);
        bean.afterPropertiesSet();
        return bean.getObject();
    }

    /**
     * create bean transaction manager
     * @return
     */
    @Bean
    public JpaTransactionManager transactionManager() {
        JpaTransactionManager bean = new JpaTransactionManager();
        bean.setEntityManagerFactory(entityManagerFactory());
        return bean;
    }
}
