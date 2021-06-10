package com.example.rasm63f424timers.repository;

import com.example.rasm63f424timers.model.Kommune;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KommuneRepo extends CrudRepository<Kommune, Long> {
}
