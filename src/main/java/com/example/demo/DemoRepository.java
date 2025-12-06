package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Praveen J U
 * @Date 04/12/25
 */
@Repository
public interface DemoRepository extends JpaRepository<DemoEntity,Integer> {

}
