package com.bright.room.converters

object ConverterRegistry {

    private val converters = mutableListOf<Any>()

    fun register(vararg converter: Any) {
        converters.addAll(converter)
    }

    fun getAll(): List<Any> = converters

    fun clear() {
        converters.clear()
    }
}