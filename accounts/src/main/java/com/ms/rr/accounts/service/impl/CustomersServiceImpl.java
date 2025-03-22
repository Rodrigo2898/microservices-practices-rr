package com.ms.rr.accounts.service.impl;

import com.ms.rr.accounts.dto.AccountDto;
import com.ms.rr.accounts.dto.CardsDto;
import com.ms.rr.accounts.dto.CustomerDetailsDto;
import com.ms.rr.accounts.dto.LoansDto;
import com.ms.rr.accounts.entity.Account;
import com.ms.rr.accounts.entity.Customer;
import com.ms.rr.accounts.exception.ResourceNotFoundException;
import com.ms.rr.accounts.mapper.AccountMapper;
import com.ms.rr.accounts.mapper.CustomerMapper;
import com.ms.rr.accounts.repository.AccountRepository;
import com.ms.rr.accounts.repository.CustomerRepository;
import com.ms.rr.accounts.service.ICustomersService;
import com.ms.rr.accounts.service.client.CardsFeignClient;
import com.ms.rr.accounts.service.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomersServiceImpl implements ICustomersService {

    private AccountRepository accountsRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input Mobile Number
     * @return Customer Details based on a given mobileNumber
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber, String correlationId) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
        );
        Account accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString())
        );

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer, new CustomerDetailsDto());
        customerDetailsDto.setAccountsDto(AccountMapper.mapToAccountsDto(accounts, new AccountDto()));

        ResponseEntity<LoansDto> loansDtoResponseEntity = loansFeignClient.fetchLoanDetails(correlationId, mobileNumber);
        customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());

        ResponseEntity<CardsDto> cardsDtoResponseEntity = cardsFeignClient.fetchCardDetails(correlationId, mobileNumber);
        customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());

        return customerDetailsDto;

    }
}