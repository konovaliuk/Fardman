package com.iasa.repairagency.repository;

import com.iasa.repairagency.model.Request;
import com.iasa.repairagency.model.User;
import org.apache.catalina.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RequestRepository extends JpaRepository<Request, Long> {

    List<Request> getAllByManager(User manager);
    List<Request> getAllByClient(User client);
}
