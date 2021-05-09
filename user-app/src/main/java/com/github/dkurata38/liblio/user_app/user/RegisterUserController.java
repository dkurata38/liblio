package com.github.dkurata38.liblio.user_app.user;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.github.dkurata38.liblio.application.user.UserRegistrationService;
import com.github.dkurata38.liblio.domain.user.MailAddress;
import com.github.dkurata38.liblio.domain.user.Password;
import com.github.dkurata38.liblio.domain.user.Username;

@RequiredArgsConstructor
@SessionAttributes(types = {RegistrationForm.class})
@Controller
public class RegisterUserController {
	private final UserRegistrationService userRegistrationService;
	private final AuthenticationManager authenticationManager;
	private final PasswordEncoder passwordEncoder;
	@ModelAttribute
	public RegistrationForm registrationForm() {
		return new RegistrationForm();
	}

	@GetMapping("register")
	public String viewRegistrationForm(
			@ModelAttribute RegistrationForm registrationForm,
			Model model
	) {
		Object errors = model.getAttribute("errors");
		if (errors != null) {
			BindingResult bindingResult = (BindingResult) errors;
			model.addAttribute(BindingResult.MODEL_KEY_PREFIX + bindingResult.getObjectName(), bindingResult);
		}
		return "user/register";
	}

	@PostMapping("register")
	public String register(
			@ModelAttribute RegistrationForm registrationForm,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes,
			SessionStatus sessionStatus
	) {
		if (bindingResult.hasErrors()) {
			redirectAttributes.addFlashAttribute("errors", bindingResult);
			return "redirect:/register";
		}

		userRegistrationService.register(
				new Username(registrationForm.getUsername()),
				new Password(passwordEncoder.encode(registrationForm.getPassword())),
				new MailAddress(registrationForm.getMailAddress())
		);
		sessionStatus.setComplete();
		UsernamePasswordAuthenticationToken token =
				new UsernamePasswordAuthenticationToken(registrationForm.getUsername(), registrationForm.getPassword());
		Authentication authResult = authenticationManager.authenticate(token);
		SecurityContextHolder.getContext().setAuthentication(authResult);
		return "redirect:/";
	}
}

@Data
class RegistrationForm {
	String username;
	String password;
	String mailAddress;
}
