package org.zed.coding.repository.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zed.coding.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}
