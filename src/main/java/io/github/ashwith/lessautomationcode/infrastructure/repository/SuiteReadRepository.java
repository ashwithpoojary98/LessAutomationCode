package io.github.ashwith.lessautomationcode.infrastructure.repository;

import io.github.ashwith.lessautomationcode.model.Suite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiteReadRepository extends JpaRepository<Suite,Long> {

}
