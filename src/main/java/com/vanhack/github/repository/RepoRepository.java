package com.vanhack.github.repository;

import com.vanhack.github.domain.Repo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepoRepository extends JpaRepository<Repo, Long> {

}

