package com.test.blog.test.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@RequiredArgsConstructor
@Entity
public class Test {
    @Id
    @GeneratedValue
    private int id;
    private String value;
}
