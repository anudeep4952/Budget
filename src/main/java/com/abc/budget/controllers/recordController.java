package com.abc.budget.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abc.budget.models.Record;
import com.abc.budget.models.RecordProjector;
import com.abc.budget.models.ResponseModel;
import com.abc.budget.repos.recordRepository;

@RestController
public class recordController {

	@Autowired
	recordRepository repo;
	
	@Autowired
	Record rec;
	
	@RequestMapping("/")
	public String first() {
		return "hello world";
	}
	
	
	@PostMapping("/v1/records/")
	public void add(@RequestBody Record record) {
		
		repo.save(record);
		System.out.println(record.toString());
	}
	
	
	@GetMapping("/v1/records")
	public List<Record> getAll() {
		return repo.findLast30ByUserId("abcd1234");
	}
	
	@PutMapping("/v1/records/")
	public void edit(@RequestBody Record record) {
		System.out.println(record.toString());
		repo.save(record);
	}
	
	@DeleteMapping("/v1/records/{recordId}")
	public void delete(@PathVariable("recordId") String recordId) {
		repo.deleteById(recordId);;
	}
	
	@GetMapping("/v1/records/{userid}")
	public List<ResponseModel> getRecordsByYear(@PathVariable("userid")String userid) {
		return repo.getRecordsOfYear(userid);
	}	
	@GetMapping("/v1/records/{userid}/{year}")
		public List<ResponseModel> getRecordsByMonth(@PathVariable("userid")String userid,@PathVariable("year") String year) {
			return repo.getRecordsOfMonth(userid, year);
	}
	@GetMapping("/v1/records/{userid}/{year}/{month}")
	public List<ResponseModel> getRecordsByDate(@PathVariable("userid")String userid,@PathVariable("year") String year,@PathVariable("month") String month) {
		return repo.getRecordsOfDate(userid, year,month);
	}
	@GetMapping("/v1/records/{userid}/{year}/{month}/{date}")
		public List<RecordProjector> getSpecificRecord(@PathVariable("userid")String userid,@PathVariable("year") String year,@PathVariable("month") String month,@PathVariable("date")String date) {
			return repo.getSepecificRecord(userid, year, month, date);
	}
	
	
}

