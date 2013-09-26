package org.zed.coding.service.jpa.impl;

import org.resthub.common.service.CrudServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.zed.coding.model.User;
import org.zed.coding.repository.jpa.IUserRepository;
import org.zed.coding.service.jpa.IUserService;

import javax.inject.Inject;
import javax.inject.Named;

@Transactional
@Named("userService")
public class UserService extends CrudServiceImpl<User, Integer, IUserRepository> implements IUserService {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Override
    @Inject
    public void setRepository(IUserRepository repository) {
        super.setRepository(repository);
    }

}
