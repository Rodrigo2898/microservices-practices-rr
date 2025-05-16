package com.ms.rr.message_rabbit.dto;

public record AccountsMsgDto(Long accountNumber,
                             String name,
                             String email,
                             String mobileNumber) {
}
