package com.gleidsonfersanp.orders.repository

import com.gleidsonfersanp.orders.domain.OrderEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrdersRepository : JpaRepository<OrderEntity, UUID>