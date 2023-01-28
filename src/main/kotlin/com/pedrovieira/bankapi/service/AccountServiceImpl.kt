package com.pedrovieira.bankapi.service

import com.pedrovieira.bankapi.model.Account
import com.pedrovieira.bankapi.repository.AccountRepository
import org.springframework.stereotype.Service
import java.util.*
import org.springframework.util.Assert

@Service
class AccountServiceImpl(private val repository: AccountRepository) : AccountService {
    override fun create(account: Account): Account {
        Assert.hasLength(account.name, "[name] nao pode estar em branco!!")
        return repository.save(account)
    }

    override fun getAll(): List<Account> {
        return repository.findAll()
    }

    override fun getById(id: String): Optional<Account> {
        return repository.findById(id)
    }

    override fun update(id: String, account: Account): Optional<Account> {
        val optional = getById(id)
        if (optional.isEmpty) Optional.empty<Account>()

        return optional.map {
            val accountToUpdate = it.copy(
                name = account.name,
                document = account.document,
                phone = account.phone
            )
            repository.save(accountToUpdate)
        }
    }

    override fun delete(id: String) {
        repository.findById(id).map {
            repository.delete(it)
        }.orElseThrow { throw RuntimeException("Id not founded")}
    }
}