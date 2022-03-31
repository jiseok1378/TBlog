package com.test.blog.user.entity;

import com.test.blog.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> { // 제네릭의 첫번째 타입은 Entity, 두번째 타입은 PK 타입

}
