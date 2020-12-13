package mainpackage;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class Testes {
	
	Leilao meuLeilao;
	Avaliador leiloeiro;
	Usuario Ana, Emerson, Marcel, Murilo, Yves;
	
	@Before
	public void initTest() {
		meuLeilao = new Leilao("Artigos Eletrônicos");
		leiloeiro = new Avaliador();
		Ana = new Usuario(1, "Ana");
		Emerson = new Usuario(2, "Emerson");
		Marcel = new Usuario(3, "Marcel");
		Murilo = new Usuario(4, "Murilo");
		Yves = new Usuario(5, "Yves");
	}

	@Test
	public void testMaiorLance() throws OfertaInvalidaException {
		
		meuLeilao.propoe(new Lance(Ana,2500));
		meuLeilao.propoe(new Lance(Emerson,2600));
		meuLeilao.propoe(new Lance(Marcel,2735));
		meuLeilao.propoe(new Lance(Murilo,2800));
		meuLeilao.propoe(new Lance(Yves,3000));
		assertEquals(3000,leiloeiro.maiorLance(meuLeilao),0.000001);
	   
	}

	@Test
	public void testMenorLance() throws OfertaInvalidaException {
		meuLeilao.propoe(new Lance(Murilo,2120));
		meuLeilao.propoe(new Lance(Emerson,2300));
		meuLeilao.propoe(new Lance(Ana,2500));
		meuLeilao.propoe(new Lance(Marcel,2600));
		meuLeilao.propoe(new Lance(Yves,2700));
		assertEquals(2120,leiloeiro.menorLance(meuLeilao),0.000001);
	   
	}
	
	@Test
	public void testquemDeuMaiorLance() throws OfertaInvalidaException {
		meuLeilao.propoe(new Lance(Murilo,2120));
		meuLeilao.propoe(new Lance(Emerson,2300));
		meuLeilao.propoe(new Lance(Marcel,2600));
		meuLeilao.propoe(new Lance(Yves,2700));
		meuLeilao.propoe(new Lance(Ana,5000));
		assertEquals("Ana",leiloeiro.quemDeuMaiorLance(meuLeilao));
	}
	
	@Test
	public void testquemDeuMenorLance() throws OfertaInvalidaException {
		meuLeilao.propoe(new Lance(Murilo,2120));
		meuLeilao.propoe(new Lance(Emerson,2300));
		meuLeilao.propoe(new Lance(Marcel,2600));
		meuLeilao.propoe(new Lance(Yves,2700));
		meuLeilao.propoe(new Lance(Ana,5000));
		assertEquals("Murilo",leiloeiro.quemDeuMenorLance(meuLeilao));
	}
		
	@Test
	public void testUltimoLance() throws OfertaInvalidaException {
		meuLeilao.propoe(new Lance(Ana,1000));
		meuLeilao.propoe(new Lance(Emerson,2300));
		meuLeilao.propoe(new Lance(Marcel,2600));
		meuLeilao.propoe(new Lance(Yves,2700));
		meuLeilao.propoe(new Lance(Murilo,4000));	
		assertEquals(4000, leiloeiro.ultimoLance(meuLeilao).getValor(), 0.0001);
	}
	
	@Test
	public void testLanceInvalido() throws OfertaInvalidaException {
		try {
			meuLeilao.propoe(new Lance(Ana,1000));
			meuLeilao.propoe(new Lance(Emerson,2300));
			meuLeilao.propoe(new Lance(Marcel,2600));
			meuLeilao.propoe(new Lance(Murilo,2120));
			meuLeilao.propoe(new Lance(Yves,2700));
		} catch (OfertaInvalidaException e) {
			assertEquals("Oferta não superior às anteriores.", e.getMessage());
		}
	}
}
