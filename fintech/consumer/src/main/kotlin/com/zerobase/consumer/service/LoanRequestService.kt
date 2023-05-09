package com.zerobase.consumer.service

import com.zerobase.consumer.dto.ReviewResponseDto
import com.zerobase.domain.domain.LoanReview
import com.zerobase.domain.repository.LoanReviewRepository
import com.zerobase.kafka.dto.LoanRequestDto
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.stereotype.Service
import java.time.Duration

@Service
class LoanRequestService(
    private val loanReviewRepository: LoanReviewRepository
) {
    companion object{
        const val cssUrl = "http://localhost:9091/css/api/v1/request" //나중에 많아지면 모듈로 따로 빼는게 좋음
    }
    fun loanRequest(loanRequestDto: LoanRequestDto) {
        //TODO : CB Component 로 요청 보내기 -> 응답 값을 DB에 저장하기
        val reviewResult = loanRequestToCb(loanRequestDto) //심사결과

        saveLoanReviewData(reviewResult.toLoanReviewEntity())
    }

    fun loanRequestToCb(loanRequestDto: LoanRequestDto): ReviewResponseDto{
        //TODO
        val restTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build()

        return restTemplate.postForEntity(cssUrl, loanRequestDto, ReviewResponseDto::class.java).body!!
    }

    private fun saveLoanReviewData(loanReview: LoanReview) = loanReviewRepository.save(loanReview)

}