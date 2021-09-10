package com.glinboy.jcart.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public final class ApplicationProperties {

	private Security security;

	@Data
	public static class Security {

		private Jwt jwt;

		@Data
		public static class Jwt {
			private String secret;
			private Integer expirationInSecound;
			private String tokenName;
		}
	}

}
