package com.glinboy.jcart.repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.glinboy.jcart.model.Order;

@DataJpaTest
class OrderRepositoryApiUnitTest {

	@Test
	void testFindAllByUserId() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByUserIdAndId() {
		fail("Not yet implemented");
	}

	@Test
	void testFindByUserIdAndStatus() {
		fail("Not yet implemented");
	}

}
