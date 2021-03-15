package com.teste.itspay.service.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import com.teste.itspay.dto.ClienteDTO;
import com.teste.itspay.resources.exeption.FieldMessage;
import com.teste.itspay.service.validation.Utils.Br;

public class ClienteInsetValidation implements ConstraintValidator<ClienteInsert, ClienteDTO> {
 @Override public void initialize(ClienteInsert ann) {
 }
 @Override
 public boolean isValid(ClienteDTO objDto, ConstraintValidatorContext context) {
 
	 List<FieldMessage> list = new ArrayList<>();
 
      //colocar a logica os R$0.10 por cada requisição feita ao seu serviço
	   if (!Br.isValidCPF(objDto.getCpfOuCnpj())) {
           list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
       }

     //if (!Br.isValidCNPJ(objDto.getCpfOuCnpj())) {
     //   list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
     //}
 
 for (FieldMessage e : list) {
 context.disableDefaultConstraintViolation();
 context.buildConstraintViolationWithTemplate(e.getMessage())
 .addPropertyNode(e.getFieldName()).addConstraintViolation();
 }
 return list.isEmpty();
 }
}