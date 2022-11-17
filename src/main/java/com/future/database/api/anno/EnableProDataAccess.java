package com.future.database.api.anno;

import com.future.database.ioc.ProDataAccessConfiguration;
import com.future.database.ioc.ProMapperScannerRegistrar;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * conf data component
 *
 * @author liuyunfei
 */
@SuppressWarnings("unused")
@Target(TYPE)
@Retention(RUNTIME)
@Configuration
@Import({ProMapperScannerRegistrar.class, ProDataAccessConfiguration.class})
public @interface EnableProDataAccess {

    String[] typeHandlerPackages() default {};

    String[] basePackages();

    Class<?>[] basePackageClasses() default {};

    Class<? extends BeanNameGenerator> nameGenerator() default BeanNameGenerator.class;

    Class<? extends Annotation> annotationClass() default Annotation.class;

    Class<?> markerInterface() default Class.class;

    String sqlSessionTemplateRef() default "sqlSessionTemplate";

    String sqlSessionFactoryRef() default "";

    Class<? extends MapperFactoryBean> factoryBean() default MapperFactoryBean.class;

    String lazyInitialization() default "";

    String defaultScope() default AbstractBeanDefinition.SCOPE_DEFAULT;

}
