package com.gleidsonfersanp.orders.fixtures

import br.com.six2six.fixturefactory.Fixture
import br.com.six2six.fixturefactory.Rule
import br.com.six2six.fixturefactory.loader.TemplateLoader
import com.github.javafaker.Faker
import com.gleidsonfersanp.orders.domain.ProductEntity
import java.math.BigDecimal
import java.time.LocalDateTime
import java.util.Locale

class ProductTemplate : TemplateLoader {
    override fun load() {
        val ptFaker = Faker(Locale("pt-BR"))
        Fixture.of(ProductEntity::class.java).addTemplate("default", object : Rule() {
            init {
                add("sku", regex("[a-zA-Z]{3}\\-[0-9]"))
                add("name", ptFaker.name().name())
                add("description", ptFaker.lorem().characters(50, 100))
                add("price", random(BigDecimal.TEN, BigDecimal.valueOf(1.99), BigDecimal.valueOf(199), BigDecimal.valueOf(20.0)))
                add("createdAt", LocalDateTime.now())
                add("updatedAt", LocalDateTime.now())
            }
        })

    }

}