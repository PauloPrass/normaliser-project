package com.backend.normaliser.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.backend.normaliser.model.Job;

@Component
public class JobRepository {

	private Map<Long, Job> map = new HashMap<>();
	
	public Job save(Job job) {
		map.put(job.getId(), job);
		return job;
	}
	
	public Job findById(Long id) {
		return map.get(id);
	}
	
	public List<Job> findAll() {
		return new ArrayList<Job>(map.values());
	}
}
