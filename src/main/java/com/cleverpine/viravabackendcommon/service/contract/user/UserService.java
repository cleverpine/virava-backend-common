package com.cleverpine.viravabackendcommon.service.contract.user;

import com.cleverpine.viravabackendcommon.dto.User;

public interface UserService {

    User getUser(String username);
}
