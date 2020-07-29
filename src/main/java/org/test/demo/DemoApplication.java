package org.test.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.hateoas.server.core.TemplateVariableAwareLinkBuilderSupport;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@CrossOrigin(origins = "*")
@Configuration
@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class DemoApplication {

	@Autowired
	EmployeeRepository emprepository;

	@Autowired
	SongRepository songrepository;

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);

	}

	@PostConstruct
	private void init(){


		RestConfiguration rc = new RestConfiguration();
		rc.corsFilter();


		Employee employee = new Employee();
		employee.setFirstName("Peter");
		employee.setLastName("krooks");
		employee.setTitle("ninja");
		emprepository.save(employee);

		Song song = new Song();

		SongService songService = new SongService();
		song = songService.getNewSong(20);

		songrepository.save(song);

	}

}
