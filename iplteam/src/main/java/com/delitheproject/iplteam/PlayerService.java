package com.delitheproject.iplteam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository repo;
	
	public Player newadd(Player player)
	{
		return repo.save(player);                //repo.save is a pre defined method in spring boot for a repository
	}                                              //serv.newadd(vehicle);
	
	public List<Player> every()
	{
		return repo.findAll();                      //read
	}
	
	public Player single(int id)
	{
		return repo.findById(id).orElse(new Player());    
	}
	
	public Player alter(Player player)
	{
		return repo.save(player);
	}
	
	public String remove(Player player)
	{
		String model=player.getPname();
		repo.delete(player);
		return model;
	}
	

}
