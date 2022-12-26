package com.digital.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.digital.user.entity.SubscriptionEntity;

@Repository
public interface SubscriptionRepository extends CrudRepository<SubscriptionEntity, Integer>{

}
