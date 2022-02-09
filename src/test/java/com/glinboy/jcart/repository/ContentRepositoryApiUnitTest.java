package com.glinboy.jcart.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.glinboy.jcart.model.Content;

@DataJpaTest
class ContentRepositoryApiUnitTest {

	@Autowired
	private ContentRepositoryApi contentRepository;

	private final String DEFAULT_TITLE = "test";

	@Test
	void testFindByTitle() {
		Optional<Content> optional = contentRepository.findByTitle(DEFAULT_TITLE);
		assertEquals(Boolean.TRUE, optional.isPresent());
		assertThat(optional.get().getTitle()).isNotEmpty().isEqualTo(DEFAULT_TITLE);
	}

}
