package com.backend.normaliser;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.backend.normaliser.model.Job;
import com.backend.normaliser.model.Normaliser;
import com.backend.normaliser.repository.JobRepository;

@SpringBootTest
class NormaliserProjectApplicationTests {

	@Autowired
	private JobRepository jobRepository;
	
	@Test
	public void createShouldPersistData() {
		Job react = new Job(10L, "React Engineer", "Frontend developer");
		this.jobRepository.save(react);
		assertThat(react.getId()).isNotNull();
		assertThat(react.getTitle()).isEqualTo("React Engineer");
		assertThat(react.getDescription()).isEqualTo("Frontend developer");
	}
	
	@Test
	public void shouldNormaliseJobTitleJava() {
		Job java = new Job(1L, "Java engineer", "Develop and maintain Java code");
		this.jobRepository.save(java);
		Normaliser norm = new Normaliser();
		assertThat(norm.normalise(java.getTitle())).isEqualTo("Software engineer");
	}
	
	@Test
	public void shouldNormaliseJobTitleCSharp() {
		Job csharp = new Job(2L, "C# engineer", "Develop and maintain C# code");
		this.jobRepository.save(csharp);
		Normaliser norm = new Normaliser();
		assertThat(norm.normalise(csharp.getTitle())).isEqualTo("Software engineer");
	}
	
	@Test
	public void shouldNormaliseJobTitleAccountant() {
		Job chief = new Job(3L, "Chief Accountant", "Do the accounting");
		this.jobRepository.save(chief);
		Normaliser norm = new Normaliser();
		assertThat(norm.normalise(chief.getTitle())).isEqualTo("Accountant");
	}
}
