package com.zerobase.api.loan.request

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanRequestController(
    private val loanRequestServiceImpl: LoanRequestServiceImpl
) {
    @ApiOperation(value = "대출 결과 요청", notes = "대출 결과 요청을 하는 API")
    @PostMapping("/request")
    fun loanRequest(
        @RequestBody loanRequestInputDto: LoanRequestDto.LoanRequestInputDto
    ): ResponseEntity<LoanRequestDto.LoanRequestResponseDto> {
        return ResponseEntity.ok(
            loanRequestServiceImpl.loanRequestMain(loanRequestInputDto)
        )
    }
}
