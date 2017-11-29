package MongoDB;

import deserializador.Informacoes;
import deserializador.TaxiCircuit;

public class TesterMongoDB {
	
	public static void main(String[] args) {
	
		Conexao cx = new Conexao();
		
		cx.inserirObjeto("taxi");
		System.out.println(cx.getTaxis().get(8));
		System.out.println(cx.getCronometro().getDiferencaTempo());
		

	}

}
