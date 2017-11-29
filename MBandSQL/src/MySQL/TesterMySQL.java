package MySQL;

import deserializador.TaxiCircuit;

public class TesterMySQL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conexao cx = new Conexao();
		taxiDAO ss = new taxiDAO(cx);
		
		ss.save();
		
		//cx.abrir();
		
	//cx.fechar();
	
System.out.println(ss.getCrono().getDiferencaTempo());
	
	
		
	}
	
}
