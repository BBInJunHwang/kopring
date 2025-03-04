//package com.example.mykopring.user.controller
//
//import com.example.mykopring.user.domain.User
//import com.example.mykopring.user.service.UserService
//import com.fasterxml.jackson.databind.ObjectMapper
//import io.mockk.MockKAnnotations
//import io.mockk.every
//import io.mockk.impl.annotations.MockK
//import io.mockk.junit5.MockKExtension
//import io.mockk.mockk
//import org.junit.jupiter.api.BeforeEach
//import org.junit.jupiter.api.Test
//import org.junit.jupiter.api.extension.ExtendWith
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.http.MediaType
//import org.springframework.test.context.junit.jupiter.SpringExtension
//import org.springframework.test.web.servlet.MockMvc
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
//import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
//
//@ExtendWith(SpringExtension::class, MockKExtension::class) // Spring과 MockK 확장 등록
//@WebMvcTest(UserController::class) // 컨트롤러 단위 테스트
//class UserControllerTest {
//
//    @Autowired
//    private lateinit var mockMvc: MockMvc // MockMvc 자동 주입
//
//    @Autowired
//    private lateinit var objectMapper: ObjectMapper // ObjectMapper 자동 주입
//
//    @MockK
//    private lateinit var userService: UserService // Mock 서비스 주입
//
//    @BeforeEach
//    fun setup() {
//        MockKAnnotations.init(this)
//        every { userService.registUser("test") } returns User(name = "test")
//        every { userService.get(1L) } returns User(name = "test")
//    }
//
//    @Test
//    fun `사용자를 생성할 수 있다`() {
//        // Given
//        val request = UserRequest("test")
//
//        // When & Then
//        mockMvc.perform(
//            post("/users")
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(request))
//        )
//            .andExpect(status().isOk)
//    }
//
//    @Test
//    fun `사용자를 조회할 수 있다`() {
//        // When & Then
//        mockMvc.perform(
//            get("/users/1") // GET 요청 엔드포인트 확인
//                .contentType(MediaType.APPLICATION_JSON)
//        )
//            .andExpect(status().isOk)
//    }
//
//    @Configuration
//    class MockConfig {
//        @Bean
//        fun userService(): UserService = mockk()
//    }
//}
//
//data class UserRequest(val name: String)