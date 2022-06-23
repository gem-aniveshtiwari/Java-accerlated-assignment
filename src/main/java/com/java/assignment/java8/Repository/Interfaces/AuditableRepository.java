package com.java.assignment.java8.Repository.Interfaces;

import com.java.assignment.java8.Model.AuditTable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditableRepository extends JpaRepository<AuditTable, Integer> {
}
