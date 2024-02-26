package ch.swiftsend.config;

import ch.swiftsend.model.Role;
import ch.swiftsend.model.User;
import ch.swiftsend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@Component
public class Stratup implements CommandLineRunner {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;

	private void saveAll() {

		User user = User.builder().email("user@swiftsend.ch").role(Role.USER).password(passwordEncoder.encode("123456")).mfaEnabled(false).build();
		User admin = User.builder().email("admin@swiftsend.ch").role(Role.ADMIN).password(passwordEncoder.encode("123456")).mfaEnabled(false).build();
		User transporteur = User.builder().email("manager@swiftsend.ch").role(Role.TRANSPORTEUR).password(passwordEncoder.encode("123456")).mfaEnabled(false).build();
		userRepository.saveAll(Arrays.asList(user, admin, transporteur));
	}


	@Override
	public void run(String... args) {
		saveAll();
	}
}
