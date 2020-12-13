package mainpackage;


public class Avaliador {
	
	private double maiorValor = Double.NEGATIVE_INFINITY;
	private double menorValor = Double.POSITIVE_INFINITY;
	
	public double maiorLance(Leilao leilao) {
		for(Lance lance : leilao.getLances() ) {
			if (lance.getValor() > maiorValor)
				maiorValor = lance.getValor();
		}	
		return maiorValor;	
	}
	
	 public double menorLance(Leilao leilao) {
		 for(Lance lance : leilao.getLances() ) {
				if (lance.getValor() < menorValor)
					menorValor = lance.getValor();
			}	
			return menorValor;	
		}
	 
	 public String quemDeuMaiorLance(Leilao leilao) {
		 String nomeUsuario = null;
		 double maiorLance = maiorLance(leilao);
		 for (Lance lance : leilao.getLances()) {
			 if (lance.getValor() == maiorLance)
				 nomeUsuario = lance.getUsuario().getNome();	 
		 }
		 
		 return nomeUsuario;
	 }
	 
	 public String quemDeuMenorLance(Leilao leilao) {
		 String nomeUsuario = null;
		 double menorLance = menorLance(leilao);
		 for (Lance lance : leilao.getLances()) {
			 if (lance.getValor() == menorLance)
				 nomeUsuario = lance.getUsuario().getNome();	 
		 }
		 
		 return nomeUsuario;
	 }
	 
}
