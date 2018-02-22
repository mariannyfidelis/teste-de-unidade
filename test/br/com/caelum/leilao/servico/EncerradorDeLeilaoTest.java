package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.builder.CriadorDeLeilao;
import br.com.caelum.leilao.dominio.Leilao;
import java.util.Calendar;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class EncerradorDeLeilaoTest {
    
   @Test
   public void deveEncerrarLeiloesQueComecaramUmaSemanaAtras(){
       
       Calendar antiga = Calendar.getInstance();
       antiga.set(1999, 1, 20);
       
       Leilao leilao1 = new CriadorDeLeilao().para("TV de plasma ").naData(antiga).constroi();
       Leilao leilao2 = new CriadorDeLeilao().para("Geladeira ").naData(antiga).constroi();
       
       EncerradorDeLeilao encerradorLeilao = new EncerradorDeLeilao();
       encerradorLeilao.encerra();
       
       //busca no banco a lista de encerrados
       List<Leilao> encerrados = encerradorLeilao.getLeilaoDAO().encerrados();
       
       assertEquals(2, encerrados.size());
       assertTrue(encerrados.get(0).isEncerrado());
       assertTrue(encerrados.get(1).isEncerrado()); 
   }
   
   
   
    
}
