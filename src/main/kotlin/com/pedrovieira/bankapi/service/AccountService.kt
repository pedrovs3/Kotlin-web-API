package com.pedrovieira.bankapi.service

import com.pedrovieira.bankapi.model.Account
import java.util.*

interface AccountService {

    fun create (account: Account): Account

    fun getAll() : List<Account>

    fun getById(id:String) : Optional<Account>

    fun update(id: String, account: Account) : Optional<Account>

    fun delete(id: String)
}