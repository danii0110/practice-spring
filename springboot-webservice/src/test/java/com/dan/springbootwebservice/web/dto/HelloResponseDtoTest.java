package com.dan.springbootwebservice.web.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class HelloResponseDtoTest {
    @Test
    public void 롬복_기능_테스트() {
        //given //테스트를 위해 준비를 하는 과정
        String name = "test";
        int amount = 1000;

        //when //실제로 액션을 하는 테스트를 실행하는 과정
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then //테스트를 검증하는 과정, 예상한 값, 실제 실행을 통해서 나온 값을 검증
        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
    }

}