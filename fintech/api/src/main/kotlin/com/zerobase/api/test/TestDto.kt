package com.zerobase.api.test

class TestDto {
    data class UserInfoDto(
        val userKey: String,
        val userRegistrationNumber: String,
        val userName: String,
        val userIncomeAmount: Long // Long 타입으로 수정
    )
}
