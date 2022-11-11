package tn.esprit.rh.achat;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import junit.framework.TestCase;

import static org.junit.Assert.*;
import tn.esprit.rh.achat.entities.Fournisseur;
import tn.esprit.rh.achat.repositories.FournisseurRepository;
import tn.esprit.rh.achat.services.FournisseurServiceImpl;

//import org.junit.runner.RunWith;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.boot.test.context.SpringBootTest;
@RunWith(MockitoJUnitRunner.class)
//@ExtendWith(MockitoExtension.class)
public class FournisseurServiceTestMockito extends TestCase {
	@Mock
	FournisseurRepository fournisrepo;
	@InjectMocks
	FournisseurServiceImpl fourniservice;
	
	
	Fournisseur f = new Fournisseur((long)1,"testLibelle1","code1", null,null,null, null);
	Fournisseur f1 = new Fournisseur((long)2,"testLibelle2","code2", null,null,null, null);
	Fournisseur f2 = new Fournisseur((long)3,"testLibelle3","code3", null,null,null, null);
	List<Fournisseur> fournisseur = new ArrayList<Fournisseur>() {{add(f);add(f1); add(f2);}}; 
	
	/*@Test
	public void testGetAllStock() {
		fourniservice.retrieveAllFournisseurs();
		verify(fournisrepo).findAll();
	}
	
	@Test
	public void testGetStock() {
		Mockito.when(fournisrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(s1));
		assertNotNull(fourniservice.retrieveFournisseur((long)3));	
	}
	
	@Test
	public void testaddStock() {
		Mockito.when(fournisrepo.save(Mockito.any(Fournisseur.class))).thenReturn(s);
		assertNotNull(fourniservice.addFournisseur(s));
		//verify(stockRepository).save(s);
	}
	
	
	@Test
	public void testUpdateStock() {
		Mockito.when(fournisrepo.save(Mockito.any(Fournisseur.class))).thenReturn(s);
		s.setLibelle("david");
		assertNotNull(fourniservice.updateFournisseur(s));	
		assertEquals("salim", s.getLibelle());
	}
	
	@Test
	public void testDeleteStock() {
		fourniservice.deleteFournisseur((long)3);;
		verify(fournisrepo).deleteById((long)3);;
	}*/
	
	
	
	@Test
	public void save() {
		Mockito.when(fournisrepo.save(Mockito.any(Fournisseur.class))).thenReturn(f);
		Fournisseur newFournisseur = fourniservice.addFournisseur(f);
		assertNotNull(newFournisseur);
		
	}
	
	@Test
	public void getFournisseurById() {
		Mockito.when(fournisrepo.findById(Mockito.anyLong())).thenReturn(Optional.of(f1));
		Fournisseur newFournisseur = fourniservice.retrieveFournisseur(f1.getIdFournisseur());
		assertNotNull(newFournisseur);
		
	}
	
	@Test
	public void testGetAllFournisseurs() {
		fourniservice.retrieveAllFournisseurs();
		verify(fournisrepo).findAll();
	}
	
	@Test
	public void testUpdateFournisseur() {
		Mockito.when(fournisrepo.save(Mockito.any(Fournisseur.class))).thenReturn(f1);
		f1.setLibelle("david");
		assertNotNull(fourniservice.updateFournisseur(f1));	
		assertEquals("david", f1.getLibelle());
	}
	
	@Test
	public void testDeleteFournisseur() {
		fourniservice.deleteFournisseur((long)3);;
		verify(fournisrepo).deleteById((long)3);;
	}
	
}
