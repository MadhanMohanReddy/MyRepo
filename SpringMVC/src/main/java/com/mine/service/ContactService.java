package com.mine.service;

import com.mine.model.Contact;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by madhan.reddy on 6/15/2017.
 */
public class ContactService {
  private static Map contacts = new HashMap();

  public ContactService() {
  }

  public static Contact createContact(Contact contact){
    contacts.put(new Integer(contact.hashCode()), contact);
    return contact;
  }

  public static Contact createContact(String firstName, String lastName){
    return createContact(new Contact(firstName, lastName));
  }

  public static boolean deleteContact(String firstName){
    Iterator iterator = contacts.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry entry = (Map.Entry)iterator.next();
      Contact contact = (Contact)entry.getValue();
      if (contact.getFirstName().equals(firstName)){
        contacts.remove(new Integer(contact.hashCode()));
        return true;
      }
    }
    return false;
  }

  public static List listContacts(){
    return toList(contacts);
  }

  private static List toList(Map contacts){
    List contactList = new ArrayList();
    Iterator iterator = contacts.entrySet().iterator();
    while (iterator.hasNext()){
      Map.Entry entry = (Map.Entry)iterator.next();
      Contact contact = (Contact)entry.getValue();
      contactList.add(contact);
    }
    return contactList;
  }

}
