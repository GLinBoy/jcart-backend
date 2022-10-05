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

	@Autowired
	private OrderRepositoryApi orderRepository;

	private final Long DEFAULT_ID = 10001L;

	@Test
	void testFindAllByUserId() {
		List<Order> orders = orderRepository.findAllById(List.of(DEFAULT_ID, DEFAULT_ID + 1L));
		assertThat(orders).isNotNull().isNotEmpty().hasSize(2);
		assertThat(orders.stream().map(Order::getId)
				.collect(Collectors.toList()))
			.containsAll(List.of(DEFAULT_ID, DEFAULT_ID + 1L));
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
