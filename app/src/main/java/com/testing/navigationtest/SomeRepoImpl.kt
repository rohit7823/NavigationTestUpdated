package com.testing.navigationtest

import javax.inject.Inject

class SomeRepoImpl @Inject constructor(

): SomeRepo {
    override suspend fun getSomeData(): List<String> {
        return listOf("1232")
    }
}