package com.ecates.bookapi.repository;

import com.ecates.bookapi.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
