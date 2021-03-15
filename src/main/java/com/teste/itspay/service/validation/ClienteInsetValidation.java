package com.teste.itspay.service.validation;

import java.util.ArrayList;
import java.util.List;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.teste.itspay.domain.enums.Tipo_Cliente;
import com.teste.itspay.dto.ClienteDTO;
import com.teste.itspay.dto.ClienteNewDTO;

import com.teste.itspay.resources.exeption.FieldMessage;
import com.teste.itspay.service.validation.Utils.Br;

public class ClienteInsetValidation implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {
 @Override public void initialize(ClienteInsert ann) {
 }
 @Override
 public boolean isValid(ClienteNewDTO objDto, ConstraintValidatorContext context) {

  List<FieldMessage> list = new ArrayList<>();

  // inclua os testes aqui, inserindo erros na lista
  if (!Br.isValidCPF(objDto.getCpfOuCnpj()) && objDto.getTipo().equals(Tipo_Cliente.PESSOAFISICA.getCod())) {
   list.add(new FieldMessage("cpfOuCnpj", "CPF Inválido"));
  }else if (objDto.getTipo().equals(Tipo_Cliente.PESSOAJURIDICA.getCod()) && !Br.isValidCNPJ(objDto.getCpfOuCnpj())) {
   list.add(new FieldMessage("cpfOuCnpj", "CNPJ Inválido"));
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