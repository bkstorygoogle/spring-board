package com.example.demo.dto;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class UserDTO {

  private int no;
  private String name;
  private String email;
  private String pwd;
  private Boolean gender;
  private Boolean del;
  private String regdate;

}
