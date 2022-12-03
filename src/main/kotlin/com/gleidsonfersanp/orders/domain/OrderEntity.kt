package com.gleidsonfersanp.orders.domain

import com.gleidsonfersanp.orders.utils.NoArg
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.UUID


@Entity
@Table(name = "customer_order")
@NoArg
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    @OneToMany
    val items: List<ProductEntity> = arrayListOf()
) {
    val total: () -> BigDecimal
        get() = {
            this.items.map { it.price }.fold(BigDecimal.ZERO) { acc, actual -> acc + actual }
        }

    val createdAt: LocalDateTime?
        get() {  return this.createdAt?: LocalDateTime.now() }

    val updatedAt: LocalDateTime = LocalDateTime.now()
}