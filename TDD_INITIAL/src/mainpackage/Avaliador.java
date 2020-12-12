package mainpackage;


public class Avaliador {
	
	private double maiorValor = Double.NEGATIVE_INFINITY;
	
	public double maiorLance(Leilao leilao) {
		for(Lance lance : leilao.getLances() ) {
			if (lance.getValor() > maiorValor)
				maiorValor = lance.getValor();
		}	
		return maiorValor;	
	}
	
	 public double menorLance(Leilao leilao) {
			return 10;	
		}
}
