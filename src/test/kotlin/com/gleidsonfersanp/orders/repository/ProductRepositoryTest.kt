package com.gleidsonfersanp.orders.repository

import com.gleidsonfersanp.orders.domain.ProductEntity
import com.gleidsonfersanp.orders.fixtures.FixtureExtension
import com.gleidsonfersanp.orders.fixtures.build
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@ExtendWith(FixtureExtension::class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Testcontainers
@ActiveProfiles("test")
class ProductRepositoryTest {

    @Autowired
    private lateinit var productRepository: ProductRepository

    companion object {
        @Container
        var postgres: PostgreSQLContainer<*> = PostgreSQLContainer("postgres").apply {
            withDatabaseName("orders")
            withUsername("test")
            withUsername("test")
            start()
        }
        @DynamicPropertySource
        @JvmStatic
        fun registerDatabaseProperties(registry: DynamicPropertyRegistry) {
            registry.add("spring.datasource.url", postgres::getJdbcUrl)
            registry.add("spring.datasource.username", postgres::getUsername)
            registry.add("spring.datasource.password", postgres::getPassword)
        }
    }

    @Test
    fun `save product`() {
        val productEntity: ProductEntity = build()
        productRepository.save(productEntity)
        productRepository.findAll().let { Assertions.assertEquals(1, it.size) }
    }
}