package com.gleidsonfersanp.orders.fixtures

import br.com.six2six.fixturefactory.Fixture

inline fun <reified T> build(map: Map<String, Any> = mapOf(), label: String = "default"): T {
    return Fixture.from(T::class.java).gimme(label)
}