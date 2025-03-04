package com.example.mykopring.user.controller

import com.example.mykopring.user.domain.User
import com.example.mykopring.user.service.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<User> {
        return ResponseEntity.ok(userService.get(id))
    }

    @PostMapping
    fun regist(@RequestBody req: registUserReq): ResponseEntity<User> {
        return ResponseEntity.ok(userService.registUser(req.name))
    }
}

data class registUserReq(val name: String) // dto를 간편하게 설정 가능하다.

