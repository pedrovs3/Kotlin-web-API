package com.pedrovieira.bankapi

import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {
}