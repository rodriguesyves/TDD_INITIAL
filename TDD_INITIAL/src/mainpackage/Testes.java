package mainpackage;

import static org.junit.Assert.*;

import org.junit.Test;

public class Testes {

	@Test
	public void testMaiorLance() {
		Leilao meuLeilao = new Leilao("Artigos Eletrônicos");
		meuLeilao.propoe(new Lance(new Usuario(1,"Ana"),2500));
		meuLeilao.propoe(new Lance(new Usuario(2,"Emerson"),2300));
		meuLeilao.propoe(new Lance(new Usuario(3,"Marcel"),2235));
		meuLeilao.propoe(new Lance(new Usuario(4,"Murilo"),3000));
		meuLeilao.propoe(new Lance(new Usuario(5,"Yves"),2100));
		Avaliador leiloeiro = new Avaliador();
		assertEquals(3000,leiloeiro.maiorLance(meuLeilao),0.000001);	   
	}
}
