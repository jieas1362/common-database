package com.future.database.api.anno;

import com.future.database.ioc.ProTransactionConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * enable trans
 *
 * @author liuyunfei
 */
@Target(TYPE)
@Retention(RUNTIME)
@Configuration
@Import(ProTransactionConfiguration.class)
public @interface EnableProTransaction {
}
