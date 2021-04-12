package com.glitchedwise.model.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.glitchedwise.model.entities.User;

@Repository
public interface UserRepository extends CrudRepository <User, Integer>{

}
