package com.klid.demospringdatabatch;

import com.github.javafaker.Faker;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Slf4j
@RequiredArgsConstructor
@Component
public class AppRunner implements ApplicationRunner {

  private static final Faker faker = new Faker();

  private final CustomerRepository customerRepository;

  @Transactional
  @Override
  public void run(ApplicationArguments args) {
    for (int i = 0; i < 1000; i++) {
      customerRepository.saveAllAndFlush(createdCustomers(500));
    }
  }

  private List<Customer> createdCustomers(int count) {
    return IntStream.range(0, count)
      .mapToObj(index -> Customer.builder().firstName(faker.name().firstName()).lastName(faker.name().lastName()).build())
      .toList();
  }
}
