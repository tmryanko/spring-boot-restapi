package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemsController {

	@Autowired
	ItemsRepository repo;
	
	@GetMapping("/items")
	public List<Items> getAllItems() {
		return (List<Items>) repo.findAll();
	}
	
	@PostMapping("/items/addItem")
	public void addItems(int id,String name,int amount,String inventoryCode) {
		Items first = new Items(id,name , amount, inventoryCode);
		repo.save(first);
	}
	@GetMapping("/items/{id}")
	public Items getItem(@PathVariable int id) throws Exception {
		Optional<Items> item = repo.findById(id);
		if(!item.isPresent()) throw new Exception("item not exist");
		return item.get();
	}
	@PatchMapping("/items/Withdrawal/{id}")
	public void WithdrawalAmount(@PathVariable int id,int amount) throws Exception {
		Optional<Items> itemOptional = repo.findById(id);
		if (!itemOptional.isPresent()) throw new Exception("item not found");
		itemOptional.get().setAmount(itemOptional.get().getAmount()-amount);
		repo.save(itemOptional.get());
	}
	@PatchMapping("/items/Deposit/{id}")
	public void DepositAmount(@PathVariable int id,int amount) throws Exception {
		Optional<Items> itemOptional = repo.findById(id);
		if (!itemOptional.isPresent()) throw new Exception("item not found");
		itemOptional.get().setAmount(itemOptional.get().getAmount()+amount);
		repo.save(itemOptional.get());
	}
	
	@DeleteMapping("/items/{id}")
	public void deleteStudent(@PathVariable int id) {
		repo.deleteById(id);
	}

}
