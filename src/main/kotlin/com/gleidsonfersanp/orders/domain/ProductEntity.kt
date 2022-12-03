package com.gleidsonfersanp.orders.domain

import com.gleidsonfersanp.orders.utils.NoArg
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.*
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate

@Entity
@Table(name = "product")
@NoArg
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: UUID? = null,
    val sku : String,
    val name: String,
    val description: String? = name,
    val price: BigDecimal,
    @get:Column(name = "created_at")
    @get:CreatedDate
    val createdAt: LocalDateTime? = null,
    @get:Column(name = "updated_at")
    @get:LastModifiedDate
    val updatedAt: LocalDateTime? = null
)