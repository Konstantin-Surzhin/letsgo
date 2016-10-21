package org.mitre;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionOutcome;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.SpringBootCondition;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.AbstractJpaVendorAdapter;
import org.springframework.orm.jpa.vendor.EclipseLinkJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.util.ClassUtils;

import org.mitre.EclipseLinkJpaAutoConfiguration.EclipseLinkEntityManagerCondition;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.transaction.jta.JtaTransactionManager;

@Configuration
@ConditionalOnClass({LocalContainerEntityManagerFactoryBean.class,
    EnableTransactionManagement.class, EntityManager.class})
@Conditional(EclipseLinkEntityManagerCondition.class)
@AutoConfigureAfter(DataSourceAutoConfiguration.class)
public class EclipseLinkJpaAutoConfiguration extends JpaBaseConfiguration {

    @Autowired
    private JpaProperties properties;

    @Autowired
    //@PersistenceContext
    private DataSource dataSource;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @Override
    protected AbstractJpaVendorAdapter createJpaVendorAdapter() {
        return new EclipseLinkJpaVendorAdapter();
    }

        
    protected EclipseLinkJpaAutoConfiguration(DataSource dataSource,
            JpaProperties properties,
            ObjectProvider<JtaTransactionManager> jtaTransactionManagerProvider) {
        super(dataSource, properties, jtaTransactionManagerProvider);
    }

    @Override
    protected Map<String, Object> getVendorProperties() {
        Map<String, Object> vendorProperties = new LinkedHashMap<>();
        // TODO why is this named HibernateProperties and not something line AdditionalProperties?
        vendorProperties.putAll(this.properties.getHibernateProperties(this.dataSource));
        return vendorProperties;
    }

    static class EclipseLinkEntityManagerCondition extends SpringBootCondition {

        private static final String[] CLASS_NAMES = {
            "org.eclipse.persistence.jpa.JpaEntityManager"};

        @Override
        public ConditionOutcome getMatchOutcome(ConditionContext context,
                AnnotatedTypeMetadata metadata) {
            for (String className : CLASS_NAMES) {
                if (ClassUtils.isPresent(className, context.getClassLoader())) {
                    return ConditionOutcome.match("found (eclipse) JpaEntityManager class");
                }
            }
            return ConditionOutcome.noMatch("did not find (eclipse) JpaEntityManager class");
        }
    }

}
