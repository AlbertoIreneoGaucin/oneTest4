package com.tfs.oneTest4.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

//@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Role {
    @Id
   // @GeneratedValue(strategy = AUTO)
    private Long id;
    private String name;



}
