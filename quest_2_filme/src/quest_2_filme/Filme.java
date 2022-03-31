package quest_2_filme;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;





public class Filme {
	
	private Connection connection;
	
	private int[] filmesID = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
	
	private String[] filmesNomes = {"Matrix","Interestelar","Star Wars", "Star Trek", "Avatar",
	"O Predestinado", "Lucy", "Sem Limites - limitless", "A Viagem - Cloud Atlas", "Fonte da Vida",
	"O Universo no Olhar", "O Destino de Júpiter - Jupter Ascending", "13º Andar", "Trancendence",
	"Tron: O Legado", "Ghost in the shell", "Contato", "A Origem - Inception", "Os Agentes Do Destino",
	"Alice No Pais das Maravilhas"};
	
	private String[] filmesDescricao = {"Ação e Ficção científica" , "Drama, Aventura e Ficcão cientifica",
			"Ficção Cientifica", "Aventura, Fantasia e Ficção cientifica", "Ação, Drama, Ficção cientifica",
			"Ação, Ficção cientifica","Ação, Ficção cientifica", "Drama e Ficção cientifica", "Mistério, Romance, Drama",
			"Drama e Ficção cientifica", "Ação, Fantasia e Ficção cientifica", "Suspense, Fantasia e Ficção cientifica",
			"Suspense", "Aventura, Ficção cientifica e Ação", "Ficcção cientifica","Drama, Ação, Crime e Ficção cientifica",
			"Mistério, Drama e ação", "Ação, Aventura e Ficção cientifica", "Romance, Ação e Ficção cientifica", 
			"Fantasia"};
	
	private int[] filmesAno = {1999, 2014, 1991, 1966, 2009, 2014, 2014, 2011, 2012, 2006, 
			2014, 2014, 1999, 2014, 2018, 1995, 1997, 2010, 2011, 2010};
	
	
	
	
	public Filme(Connection connection) {
		this.connection = connection;
		
	}
	
	public void limpar() throws SQLException {
		
		PreparedStatement stm = connection.prepareStatement("DELETE FROM FILME_LISTA WHERE ID > ?");
			stm.setInt(1, 0);
			stm.execute();
		
			
	}
	public void cadastrarFilmes() throws SQLException {
		
		String sql = "INSERT INTO FILME_LISTA (ID , NOME, DESCRICAO, ANO) VALUES (?,?,?,?)";
		
		try(PreparedStatement pstm = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)){
			
			for(int i = 0; i < 20; i++) {
			pstm.setInt(1, filmesID[i]);
			pstm.setString(2, filmesNomes[i]);
			pstm.setString(3, filmesDescricao[i]);
			pstm.setInt(4, filmesAno[i]);
			pstm.execute();
			
			System.out.println("Filme: " + filmesID[i] + " - " + filmesNomes[i] + " Gênero: " 
					+ filmesDescricao[i] + " Ano: " + filmesAno[i] + "\n");
		}}
		
	}
	public void listarFilmes (int nFilmes, int pagEscolhida) throws SQLException {
		
		String sql = "SELECT * FROM FILME_LISTA LIMIT ? OFFSET ?";
		
		try (PreparedStatement pSt = connection.prepareStatement(sql)){
			
			pSt.setInt(1, nFilmes);
			pSt.setInt(2, (pagEscolhida * nFilmes) - nFilmes);
			pSt.execute();
			ResultSet rst =  pSt.getResultSet();
			
			try {
				while ( rst.next()) {
					System.out.println("\n" + rst.getInt(1) + " - "
							+(rst.getString(2)) + " - "
							+(rst.getString(3)) + " - "
							+ (rst.getInt(4)));
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
