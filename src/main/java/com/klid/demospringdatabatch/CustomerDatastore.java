package com.klid.demospringdatabatch;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Component
public class CustomerDatastore {

  private final CustomerRepository customerRepository;

  public void saveItem(Customer customer) {
    customerRepository.save(customer);
  }

  public void saveItemAndFlush(Customer customer) {
    customerRepository.saveAndFlush(customer);
  }

  public void saveBatch(List<Customer> customers) {
    customerRepository.saveAllAndFlush(customers);
  }
}
