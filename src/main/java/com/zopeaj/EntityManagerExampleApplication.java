package com.zopeaj;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.zopeaj.model.prime.Contact;
import com.zopeaj.model.prime.User;
import com.zopeaj.model.product.Category;
import com.zopeaj.model.product.Product;
import com.zopeaj.model.prime.Role;
import com.zopeaj.service.prime.IContactService;
import com.zopeaj.service.prime.IUserService;
import com.zopeaj.service.product.ICategoryService;
import com.zopeaj.service.product.IProductService;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@SpringBootApplication
public class EntityManagerExampleApplication implements CommandLineRunner {
		
	@Autowired private IContactService repo;
	@Autowired private IUserService userRepo;
	@Autowired private IProductService productRepo;
	@Autowired private ICategoryService categoryRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(EntityManagerExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		createContact();
		updateContact();
		deleteContact();
		getContactByEmail();
		
		createProduct();
		getCategoryByName();
	}
	
	private void getContact() {
		UUID id  = null;
		Contact contact = repo.getContactById(id);
		System.out.println(contact);
	}
	
	private void createContact() {
		System.out.println("============SAVE-USER-CONTACT-TO-DB=================");
		
		Contact contact = new Contact();
		contact.setAddress("New York, USA");
		Contact cc = repo.createContact(contact);
		
		Role role1 = new Role();
		role1.setName("USER");
		User user1 = new User();
		user1.setFirstName("Daniella");
		user1.setContact(cc);
		user1.setEmail("daniella@gmail.com");
		user1.setFirstName("Fabulaa");
		user1.setLastName("Sandra");
		user1.setName("Salibas");
		user1.setPassword("password1");
		userRepo.createUser(user1);
		

		Contact contact1 = new Contact();
		contact1.setAddress("Pennsylvania, USA");
		Contact cont = repo.createContact(contact1);		
		Role role2 = new Role();
		role2.setName("ADMIN");
		User user2 = new User();
		user2.setEmail("admin@example.com");
		user2.setFirstName("Ikeduba");
		user2.setRoles(role2);
		user2.setContact(cont);
		userRepo.createUser(user2);
		
		
		Contact contact2 = new Contact();
		contact2.setAddress("Miami, USA");
		Contact cont2 = repo.createContact(contact2);
		Role role = new Role();
		role.setName("ADMIN");
		User user = new User();
		user.setFirstName("David");
		user.setLastName("Kelvin");
		user.setName("Solomon");
		user.setEmail("david@gmail.com");
		user.setPassword("password");
		user.setRoles(role);
		user.setContact(contact2);
		userRepo.createUser(user);
		
	}	
	
	private void deleteContact() {
		System.out.println("========DELETE-CONTACT-BY-ID=================");
		List<Contact> listContact = repo.getAllContacts();
		Contact cont2 = listContact.get(0);
		repo.deleteContactById(cont2.getId());
	}
	
	private void updateContact() {
		System.out.println("========UPDATE-CONTACT-BY-ID==================");
		List<Contact> listContact = repo.getAllContacts();
		Contact cont1 = listContact.get(0);
		repo.updateContactById(cont1.getId(), "Las Vagas, USA");
		
		Contact contact = repo.getContactById(cont1.getId());
		System.out.println(contact);
	}
	
	private void getContactByEmail() {
		System.out.println("========GET-CONTACT-BY-EMAIL===========");
		List<Contact> listContact = repo.getAllContacts();
		Contact con1 = listContact.get(0);
		Contact result = repo.getContactByEmail(con1.getAddress());
		System.out.println(result);
	}
	
	private void listContacts() {
		List<Contact> listContact = repo.getAllContacts();
		listContact.forEach(System.out::println);
	}
	
	private void findStudent() {
		UUID id = null;
		Contact contact = repo.getContactById(id);
		System.out.println(contact);
	}
	
	private void createProduct() {
		Category cat1 = new Category();
		cat1.setCategoryName("electronics");
		
		Category cat2 = new Category();
		cat2.setCategoryName("snacks");
		
		Product prod1 = new Product();
		prod1.setCategory(cat1);
		prod1.setDescription("Some Electronics Description");
		prod1.setDiscountinued(false);
		prod1.setManufacturer("Diamond Electronics Company");
		prod1.setProductImage(null);
		prod1.setPrice("200,000");
		productRepo.creatProduct(prod1);
		
		Product prod2 = new Product();
		prod2.setCategory(cat1);
		prod2.setDescription("Some Electronics Description");
		prod2.setDiscountinued(false);
		prod2.setManufacturer("Kelvin Electronics Company");
		prod2.setPrice("500");
		productRepo.creatProduct(prod2);
		
		Product prod3 = new Product();
		prod3.setCategory(cat2);
		prod3.setDescription("Some Snacks Description");
		prod3.setDiscountinued(false);
		prod3.setManufacturer("Keloogs Snacks Company");
		prod3.setProductImage(null);
		prod3.setPrice("300");
		productRepo.creatProduct(prod1);
		
		Product prod4 = new Product();
		prod4.setCategory(cat2);
		prod4.setDescription("Some Snacks Description");
		prod4.setDiscountinued(false);
		prod4.setManufacturer("Dano Snacks Company");
		prod4.setProductImage(null);
		prod4.setPrice("400");
		productRepo.creatProduct(prod1);
	}
	
	private void getCategoryByName() {
		Set<Product> products = categoryRepo.getProductDataByCategoryName("electronics");
		products.forEach(System.out::println);
	}
}
