package com.subscription.main;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.subscription.main.Subscription;

public interface SubscriptionRepository extends MongoRepository<Subscription,String>{
}




