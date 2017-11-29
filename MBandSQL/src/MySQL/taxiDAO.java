package MySQL;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoField;
import java.util.ArrayList;
import java.util.List;

import bsh.JavaCharStream;
import deserializador.Informacoes;
import deserializador.TaxiCircuit;
import deserializador.Temporizador;

public class taxiDAO implements IPersistible<TaxiCircuit> {

	private Connection connection;
	private Conexao conexao;
	private Temporizador crono = new Temporizador() ;
	
	
	
	public taxiDAO(Conexao conexao) {
		this.conexao = conexao;
		this.connection = conexao.abrir();
	}



	public void save() {
		
		//instrucao SQL]
		String sql= ("Insert into taxi(placa,data,latitude,longitude)values(?,?,?,?)");
		PreparedStatement pstmt;
			try {
				crono.start();
				//var's
				Informacoes inf1 = new Informacoes();
				inf1.receberInformacoes();
				List<TaxiCircuit> list = inf1.getListaObj();
				TaxiCircuit txCircuit;
				int count = 0;
				int i =list.size();
				
				for(TaxiCircuit x :list) {
					while(count<= i) {
						x = list.get(count);
						txCircuit = x;
						count++;
				
				
				pstmt = connection.prepareStatement(sql);
				
				
				pstmt.setInt(1,txCircuit.getId());
				pstmt.setString(2,txCircuit.getData().toString());
				pstmt.setString(3, txCircuit.getLatitude());
				pstmt.setString(4,txCircuit.getLongetude());
				
				pstmt.execute();
					}}
			}catch (SQLException e) {
				e.printStackTrace();
			} finally {
				conexao.fechar();
				crono.stop();
			}
			
	}



	public Temporizador getCrono() {
		return crono;
	}



	public void setCrono(Temporizador crono) {
		this.crono = crono;
	}



	@Override
	public TaxiCircuit getOne(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public List<TaxiCircuit> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public void delete(TaxiCircuit entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void update(TaxiCircuit entity) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void buscaNome(TaxiCircuit entity) {
		// TODO Auto-generated method stub
		
	}



		

	


}
