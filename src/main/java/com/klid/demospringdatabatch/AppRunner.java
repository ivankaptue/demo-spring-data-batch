package com.klid.demospringdatabatch;

import com.github.javafaker.Faker;
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

  @Override
  public void run(ApplicationArguments args) {
    customerRepository.saveAll(createdCustomers(10));
    customerRepository.saveAll(createdCustomers(15));
  }

  private List<Customer> createdCustomers(int count) {
    return IntStream.range(0, count)
      .mapToObj(index -> Customer.builder().firstName(faker.name().firstName()).lastName(faker.name().lastName()).build())
      .toList();
  }
}
