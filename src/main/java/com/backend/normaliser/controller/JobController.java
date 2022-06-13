package com.backend.normaliser.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.backend.normaliser.model.Job;
import com.backend.normaliser.model.Normaliser;
import com.backend.normaliser.repository.JobRepository;

@RestController
public class JobController {
	
	@Autowired
	private JobRepository jobRepository;
	
	@GetMapping("/normalise")
	public String normalise(@RequestParam(value = "title") String title) {
		Normaliser norm = new Normaliser();
        return String.format("%s", norm.normalise(title));
    }
	
	@GetMapping("/normalise-score")
	public Map<String, Double> normalise2(@RequestParam(value = "title") String title) {
		Normaliser norm = new Normaliser();
        return norm.normaliseScore(title);
    }
	
	@GetMapping("/normalise/{id}")
	public String normaliseJob(@PathVariable Long id) {
		Normaliser norm = new Normaliser();
		Job job = jobRepository.findById(id);
        return String.format("%s", norm.normalise(job.getTitle()));
    }
	
	@GetMapping("/jobs")
	public List<Job> findAdll() {
		return jobRepository.findAll();
	}
	
	@GetMapping("/jobs/{id}")
	public Job findJobById(@PathVariable Long id) {
		return jobRepository.findById(id);
	}
	
	@PostMapping("/jobs")
	public Job createJob(@PathVariable Job job) {
		return jobRepository.save(job);
	}
}
