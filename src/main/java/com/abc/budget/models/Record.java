package com.abc.budget.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Component;


    @Entity
    @Component
    @Table
    public class Record implements Serializable {
       
    	@Id
    	@GenericGenerator(name = "test_sequence1", strategy = "com.abc.budget.models.idGenerator")
    	@GeneratedValue(generator = "test_sequence1")
        String recordId;
    	String userId="abcd1234";
    	String year;
    	String month;
    	String date;
    	int amount;
    	String need;
    	
		public String getRecordId() {
			return recordId;
		}
		public void setRecordId(String recordId) {
			this.recordId = recordId;
		}
		public String getUserId() {
			return userId;
		}
		public void setUserId(String userId) {
			this.userId = userId;
		}
		public String getYear() {
			return year;
		}
		public void setYear(String year) {
			this.year = year;
		}
		public String getMonth() {
			return month;
		}
		public void setMonth(String month) {
			this.month = month;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public String getNeed() {
			return need;
		}
		public void setNeed(String need) {
			this.need = need;
		}
		@Override
		public String toString() {
			return "Record [recordId=" + recordId + ", userId=" + userId + ", year=" + year + ", month=" + month
					+ ", date=" + date + ", amount=" + amount + ", need=" + need + "]";
		}
    	
    	
    	
}

