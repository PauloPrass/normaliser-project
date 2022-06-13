package com.backend.normaliser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.backend.normaliser.model.Job;
import com.backend.normaliser.repository.JobRepository;

@SpringBootApplication
public class NormaliserProjectApplication implements CommandLineRunner{
	
	@Autowired
	private JobRepository jobRepository;

	public static void main(String[] args) {
		SpringApplication.run(NormaliserProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Job java = new Job(1L, "Java engineer", "Develop and maintain Java code");
		Job csharp = new Job(2L, "C# engineer", "Develop and maintain C# code");
		Job chief = new Job(3L, "Chief Accountant", "Do the accounting");
		jobRepository.save(java);
		jobRepository.save(csharp);
		jobRepository.save(chief);
	}

}