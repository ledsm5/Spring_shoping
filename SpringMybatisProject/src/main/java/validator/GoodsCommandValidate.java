package validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class GoodsCommandValidate implements Validator{
public boolean supports(Class<?> clazz) {
	// TODO Auto-generated method stub
	return false;
	}
	
	public void validate(Object target, Errors errors) {
			ValidationUtils.rejectIfEmpty(errors, "prodName", "required");
			ValidationUtils.rejectIfEmpty(errors, "prodPrice", "required");
			ValidationUtils.rejectIfEmpty(errors, "prodCapacity", "required");
			ValidationUtils.rejectIfEmpty(errors, "prodSupplyer", "required");
			ValidationUtils.rejectIfEmpty(errors, "prodDelFee", "required");
			ValidationUtils.rejectIfEmpty(errors, "recommand", "required");
			ValidationUtils.rejectIfEmpty(errors, "prodDetail", "required");

			
		}

}
