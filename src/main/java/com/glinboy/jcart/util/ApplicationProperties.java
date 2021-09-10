package com.glinboy.jcart.util;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
public final class ApplicationProperties {

	private Security security;
	private Info info;

	@Data
	public static final class Security {

		private Jwt jwt;

		@Data
		public static final class Jwt {

			private String secret;
			private Integer expirationInSecound;
			private String tokenName;

		}
	}

	@Data
	public static final class Info {

		private String name;
		private String description;
		private String version;
		private String license;
		private String licenseUrl;
		private String githubUrl;

	}

}
