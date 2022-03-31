package quest_2_filme;

import java.sql.Connection;
import java.sql.SQLException;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import javax.sql.DataSource;


public class CriarConexao {
	
	public DataSource dataSource;
	
	public CriarConexao() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		comboPooledDataSource.setJdbcUrl("jdbc:mysql://localhost/filme?useTimezone=true&serverTimezone=UTC");
		comboPooledDataSource.setUser("root");
		comboPooledDataSource.setPassword("102030");
		comboPooledDataSource.setMaxPoolSize(16);
		
		this.dataSource = comboPooledDataSource;
		
	}
	
	
	public Connection recuperarConexao() throws SQLException {
		return this.dataSource.getConnection();
				
				
		
	}
	
}
