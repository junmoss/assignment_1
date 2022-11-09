package com.service.order.config.http;

import com.service.order.config.yaml.YamlPropertySourceFactory;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ConfigurationProperties(prefix = "yaml")
@PropertySource(value = "classpath:application-util.yml", factory = YamlPropertySourceFactory.class)
@Data
@Builder
public class HttpConfig {
    @Value("${PRODUCT_SERVER_IP}")
    private final String address;

    @Value("${PRODUCT_SERVER_PORT}")
    private final int port;

    @Value("${READ_TIME_OUT}")
    private final int readTimeOut;

    @Value("${CONN_TIME_OUT}")
    private final int connTimeOut;

    @Value("${MAX_CONN_TOTAL}")
    private final int maxConnTotal;

    @Value("${MAX_CONN_PER_ROUTE}")
    private final int maxConnPerRoute;
}
