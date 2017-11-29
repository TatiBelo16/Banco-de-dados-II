package MongoDB;

import java.util.List;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;

import deserializador.Informacoes;
import deserializador.TaxiCircuit;
import deserializador.Temporizador;

public class Conexao {
	
	private Mongo conexao = new Mongo("localhost",27017);
	private DB banco = conexao.getDB("TaxiDriveCircuit");
	private Temporizador cronometro = new Temporizador();
	
	private List<TaxiCircuit> taxis;
	
	
	//gera a collection caso ela não exista
	public void inserirObjeto(String nomeDaColecao) {
		try {
			cronometro.start();
			//var's
			Informacoes inf1 = new Informacoes();
			inf1.receberInformacoes();
			List<TaxiCircuit> list = inf1.getListaObj();
			this.setTaxis(list);
			TaxiCircuit txCircuit;
			int count = 0;
			int i =list.size();
			
			for(TaxiCircuit x :list) {
				while(count<= i) {
					x = list.get(count);
					txCircuit = x;
					count++;
				
			//insere os dados no banco
			BasicDBObject basic =  new BasicDBObject();
			basic.put("placa", txCircuit.getId());
			basic.put("Data", txCircuit.getData());
			basic.put("Latitude",txCircuit.getLatitude());
			basic.put("Longetude", txCircuit.getLongetude());
			DBCollection col =  banco.getCollection(nomeDaColecao);
			col.insert(basic);
			
			
			
				}}
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			cronometro.stop();
		}
		
	}
	
	
	public void retornar(String  nomeDaColecao,String nomeX,String numero) {
		System.out.println(banco.getCollectionFromString(nomeDaColecao).find( ).addSpecial(nomeX, numero));
	}

	
	
	
	public Mongo getConexao() {
		return conexao;
	}
	public void setConexao(String endereco) {
		this.conexao = new Mongo(endereco);
	}
	public DB getBanco() {
		return banco;
	}
	public void setDb(String nomeDoBanco) {
		this.conexao.getDB(nomeDoBanco);
	}


	public List<TaxiCircuit> getTaxis() {
		return taxis;
	}


	public void setTaxis(List<TaxiCircuit> taxis) {
		this.taxis = taxis;
	}


	public Temporizador getCronometro() {
		return cronometro;
	}


	public void setCronometro(Temporizador cronometro) {
		this.cronometro = cronometro;
	}
	
	
	
	
}