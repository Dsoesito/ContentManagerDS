/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.soesitod.ice4;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author danie
 */
public class ContactManagerTest {
    
    private ContactManager instance;
    
    public ContactManagerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        Contact c1 = new Contact("Daniel", "Soesito", "soesitod@sheridancollege.ca");
        Contact c2 = new Contact("Matthew", "Soesito", "soesitom@sheridancollege.ca");
        Contact c3 = new Contact("Ben", "Soesito", "soesitob@sheridancollege.ca");
        Contact c5 = new Contact("Gary", null, "soesitog@sheridancollege.ca");
        Contact c6 = new Contact(null, "soesito", "soesito@sheridancollege.ca");

        Contact[] contactList = new Contact[]{c1, c2, c3, c5, c6};
        
        instance = new ContactManager(contactList);
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of findContact method, of class ContactManager.
     */
    
    // Finding the correct contact
    @org.junit.jupiter.api.Test
    public void testFindContact() {
        System.out.println("findContact");
        String emailAddress = "soesitod@sheridancollege.ca";
        Contact expResult = new Contact("Daniel", "Soesito", "soesitod@sheridancollege.ca");
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
    }
    
    // Contact does not exist in the list
    @org.junit.jupiter.api.Test
    public void testFindContactDoesNotExist() {
        System.out.println("findContactDoesNotExist");
        String emailAddress = "fake@sheridancollege.ca";
        Contact expResult = null;
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult, result);
    }
    
    // Empty list
    @org.junit.jupiter.api.Test
    public void testFindContactEmptyList() {
        System.out.println("findContactEmptyList");
        String emailAddress = "fake@sheridancollege.ca";
        Contact expResult = null;
        instance.clearContacts();
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult, result);
    }
    
    // Submitting an upper case email when email is stored as lower case
    @org.junit.jupiter.api.Test
    public void testFindContactUpper() {
        System.out.println("findContactUpper");
        String emailAddress = "SOESITOD@SHERIDANCOLLEGE.CA";
        Contact expResult = new Contact("Daniel", "Soesito", "soesitod@sheridancollege.ca");
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult.getFirstName(), result.getFirstName());
        assertEquals(expResult.getLastName(), result.getLastName());
    }
    
    // Submitting a null email address to findContact()
    @org.junit.jupiter.api.Test
    public void testFindContactNullEmail() {
        System.out.println("findContactNullEmail");
        String emailAddress = null;
        Contact expResult = null;
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult, result);
    }
    
    // Receiving a null firstName from findContact()
    @org.junit.jupiter.api.Test
    public void testFindContactReceiveNullFirstName() {
        System.out.println("findContactReceiveNullFirstName");
        String emailAddress = "soesito@sheridancollege.ca";
        Contact expResult = null;
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult, result);
    }
    
    // Receiving a null lastName from findContact()
    @org.junit.jupiter.api.Test
    public void testFindContactReceiveNullLastName() {
        System.out.println("findContactReceiveNullLastName");
        String emailAddress = "soesitog@sheridancollege.ca";
        Contact expResult = null;
        Contact result = instance.findContact(emailAddress);
        assertEquals(expResult, result);
    }
}
