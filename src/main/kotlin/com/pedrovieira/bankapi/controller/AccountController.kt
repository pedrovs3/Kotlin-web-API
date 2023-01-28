package com.pedrovieira.bankapi.controller

import com.pedrovieira.bankapi.model.Account
import com.pedrovieira.bankapi.service.AccountService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/accounts")
class AccountController (private val service: AccountService) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create (@RequestBody account: Account) = service.create(account)

    @GetMapping
    fun getAll() : List<Account> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id:String) : ResponseEntity<Account> =
        service.getById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @PutMapping("/{id}")
    fun update(@PathVariable id: String, @RequestBody account: Account) : ResponseEntity<Account> =
        service.update(id, account).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: String) : ResponseEntity<Void>  {
        service.delete(id)
        return ResponseEntity<Void>(HttpStatus.OK)
    }
}