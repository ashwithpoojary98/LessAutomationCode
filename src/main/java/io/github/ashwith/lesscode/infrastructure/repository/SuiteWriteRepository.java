package io.github.ashwith.lesscode.infrastructure.repository;

import io.github.ashwith.lesscode.model.Suite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuiteWriteRepository extends JpaRepository<Suite, Long> {


}
