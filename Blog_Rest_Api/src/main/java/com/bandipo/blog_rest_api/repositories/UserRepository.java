package com.bandipo.blog_rest_api.repositories;

import com.bandipo.blog_rest_api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.xml.transform.sax.SAXTransformerFactory;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findUsersByEmail(String email);

}
