package com.ace.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

/**
 * @author: ACE.CHIU
 * @create: 2021-02-22
 */
@NoRepositoryBean
public interface BasicJpaRepository<T> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {
  Optional<T> findByUuid(String uuid);
}
