/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.soesitod.ice4;

/**
 *
 * @author danie
 */
public class ContactManager {
    private Contact[] contactList;

//    random comment
    public ContactManager(Contact[] contactList) {
        this.contactList = contactList;
    };

    /*
	Locate a Contact record that matches the email address provided.
	Returns the Contact record if found, null if not found.
    */
    public Contact findContact(String emailAddress){
        if (this.contactList != null && emailAddress != null) {
            for (Contact i : this.contactList) {
                if (i.getEmailAddress().toUpperCase().equals(emailAddress.toUpperCase())){
                    if (i.getEmailAddress() == null || i.getFirstName() == null || i.getLastName() == null) {
                        return null;
                    }
                    return i;
                }
            }
        }
        return null;
    };
    

    /*
	 Removes all contacts
    */
    public void clearContacts(){
        this.contactList = null;
    };

}

