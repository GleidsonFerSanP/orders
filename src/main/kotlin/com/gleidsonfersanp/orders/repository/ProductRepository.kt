package com.gleidsonfersanp.orders.repository

import com.gleidsonfersanp.orders.domain.ProductEntity
import java.util.UUID
import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<ProductEntity, UUID> {

}