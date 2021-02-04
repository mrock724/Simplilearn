package com.hcl.userinfo.update;

import org.springframework.data.repository.CrudRepository;

public interface UserEntityRepo extends CrudRepository<UserEntity, Long> {
}
