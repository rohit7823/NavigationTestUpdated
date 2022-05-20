package com.testing.navigationtest

interface SomeRepo {
    suspend fun getSomeData(): List<String>
}