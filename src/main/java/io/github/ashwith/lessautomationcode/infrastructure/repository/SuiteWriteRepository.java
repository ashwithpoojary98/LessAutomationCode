package io.github.ashwith.lessautomationcode.infrastructure.repository;

import io.github.ashwith.lessautomationcode.model.Suite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiteWriteRepository extends JpaRepository<Suite, Long> {


}
