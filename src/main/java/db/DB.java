package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn == null) {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("dburl");

                conn = DriverManager.getConnection(url, props);

            } catch (SQLException e) {
                throw new RuntimeException("Erro ao conectar no banco: " + e.getMessage());
            }
        }
        return conn;
    }

    private static Properties loadProperties() {
        try (InputStream fs = DB.class
                .getClassLoader()
                .getResourceAsStream("db.properties")) {

            if (fs == null) {
                throw new RuntimeException("Arquivo db.properties NÃO encontrado");
            }

            Properties props = new Properties();
            props.load(fs);
            return props;

        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler db.properties");
        }
    }

    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar conexão");
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (st != null) {
            try {
                st.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar Statement");
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new RuntimeException("Erro ao fechar ResultSet");
            }
        }
    }
}


