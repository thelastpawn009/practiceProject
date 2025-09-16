package com.example.demo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praveen J U
 * @Date 16/09/25
 */
@Repository
public interface TestEntityRepository extends JpaRepository<TestEntity, Long> {
    List<TestEntity> findAll();
}
