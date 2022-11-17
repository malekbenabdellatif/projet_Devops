
package tn.esprit.rh.achat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.rh.achat.entities.Operateur;
import tn.esprit.rh.achat.repositories.OperateurRepository;
import tn.esprit.rh.achat.services.OperateurServiceImpl;


@ExtendWith(MockitoExtension.class)
public class testoperateur {
	@Mock
	OperateurRepository operateurRepository;

    @InjectMocks
    OperateurServiceImpl operateurServiceImpl;
	
    Operateur o = new Operateur((long)1,"nom","prenom","password");
    Operateur o1 = new Operateur((long)2,"nom","prenom","password");
	Operateur o2 = new Operateur((long)3,"nom","prenom","password");
	List<Operateur> operateur = new ArrayList<Operateur>() {/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	{add(o1); add(o2);}}; 
	
	@Test
	public void testGetAllOperateur() {
		operateurServiceImpl.retrieveAllOperateurs();
		verify(operateurRepository).findAll();
	}
	
	@Test
	public void testGetOperateur() {
		Mockito.when(operateurRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(o));
		assertNotNull(operateurServiceImpl.retrieveOperateur((long)3));	
	}
	
	@Test
	public void testaddOperateur() {
		Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(o);
		assertNotNull(operateurServiceImpl.addOperateur(o));
		//verify(stockRepository).save(s);
	}
	
	@Test
	public void testUpdateOperateur() {


		Mockito.when(operateurRepository.save(Mockito.any(Operateur.class))).thenReturn(o);
		o.setNom("Updated Libelle");
		assertNotNull(operateurServiceImpl.updateOperateur(o));	
		assertEquals("Updated Libelle", o.getNom());
	}
	
	
	@Test
	public void testDeleteOperateur() {
		operateurServiceImpl.deleteOperateur((long)3);
		verify(operateurRepository).deleteById((long)3);
	}
	
	
	
	
	
	
	
	
	
	
}

