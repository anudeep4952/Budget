package com.abc.budget.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.abc.budget.models.Record;

@Repository
public
interface recordRepository extends JpaRepository<Record, String> {
	List<Record> findLast30ByUserId(String userId);
}
