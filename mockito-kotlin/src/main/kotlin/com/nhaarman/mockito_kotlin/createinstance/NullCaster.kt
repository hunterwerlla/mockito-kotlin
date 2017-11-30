package com.nhaarman.mockito_kotlin.createinstance

import kotlin.reflect.KClass

/**
 * Uses a quirk in the bytecode generated by Kotlin
 * to cast [null] to a non-null type.
 *
 * See https://youtrack.jetbrains.com/issue/KT-8135.
 */
internal class NullCaster : NonNullProvider {

    override fun <T : Any> createInstance(kClass: KClass<T>): T {
        return castNull()
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> castNull(): T = null as T
}