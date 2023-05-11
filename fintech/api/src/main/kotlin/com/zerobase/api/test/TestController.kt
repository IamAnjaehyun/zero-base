package com.zerobase.api.test

import com.zerobase.domain.domain.UserInfo
import io.swagger.annotations.ApiOperation
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class TestController(
    private val testService: TestService
) {
    @ApiOperation(value = "테스트용 컨트롤러")
    @GetMapping("/test/get/{userKey}")
    fun test(
        @PathVariable userKey: String
    ): TestDto.UserInfoDto = testService.testGetService(userKey)
}