package com.example.hei.TdProg3Spring.entity;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Student {
    private String reference;
    private String name;
    private String firstName;
    private Integer age;
}
