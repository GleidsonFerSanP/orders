package com.gleidsonfersanp.orders.fixtures

import br.com.six2six.fixturefactory.loader.FixtureFactoryLoader
import org.junit.jupiter.api.extension.BeforeAllCallback
import org.junit.jupiter.api.extension.ExtensionContext

class FixtureExtension: BeforeAllCallback {
    override fun beforeAll(p0: ExtensionContext?) {
        FixtureFactoryLoader.loadTemplates(FixtureExtension::class.java.packageName)
    }
}