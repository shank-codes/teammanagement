package com.delitheproject.iplteam;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Vector;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



@SpringBootTest
@RunWith(SpringRunner.class)
class IplteamApplicationTests {

	@MockBean
	PlayerRepository repo;
	@Autowired
	PlayerService serv;

	@Test
	public void testAdd()
	{
		Player pro=new Player(12,"Rohit","bat",150,5000,0);
		Player pr=null;
		
		when(repo.save(pro)).thenReturn(pro);
		assertEquals(pro, serv.newadd(pro));
		assertNull(serv.newadd(pr));          // 
		Player pr02=new Player(10,"Rohit","bat",150,5000,0);
		
		when(repo.save(pr02)).thenReturn(pr02);
		assertTrue(serv.newadd(pr02).getPid()==10);
	}
	@Test
	public void testIterate()
	{
		
		List<Player> storage=new Vector<Player>();
		Player pro1=new Player(12,"Rohit","bat",150,5000,0);
		Player pro2=new Player(13,"Rohit Sharma","bat",150,4000,0);
		Player pro3=new Player(14,"Rohit Kumar","bat",150,3000,0);
		
		
		storage.add(pro1);storage.add(pro2);storage.add(pro3);
		
		when(repo.findAll()).thenReturn(storage);
		assertTrue(serv.every().get(0).getPruns()>=1000.0);
		assertNotNull(serv.every().get(2));
	}
	
	@Test
	public void testUpdate()
	{
		Player pro1=new Player(12,"Rohit","bat",150,5000,0);
		Player pro2=new Player(13,"Rohit Sharma","bat",150,4000,0);
		when(repo.save(pro1)).thenReturn(pro1);
		assertEquals(pro1, serv.alter(pro1));
		
		when(repo.save(pro2)).thenReturn(pro2);
		assertTrue(serv.alter(pro1).getPruns()>=pro2.getPruns());
	}
	
	@Test
	public void testDelete()
	{
		Player pro1=new Player(12,"Rohit","bat",150,5000,0);
		Player pro2=new Player(13,"Rohit Sharma","bat",150,4000,0);
		assertSame(pro2.getPname(),serv.remove(pro2));
		assertSame(pro1.getPname(),serv.remove(pro1));
	}

}
