package com.ace.service;

import com.ace.dto.UserProfileDto;
import com.ace.entity.UserProfile;
import com.ace.exception.BusinessException;
import com.ace.repository.BasicJpaRepository;
import com.ace.repository.UserProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author: ACE.CHIU
 * @create: 2021-02-22
 */
//@Slf4j
@Service
public class UserProfileService extends BasicService<UserProfile> {

  @Autowired
  private UserProfileRepository repository;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public UserProfile create(UserProfileDto dto) {
    UserProfile userProfile = new UserProfile();
    userProfile.setUsername(dto.getUsername());
    userProfile.setPassword(passwordEncoder.encode(dto.getPassword()));
    userProfile.setEmail(dto.getEmail());
    userProfile.setGoogleId(dto.getGoogleId());
    userProfile.setFamilyName(dto.getFamilyName());
    userProfile.setGivenName(dto.getGivenName());
    userProfile.setName(dto.getName());
    return repository.save(userProfile);
  }
  
  public UserProfile update(UserProfileDto userProfileDto) {
    UserProfile userProfile = repository.findById(userProfileDto.getId()).orElseThrow();
    userProfile.setBirthday(userProfileDto.getBirthday());
    userProfile.setAddress(userProfileDto.getAddress());
    userProfile.setPhone(userProfileDto.getPhone());
    return repository.save(userProfile);
  }

  public UserProfile findByEmail(String email) {
    return repository.findByEmail(email).orElse(null);
  }

  public UserProfile findByUsername(String username) {
    return repository.findByUsername(username).orElse(null);
  }
  @Override
  public BasicJpaRepository<UserProfile> getRepository() {
    return repository;
  }
}
