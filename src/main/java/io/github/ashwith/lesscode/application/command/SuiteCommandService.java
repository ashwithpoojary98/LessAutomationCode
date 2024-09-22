package io.github.ashwith.lesscode.application.command;

import io.github.ashwith.lesscode.api.dto.SuiteDTO;
import io.github.ashwith.lesscode.infrastructure.repository.SuiteWriteRepository;
import io.github.ashwith.lesscode.model.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SuiteCommandService {

    @Autowired
    private SuiteWriteRepository suiteWriteRepository;

    public SuiteDTO createSuite(SuiteDTO suiteDTO){
        Suite suite=new Suite();
        suite.setName(suiteDTO.getName());
        suiteWriteRepository.save(suite);
        return suiteDTO;
    }
}
