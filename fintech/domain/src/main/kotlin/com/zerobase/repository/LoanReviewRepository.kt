package com.zerobase.repository

import com.zerobase.domain.LoanReview
import org.springframework.data.jpa.repository.JpaRepository

interface LoanReviewRepository : JpaRepository<LoanReview, Long>