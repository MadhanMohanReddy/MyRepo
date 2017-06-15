package com.mine.controller;

import org.springframework.web.servlet.mvc.SimpleFormController;

import com.mine.model.Contact;
import com.mine.service.ContactService;

/**
 * Created by madhan.reddy on 6/15/2017.
 */
public class CreateContactController extends SimpleFormController{

  public CreateContactController() {
    setCommandClass(Contact.class);
  }

  public void doSubmitAction(Object command){
    Contact contact = (Contact)command;
    ContactService.createContact(contact);
  }
}

