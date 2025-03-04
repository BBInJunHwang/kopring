package com.example.mykopring.user.repository

import com.example.mykopring.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
}