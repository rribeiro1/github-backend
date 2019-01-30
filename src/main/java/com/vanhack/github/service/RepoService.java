package com.vanhack.github.service;

import com.vanhack.github.domain.Repo;
import com.vanhack.github.repository.RepoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoService {

    private RepoRepository repoRepository;

    @Autowired
    public RepoService(RepoRepository repoRepository) {
        this.repoRepository = repoRepository;
    }

    public Repo save(Repo repo) {
        return repoRepository.save(repo);
    }
}
