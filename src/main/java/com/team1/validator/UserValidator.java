package com.team1.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.team1.entity.User;
@Component
public class UserValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		
		return User.class.equals(arg0);
	}

	public void validate(Object target, Errors erros) {
		User user = (User) target;
		if (user.getEmail() == null || user.getEmail().length() == 0 || user.getEmail().length() <= 4
				|| user.getEmail().length() >= 45) {
			erros.rejectValue("email", "Email.field.required");
		}
		if (user.getPassword() == null || user.getPassword().length() == 0 || user.getPassword().length() <= 4
				|| user.getPassword().length() >= 200) {
			erros.rejectValue("password", "Password.field.required");
		}
		if (user.getMobile() == null || user.getMobile().length() == 0 || user.getMobile().length() <= 4
				|| user.getMobile().length() >= 200) {
			erros.rejectValue("mobile", "Mobile.field.required");
		}
		if (user.getFullName() == null || user.getFullName().length() == 0 || user.getFullName().length() <= 4
				|| user.getPassword().length() >= 200) {
			erros.rejectValue("fullName", "FullName.field.required");
		}
	}
}
