package com.zerobase.api.test

import com.zerobase.domain.domain.UserInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.v3.oas.annotations.Parameter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
@Api(description = "테스트용")
class TestController(
    private val testService: TestService
) {
    @ApiOperation(value = "테스트용 컨트롤러", notes = "테스트를 하며 사용한 컨트롤러")
    @GetMapping("/test/get/{userKey}")
    fun test(
        @Parameter(description = "유저 키값")
        @PathVariable userKey: String
    ): TestDto.UserInfoDto = testService.testGetService(userKey)
}