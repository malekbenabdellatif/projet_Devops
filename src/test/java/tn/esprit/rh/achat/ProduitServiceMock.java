package tn.esprit.rh.achat;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

public class ProduitServiceMock {

	@Mock
	ProduitRepository produitRepository;
	
	@InjectMocks
	ProduitServiceImpl produitService;
	
	Produit produit = new Produit("1","100",(float) 50.0,new Date(), new Date ());
	
	ArrayList<Produit> listProduits = new ArrayList<Produit>() {
		{
		add(new Produit ("2","101",(float) 50.1, new Date(), new Date()));
		add(new Produit ("3","102",(float) 50.2, new Date(), new Date()));
		}
				
	};
	
	
	@Test
	public void testRetreiveProduit() {
		Mockito.when(produitRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(produit));
		Produit produit1= produitService.retrieveProduit((long) 2);
		Assertions.assertNotNull(produit1);
	}
}