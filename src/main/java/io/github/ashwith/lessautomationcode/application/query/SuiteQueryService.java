package io.github.ashwith.lessautomationcode.application.query;

import io.github.ashwith.lessautomationcode.infrastructure.repository.SuiteReadRepository;
import io.github.ashwith.lessautomationcode.model.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SuiteQueryService {

    @Autowired
    private SuiteReadRepository suiteReadRepository;

    public Suite getSuiteById(long id){
        return suiteReadRepository.findById(id).orElse(null);
    }

    public List<Suite> getAllSuite(){
        return suiteReadRepository.findAll();

    }
}
