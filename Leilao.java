package mainpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) throws OfertaInvalidaException {
		double maiorLance = Double.NEGATIVE_INFINITY;
		
		for (Lance bid : lances) {
			if (bid.getValor() > maiorLance) 
				maiorLance = bid.getValor();
		}
		if (lance.getValor() > maiorLance) {
			lances.add(lance);
		} else {	
			throw new OfertaInvalidaException("Oferta não superior às anteriores.");
		}
	}

	public String getDescricao() {
		return descricao;
	}

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	
	
}
