package quest_2_filme;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		
		try(Connection connection = new CriarConexao().recuperarConexao()){
			
			AnaliseScanner scanner = new AnaliseScanner();
			Filme filme = new Filme(connection);
			//filme.limpar();
			//filme.cadastrarFilmes();
			
			scanner.iniciarPrograma();
			filme.listarFilmes(scanner.getnFilmes(), scanner.getPagEscolhida());
		}

	}

}
