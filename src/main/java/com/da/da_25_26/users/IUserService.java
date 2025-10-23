package com.da.da_25_26.users;

import java.util.Optional;

interface IUserService {
  Optional<User> getUserById(long id);
}
