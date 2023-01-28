package com.pedrovieira.bankapi.repository

import com.pedrovieira.bankapi.model.Account
import org.springframework.data.jpa.repository.JpaRepository

interface AccountRepository : JpaRepository<Account, String> {
}