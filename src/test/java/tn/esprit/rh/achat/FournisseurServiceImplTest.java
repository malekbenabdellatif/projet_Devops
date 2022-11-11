package tn.esprit.rh.achat;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.IFournisseurService;
@RunWith(SpringRunner.class)
@SpringBootTest
public class FournisseurServiceImplTest {
	@Autowired
	FournisseurRepository fournrepo;
	@Autowired
	IFournisseurService fournserv;
	@Test
	public void testCreatefournisseur(){
		
		Fournisseur f = new Fournisseur();
		f.setLibelle("test");
		//f.setCategorieFournisseur();;
		f.setCode("G456");
		Fournisseur savedFournisseur= fournserv.addFournisseur(f);
		assertNotNull(savedFournisseur);
		
	}
	
	@Test
	public void testALLFournisseurs(){
		/*Fournisseur f =new Fournisseur("G456","FournisseurX");
		fournrepo.save(f);*/
		

		Fournisseur f = new Fournisseur();
		f.setLibelle("test");
		//f.setCategorieFournisseur();;
		f.setCode("G456");
		fournserv.addFournisseur(f);
		
		Fournisseur f1 = new Fournisseur();
		f.setLibelle("FourY");
		//f.setCategorieFournisseur();;
		f.setCode("G90A");
		fournserv.addFournisseur(f1);
		
		List<Fournisseur> list = fournserv.retrieveAllFournisseurs();
		int expected=list.size();
		assertNotNull(list);
		assertEquals(expected,list.size());
		
		
	}
	
	@Test
	public void testFindFournisseur(){
		Fournisseur f = fournrepo.findById(1L).get();
		assertNotNull(f);
		System.out.println(f);
	}
	
	
	
	@Test
	public void testUpdateFournisseur(){
		
		Fournisseur f = fournrepo.findById(1L).get();
		f.setLibelle("Chayma");
		fournrepo.save(f);
		assertNotNull(f);
		System.out.println(f);
	}
	
	@Test
	public void testDeleteFournisseur(){
		

		fournrepo.deleteById(19L);
	}
	
	
	
	
	
	
	

}
