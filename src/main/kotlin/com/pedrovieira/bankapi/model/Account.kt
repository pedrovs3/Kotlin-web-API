package com.pedrovieira.bankapi.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity(name = "accounts")
data class Account(
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    var id: String? = null,
    val name: String,
    val document: String,
    val phone: String
)
