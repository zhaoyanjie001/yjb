package org.yjb.business.login.service;

import org.yjb.business.login.dto.RequestUserDto;

public interface BooksService {
    public String getBooksList();
    public String getBookById( RequestUserDto user);
    
}
