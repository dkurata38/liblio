package com.github.dkurata38.liblio.infrastructure;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
@MapperScan(basePackages = {"com.github.dkurata38.liblio.infrastructure"})
public class InfrastructureConfig {
}
