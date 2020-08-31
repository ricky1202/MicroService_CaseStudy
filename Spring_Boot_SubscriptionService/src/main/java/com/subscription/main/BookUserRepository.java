package com.subscription.main;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.subscription.main.BookUser;

public interface BookUserRepository extends MongoRepository<BookUser,String>{
}
