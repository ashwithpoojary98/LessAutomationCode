package io.github.ashwith.lesscode.application.query;

import io.github.ashwith.lesscode.infrastructure.repository.SuiteReadRepository;
import io.github.ashwith.lesscode.model.Suite;
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
