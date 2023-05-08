package com.zerobase.api.loan.review

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/fintech/api/v1")
class LoanReviewController (
    private val loanReviewServiceImpl: LoanReviewServiceImpl
        ){

    @GetMapping("review/{userKey}") //유저 키값을 받아와서
    fun getReviewData(
        @PathVariable userKey:String
    ):ResponseEntity<LoanReviewDto.LoanReviewResponseDto>{
        return ResponseEntity.ok(
            loanReviewServiceImpl.loanReviewMain(userKey)//서비스로직을 타서 키값에 해당하는 데이터 가져와서 프론트엔드로 데이터 보내줌
        )
    }
}