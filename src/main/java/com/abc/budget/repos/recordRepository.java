package com.abc.budget.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abc.budget.models.Record;
import com.abc.budget.models.RecordProjector;
import com.abc.budget.models.ResponseModel;

@Repository
public
interface recordRepository extends JpaRepository<Record, String> {
	List<Record> findLast30ByUserId(String userId);
	
	
	@Query(value="SELECT year AS key, SUM(amount) as amount  FROM (select year ,amount from Record where user_id=:userId) as req1 group by year",nativeQuery=true)
	List<ResponseModel> getRecordsOfYear(@Param("userId")String userId);
	
	@Query(value="select month as key ,sum(amount) as amount from (select month,amount from Record where year=:year and user_id=:userId) as req group by month;",nativeQuery=true)
	List<ResponseModel> getRecordsOfMonth(@Param("userId")String userId,@Param("year") String year);
	
	@Query(value="select date as key,sum(amount) as amount from (select date,amount from Record where year=:year and month=:month and user_id=:userId) as req group by date;",nativeQuery=true)
	List<ResponseModel> getRecordsOfDate(@Param("userId")String userId,@Param("year") String year,@Param("month") String month);
	
	@Query(value="select need as need,amount as amount,record_id as recordId from Record where year=:year and month=:month and date=:date and user_id=:userId",nativeQuery=true)
	List<RecordProjector> getSepecificRecord(@Param("userId")String userId,@Param("year") String year,@Param("month") String month,@Param("date")String date);
	
//	@Modifying
//	@Query("delete from ScheduleModel s where s.scheduleId=:scheduleId")
//	void deleteByScheduleId(@Param("scheduleId")String id);
	
}



