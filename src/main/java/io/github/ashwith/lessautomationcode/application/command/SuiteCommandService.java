package io.github.ashwith.lessautomationcode.application.command;

import io.github.ashwith.lessautomationcode.api.dto.SuiteDTO;
import io.github.ashwith.lessautomationcode.infrastructure.repository.SuiteWriteRepository;
import io.github.ashwith.lessautomationcode.model.Suite;
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
