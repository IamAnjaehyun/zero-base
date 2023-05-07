package com.zerobase.repository

import com.zerobase.domain.UserInfo
import org.springframework.data.jpa.repository.JpaRepository

interface UserInfoRepository : JpaRepository<UserInfo, Long>