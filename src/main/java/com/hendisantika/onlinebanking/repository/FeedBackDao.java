package com.hendisantika.onlinebanking.repository;

import com.hendisantika.onlinebanking.entity.Feedback;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedBackDao extends CrudRepository<Feedback, Long> {
    List<Feedback> findAll();
}
