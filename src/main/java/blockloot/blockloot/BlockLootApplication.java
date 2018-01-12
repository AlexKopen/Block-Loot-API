package blockloot.blockloot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlockLootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlockLootApplication.class, args);
	}
}
