package com.ace.repository;

import com.ace.entity.UserProfile;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author: ACE.CHIU
 * @create: 2022-09-25
 */
@Repository
public interface UserProfileRepository extends BasicJpaRepository<UserProfile> {
  Optional<UserProfile> findByUsername(String username);
  Optional<UserProfile> findByEmail(String email);
  Optional<UserProfile> findByGoogleId(String googleId);
}
