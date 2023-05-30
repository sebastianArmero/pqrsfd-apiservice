package com.smartcampus.security.repositories;

import java.util.List;

import com.smartcampus.security.models.Authority;

public interface AuthorityJDBCRepository {
  
  public List<Authority> selectByLogin(String login);
  
}
