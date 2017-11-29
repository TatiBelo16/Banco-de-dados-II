package deserializador;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Informacoes {

		private List<TaxiCircuit> listaObj = new ArrayList<>(); 
	
	
		public void receberInformacoes() {
		SimpleDateFormat dt = new SimpleDateFormat("yyyyy-mm-dd hh:mm:ss");
			
			
		String str[]= new String[4];
		int count = 0;
		FileReader arquivo;
		try{
			arquivo = new FileReader("taxiCircuit.txt");
			BufferedReader lerArq = new BufferedReader(arquivo);
			
			String linha = lerArq.readLine();//primeira linha
				while(linha != null){
					for(String s:linha.split(",") ) {
						if(count >3) {
				             int inteiro = Integer.parseInt(str[0]);
				             Date data = (Date) dt.parse(str[1]);
							this.listaObj.add(new TaxiCircuit(inteiro, data, str[2], str[3]));
							count = 0;
						}
						str[count] =s;
						count++;
					}
					linha=lerArq.readLine();
				}
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		

		
	}


		public List<TaxiCircuit> getListaObj() {
			return listaObj;
		}


		public void setListaObj(List<TaxiCircuit> listaObj) {
			this.listaObj = listaObj;
		}


}
