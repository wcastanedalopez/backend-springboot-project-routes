package com.bezkoder.springjwt.services;


import com.bezkoder.springjwt.models.ERole;
import com.bezkoder.springjwt.models.Role;

import java.util.Optional;

public interface IRoleService {
    Role findByName(ERole name);
}