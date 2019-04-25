package com.example.demo.dao;

import com.example.demo.entity.TestEntity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.AFTER_TEST_METHOD;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@DataJpaTest
@RunWith(SpringRunner.class)
@Sql(executionPhase = BEFORE_TEST_METHOD, scripts = "classpath:beforeTestDaoITest.sql")
@Sql(executionPhase = AFTER_TEST_METHOD, scripts = "classpath:afterTestDaoITest.sql")
public class TestDaoITest {
  @Autowired
  private TestDao underTest;

  @Test
  public void whenFindOne_givenExistingId_thenId() {
    Optional<TestEntity> result = this.underTest.findById(1L);

    assertEquals(result.get().id, (Long) 1L);
  }
}
