package com.github.dkurata38.liblio.user_app.user

import com.github.dkurata38.liblio.application.user.UserRegistrationService
import com.github.dkurata38.liblio.domain.user.MailAddress
import com.github.dkurata38.liblio.domain.user.Password
import com.github.dkurata38.liblio.domain.user.Username
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.SessionAttributes
import org.springframework.web.bind.support.SessionStatus
import org.springframework.web.servlet.mvc.support.RedirectAttributes

@Controller
@SessionAttributes(types = [RegistrationForm::class])
class RegisterUserController(
    private val userRegistrationService: UserRegistrationService,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManager: AuthenticationManager
    ) {
    @ModelAttribute
    fun registrationForm(): RegistrationForm = RegistrationForm()

    @GetMapping("register")
    fun viewRegistrationForm(
        @ModelAttribute registrationForm: RegistrationForm,
        model: Model
    ): String {
        val errors = model.getAttribute("errors")
        if (errors != null) {
            val bindingResult = errors as BindingResult
            model.addAttribute(BindingResult.MODEL_KEY_PREFIX + bindingResult.objectName, bindingResult)
        }
        return "user/register"
    }

    @PostMapping("register")
    fun register(
        @ModelAttribute registrationForm: RegistrationForm,
        bindingResult: BindingResult,
        redirectAttributes: RedirectAttributes,
        sessionStatus: SessionStatus
    ): String? {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("errors", bindingResult)
            return "redirect:/register"
        }
        userRegistrationService.register(
            Username(registrationForm.username),
            Password(passwordEncoder.encode(registrationForm.password)),
            MailAddress(registrationForm.mailAddress)
        )
        sessionStatus.setComplete()
        val token = UsernamePasswordAuthenticationToken(registrationForm.username, registrationForm.password)
        val authResult: Authentication = authenticationManager.authenticate(token)
        SecurityContextHolder.getContext().authentication = authResult
        return "redirect:/"
    }
}

data class RegistrationForm(
    var username: String = "",
    var password: String = "",
    var mailAddress: String = ""
)
