package com.mainapp.dto;

import com.mainapp.dto.user.AddressDto;
import com.mainapp.dto.user.CompanyDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private Long id;
    private String username;
    private String name;
    private String email;
    private AddressDto address;
    private String phone;
    private String website;
    private CompanyDto company;
    private List<TodoDto> todos;
    private List<PostDto> posts;
}
