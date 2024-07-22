package com.ace.criteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

/**
 * @author: ACE.CHIU
 * @create: 2021-02-22
 */
public interface PreCriteriaBuilder {
  Predicate preBuild(Predicate predicate, CriteriaQuery query, CriteriaBuilder builder, Root root);
}

