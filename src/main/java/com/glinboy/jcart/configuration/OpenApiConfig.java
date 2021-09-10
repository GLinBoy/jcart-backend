package com.glinboy.jcart.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.glinboy.jcart.util.ApplicationProperties;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
@SecurityScheme(name = "bearerAuth",
	type = SecuritySchemeType.HTTP,
	bearerFormat = "JWT",
	scheme = "bearer")
public class OpenApiConfig {

	private final ApplicationProperties properties;

	@Bean
	public OpenAPI springShopOpenAPI() {
		return new OpenAPI()
				.info(new Info()
						.title(properties.getInfo().getName())
						.description(properties.getInfo().getDescription())
						.version(properties.getInfo().getVersion())
						.license(new License().name(properties.getInfo().getLicense())
								.url(properties.getInfo().getLicenseUrl())))
				.externalDocs(new ExternalDocumentation().description("Source code")
						.url(properties.getInfo().getGithubUrl()));
	}
}
