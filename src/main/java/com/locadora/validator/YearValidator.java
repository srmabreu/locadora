package com.locadora.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 * Classe valida se o ano informado pelo usuário é um numero e possui 4 digitos.
 * 
 * @author Sérgio Abreu <srmabreu@gmail.com>
 */
@FacesValidator("yearValidator")
public class YearValidator implements Validator {

    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {  
        if(value.toString().length() != 4) {  
        	throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", value + " não é um ano valido. O ano deve estar no formato yyyy."));
        }  
        try {
        	Integer.parseInt(value.toString());
        } catch (NumberFormatException e) {
        	throw new ValidatorException(new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro de validação", value + " não é um ano valido. O ano deve estar no formato yyyy."));
        }
    }

}
