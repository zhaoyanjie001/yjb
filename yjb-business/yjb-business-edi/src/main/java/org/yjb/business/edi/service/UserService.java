package org.yjb.business.edi.service;

import org.yjb.business.edi.dto.RequestUserDto;

public interface UserService {
    public String getUserList();
    public String getUserById(RequestUserDto book);
    
}
