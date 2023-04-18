//Lucas Andre Munhoz da Cruz
//Joao Victor Viera dos Anjos
//Matheus Augusto da Cruz Grossi
//RA 2418312
//RA 2311500
//RA 2348110
//JDK 18.0.1.1
//Netbeans 15

package gamesstoreapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

public class BDconnection {
    private static final String mysqlURL = "jdbc:mysql://localhost:3306/";
    private static final String nomeBD = "gamesstorebd";
    private static final String usuario = "gamesStoreApp";
    private static final String senha = "gs123";
    private static Connection conexao;
    
    private ArrayList<Usuario> usuarios = new ArrayList<>();
    private ArrayList<Game> desenvolvedoras = new ArrayList<>();
    
    private ArrayList<Game> games = new ArrayList<>();
    private ArrayList<Game> gamesRpg = new ArrayList<>();
    private ArrayList<Game> gamesFps = new ArrayList<>();
    private ArrayList<Game> gamesAventura = new ArrayList<>();
    
    public static BDconnection unicaConexao;
    
    public BDconnection(){
        conectarBanco();
    }
    
    public static BDconnection getBDconnection(){
        if(unicaConexao == null){
            unicaConexao = new BDconnection();
        }
        return unicaConexao;
    }
    
    private void conectarBanco(){
        try{
            conexao = DriverManager.getConnection(mysqlURL+nomeBD, usuario, senha); 
            conexao.setAutoCommit(false);
            System.out.println("Conectado ao banco!");
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public Connection getConexao (){
        return conexao;
    }
    
    public Boolean login(Connection conexao, String login, String senha) throws SQLException{
        try{
            GamesStore gs = new GamesStore();
            String sql = "SELECT loginUsuario, senhaUsuario, admUsuario, cpfUsuario FROM usuario WHERE loginUsuario = '" + login + "' AND senhaUsuario = '" + senha +"'";
            Statement declaracao = conexao.createStatement();
            ResultSet resultado = declaracao.executeQuery(sql);
            if(resultado != null && resultado.next()){
                gs.setAdm(resultado.getBoolean("admUsuario"));
                gs.setCpfUsuario(resultado.getInt("cpfUsuario"));
                conexao.commit();
                return true;
            }else{
                conexao.commit();
                return false;
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return false;
        }   
    }

    public void cadastrarUsuario(int cpf, String nome, String sobrenome, String login, String senha, String rua, int numero, int cep) throws SQLException{
        try{
            int idEndereco;
            Statement declaracao = conexao.createStatement();
            
            String sql = "INSERT INTO endereco (ruaEndereco,numeroEndereco,cepEndereco) VALUES ('"+ rua +"',"+ numero +"," + cep +")";
            declaracao.addBatch(sql);
            declaracao.executeBatch();  
            
            sql = "SELECT idEndereco FROM endereco WHERE ruaEndereco = '"+rua+"' AND numeroEndereco = " + numero + " AND cepEndereco = " + cep;
            
            ResultSet resultado = declaracao.executeQuery(sql);

            if(resultado != null && resultado.next()){
                idEndereco = resultado.getInt("idEndereco");
                sql = "INSERT INTO usuario (cpfUsuario, nomeUsuario, sobrenomeUsuario, loginUsuario, senhaUsuario, Endereco_idEndereco)" +
                      "VALUES (" + cpf + ",'" + nome + "','" + sobrenome + "','" + login + "','" + senha + "'," + idEndereco + ")";
                declaracao.addBatch(sql);
                declaracao.executeBatch();
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario cadastrado com sucesso!",
                    "Cadastro",
                    1
                );
                conexao.commit();
            }else{
                conexao.rollback();
                JOptionPane.showMessageDialog(
                    null,
                    "ERRO!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public Usuario consultarUsuario(int cpf) throws SQLException{
        try{
            Usuario usuario = new Usuario();
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT nomeUsuario, sobrenomeUsuario, loginUsuario, Endereco_idEndereco FROM usuario WHERE cpfUsuario = " + cpf;
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(resultado != null && resultado.next()){
                usuario.setNome(resultado.getString("nomeUsuario"));
                usuario.setSobrenome(resultado.getString("sobrenomeUsuario"));
                usuario.setLogin(resultado.getString("loginUsuario"));
                usuario.endereco.setIdEndereco(Integer.parseInt(resultado.getString("Endereco_idEndereco")));

                sql = "SELECT ruaEndereco, numeroEndereco, cepEndereco FROM endereco WHERE idEndereco = " + usuario.endereco.getIdEndereco();
                resultado = declaracao.executeQuery(sql);
                if(resultado != null && resultado.next()){
                    usuario.endereco.setCep(Integer.parseInt(resultado.getString("cepEndereco")));
                    usuario.endereco.setNumero(Integer.parseInt(resultado.getString("numeroEndereco")));
                    usuario.endereco.setRua(resultado.getString("ruaEndereco"));

                    conexao.commit();
                    JOptionPane.showMessageDialog(
                        null,
                        "Usuario encontrado!",
                        "Cadastro",
                        1
                    );
                    return usuario;
                }else{
                    conexao.rollback();
                    JOptionPane.showMessageDialog(
                        null,
                        "ERRO!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return null;
                }
            }else{
                conexao.rollback();
                JOptionPane.showMessageDialog(
                    null,
                    "CPF de usuario não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
                return null;
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }   
    }
    
    public void excluirUsuario(int cpf) throws SQLException{
        try{
            Statement declaracao = conexao.createStatement();
            String sql = "SELECT * FROM usuario WHERE cpfUsuario = " + cpf;
            ResultSet resultado = declaracao.executeQuery(sql);
            if(resultado != null && resultado.next()){
                int cpfUsuRetornoBanco = resultado.getInt("cpfUsuario");
                int idEndRetornoBanco = resultado.getInt("Endereco_idEndereco");
                sql = "DELETE FROM usuario_possui_game WHERE Usuario_cpfUsuario = " + cpfUsuRetornoBanco;
                declaracao.execute(sql);
                sql = "DELETE FROM usuario WHERE cpfUsuario = " + cpfUsuRetornoBanco;
                declaracao.execute(sql);
                sql = "DELETE FROM endereco WHERE idEndereco = " + idEndRetornoBanco;
                declaracao.execute(sql);
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario excluido com sucesso!",
                    "Cadastro",
                    1
                );
            }else{
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "CPF de usuario não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void alterarUsuario(int cpf, String nome, String sobrenome, String login, String senha, String rua, int numero, int cep) throws SQLException{
        try{
            int idEndereco;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT Endereco_idEndereco FROM usuario WHERE cpfUsuario = "+ cpf;
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(resultado != null && resultado.next()){
                idEndereco = resultado.getInt("Endereco_idEndereco");
                sql = "UPDATE endereco SET ruaEndereco = '"+ rua +"', numeroEndereco = "+ numero +", cepEndereco = "+ cep +" WHERE idEndereco = " + idEndereco;
                declaracao.executeUpdate(sql);
                sql = "UPDATE usuario SET nomeUsuario = '"+nome+"', sobrenomeUsuario = '"+sobrenome+"', loginUsuario = '"+login+"', senhaUsuario = '"+senha+"' WHERE cpfUsuario = "+cpf;
                declaracao.executeUpdate(sql);
                JOptionPane.showMessageDialog(
                    null,
                    "Usuario alterado com sucesso!",
                    "Cadastro",
                    1
                );
                conexao.commit();
            }else{
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "CPF de usuario não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public List<Game> consultarRPGs() throws SQLException{   
        try{
            Game game;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT * FROM rpgGames";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(gamesRpg != null){
                gamesRpg.removeAll(gamesRpg);
            }
 
            while(resultado.next()){
                game = new Game();
                game.setTitulo(resultado.getString("tituloGame"));
                game.setPreco(Float.parseFloat(resultado.getString("precoGame")));
                game.setTamanho(Float.parseFloat(resultado.getString("tamanhoGame")));
                
                gamesRpg.add(game);
            }
            conexao.commit();
            return gamesRpg;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public List<Game> consultarFPSs() throws SQLException{   
        try{
            Game game;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT * FROM fpsGames";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(gamesFps != null){
                gamesFps.removeAll(gamesFps);
            }
 
            while(resultado.next()){
                game = new Game();
                game.setTitulo(resultado.getString("tituloGame"));
                game.setPreco(Float.parseFloat(resultado.getString("precoGame")));
                game.setTamanho(Float.parseFloat(resultado.getString("tamanhoGame")));
                
                gamesFps.add(game);
            }
            conexao.commit();
            return gamesFps;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public List<Game> consultarAVTs() throws SQLException{   
        try{
            Game game;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT * FROM aventuraGames";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(gamesAventura != null){
                gamesAventura.removeAll(gamesAventura);
            }
 
            while(resultado.next()){
                game = new Game();
                game.setTitulo(resultado.getString("tituloGame"));
                game.setPreco(Float.parseFloat(resultado.getString("precoGame")));
                game.setTamanho(Float.parseFloat(resultado.getString("tamanhoGame")));
                
                gamesAventura.add(game);
            }
            conexao.commit();
            return gamesAventura;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public List<Game> consultarTodosGames() throws SQLException{   
        try{
            Game game;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT * FROM allGames";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(games != null){
                games.removeAll(games);
            }
 
            while(resultado.next()){
                game = new Game();
                game.setTitulo(resultado.getString("tituloGame"));
                game.setPreco(Float.parseFloat(resultado.getString("precoGame")));
                game.setTamanho(Float.parseFloat(resultado.getString("tamanhoGame")));
                
                games.add(game);
            }
            conexao.commit();
            return games;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public void comprarGame(String tituloGame) throws SQLException{
        try{
            GamesStore gs = new GamesStore();
            Statement declaracao = conexao.createStatement();
            Random r = new Random();
            int chaveAtivacao = r.nextInt(10000, 99999);

            String sql = "SELECT idGame, Desenvolvedora_idDesenvolvedora FROM game WHERE tituloGame = '" + tituloGame+"'";
            ResultSet resultado = declaracao.executeQuery(sql);

            if(resultado != null && resultado.next()){
                int idGame = resultado.getInt("idGame");
                int idDesenvolvedora = resultado.getInt("Desenvolvedora_idDesenvolvedora");
                sql = "SELECT Endereco_idEndereco FROM usuario WHERE cpfUsuario = " + gs.getCpfUsuario();
                resultado = declaracao.executeQuery(sql);
                if(resultado != null && resultado.next()){
                    int idEndereco = resultado.getInt("Endereco_idEndereco");
                    sql = "INSERT INTO usuario_possui_game (Usuario_cpfUsuario, Usuario_Endereco_idEndereco, Game_idGame, Game_Desenvolvedora_idDesenvolvedora, chaveAtivacaoGame) VALUES ("+ gs.getCpfUsuario() +","+ idEndereco +"," + idGame +"," + idDesenvolvedora + ","+chaveAtivacao+")";
                    
                    declaracao.addBatch(sql);
                    declaracao.executeBatch();
                    JOptionPane.showMessageDialog(
                        null,
                        "Compra realizada com sucesso!\nGame: "+tituloGame+"\nChave de ativação: "+chaveAtivacao,
                        "Cadastro",
                        1
                    );
                    conexao.commit();
                }else{
                    conexao.commit();
                    JOptionPane.showMessageDialog(
                        null,
                        "ERRO!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                    );
                }
            }else{
                JOptionPane.showMessageDialog(
                    null,
                    "Game não cadastrado!",
                    "Games Store",
                    JOptionPane.ERROR_MESSAGE
                );
                conexao.commit();
            }
        }catch(SQLException e){
            conexao.rollback();
            System.out.println("aqui");
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public List<Game> consultarGamesDoUsuario() throws SQLException{   
        try{
            Game game;
            int Game_idGame;
            GamesStore gs = new GamesStore();
            Statement declaracao1 = conexao.createStatement();
            Statement declaracao2 = conexao.createStatement();
            
            if(games != null){
                games.removeAll(games);
            }
            
            String sql = "SELECT Game_idGame, chaveAtivacaoGame FROM usuario_possui_game WHERE Usuario_cpfUsuario = "+gs.getCpfUsuario();
            ResultSet resultado1 = declaracao1.executeQuery(sql);

            while(resultado1.next()){
                game = new Game();
                game.setChaveAtivacao(resultado1.getInt("chaveAtivacaoGame"));
                Game_idGame = resultado1.getInt("Game_idGame");
                sql = "SELECT tituloGame, tamanhoGame FROM game WHERE idGame = "+Game_idGame+" ORDER BY tituloGame";
                ResultSet resultado2 = declaracao2.executeQuery(sql);
                while(resultado2.next()){
                    
                    game.setTitulo(resultado2.getString("tituloGame"));
                    game.setTamanho(Float.parseFloat(resultado2.getString("tamanhoGame")));

                    games.add(game);
                }
            }
            conexao.commit();
            return games;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public List<Usuario> consultarTodosUsuarios() throws SQLException{
        try{
            Usuario usuario;
            GamesStore gs = new GamesStore();
            Statement declaracao = conexao.createStatement();
            
            if(usuarios != null){
                usuarios.removeAll(usuarios);
            }
            
            String sql = "SELECT * FROM usuario INNER JOIN endereco ON usuario.Endereco_idEndereco = endereco.idEndereco";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            while(resultado.next()){
                usuario = new Usuario();
                usuario.setCpf(resultado.getInt("cpfUsuario"));
                usuario.setNome(resultado.getString("nomeUsuario"));
                usuario.setSobrenome(resultado.getString("sobrenomeUsuario"));
                usuario.endereco.setRua(resultado.getString("ruaEndereco"));
                usuario.endereco.setNumero(resultado.getInt("numeroEndereco"));
                usuario.endereco.setCep(resultado.getInt("cepEndereco"));
                usuarios.add(usuario);
            }
            conexao.commit();
            return usuarios;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
    
    public void cadastrarGame(String titulo, String genero, Float tamanho, Float preco, String desenvolvedora) throws SQLException{
        try{
            int idDesenvolvedora;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT idDesenvolvedora FROM desenvolvedora WHERE nomeDesenvolvedora = '"+desenvolvedora+"'";            
            ResultSet resultado = declaracao.executeQuery(sql);

            if(resultado != null && resultado.next()){
                idDesenvolvedora = resultado.getInt("idDesenvolvedora");
                sql = "INSERT INTO game (tituloGame, generoGame, tamanhoGame, precoGame, Desenvolvedora_idDesenvolvedora)" +
                      " VALUES ('" + titulo + "','" + genero + "'," + tamanho + "," + preco + "," + idDesenvolvedora + ")";
                declaracao.addBatch(sql);
                declaracao.executeBatch();
                JOptionPane.showMessageDialog(
                    null,
                    "Game cadastrado com sucesso!",
                    "Cadastro",
                    1
                );
                conexao.commit();
            }else{
                conexao.rollback();
                JOptionPane.showMessageDialog(
                    null,
                    "ERRO!",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public Game consultarGame(String titulo) throws SQLException{
        try{
            Game game = new Game();
            int idDesenvolvedora;
            Statement declaracao = conexao.createStatement();
            
            String sql = "SELECT * FROM game WHERE tituloGame = '" + titulo + "'";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            if(resultado != null && resultado.next()){
                game.setTitulo(resultado.getString("tituloGame"));
                game.setGenero(resultado.getString("generoGame"));
                game.setTamanho(resultado.getFloat("tamanhoGame"));
                game.setPreco(resultado.getFloat("precoGame"));
                idDesenvolvedora = resultado.getInt("Desenvolvedora_idDesenvolvedora");
                
                sql = "SELECT nomeDesenvolvedora FROM desenvolvedora WHERE idDesenvolvedora = " + idDesenvolvedora;
                resultado = declaracao.executeQuery(sql);
                if(resultado != null && resultado.next()){
                    game.setDesenvolvedora(resultado.getString("nomeDesenvolvedora"));
                    conexao.commit();
                    JOptionPane.showMessageDialog(
                        null,
                        "Game encontrado!",
                        "Cadastro",
                        1
                    );
                    return game;
                }else{
                    conexao.rollback();
                    JOptionPane.showMessageDialog(
                        null,
                        "ERRO!",
                        "Erro",
                        JOptionPane.ERROR_MESSAGE
                    );
                    return null;
                }
            }else{
                conexao.rollback();
                JOptionPane.showMessageDialog(
                    null,
                    "Jogo não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
                return null;
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }   
    }
    
    public void excluirGame(String titulo) throws SQLException{
        try{
            Statement declaracao = conexao.createStatement();
            String sql = "SELECT * FROM game WHERE tituloGame = '" + titulo +"'";
            ResultSet resultado = declaracao.executeQuery(sql);
            if(resultado != null && resultado.next()){
                int idGameRB = resultado.getInt("idGame");
                
                sql = "DELETE FROM usuario_possui_game WHERE Game_idGame = " + idGameRB;
                declaracao.execute(sql);
                
                sql = "DELETE FROM game WHERE idGame = " + idGameRB;
                declaracao.execute(sql);
                
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "Game excluido com sucesso!",
                    "Cadastro",
                    1
                );
            }else{
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "Game não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public void alterarGame(String titulo, String genero, Float tamanho, Float preco, String desenvolvedora) throws SQLException{
        try{
            int idDesenvolvedora;
            int idGame;
            Statement declaracao = conexao.createStatement();
            Statement declaracao2 = conexao.createStatement();
            
            String sql = "SELECT idGame FROM game WHERE tituloGame = '"+ titulo +"'";
            ResultSet resultado = declaracao.executeQuery(sql);
            String sql2 = "SELECT idDesenvolvedora FROM desenvolvedora WHERE nomeDesenvolvedora = '"+ desenvolvedora +"'";
            ResultSet resultado2 = declaracao2.executeQuery(sql2);
            
            if(resultado != null && resultado.next() && resultado2 != null && resultado2.next()){
                idGame = resultado.getInt("idGame");
                idDesenvolvedora = resultado2.getInt("idDesenvolvedora");
                sql = "UPDATE game SET tituloGame = '"+titulo+"', generoGame = '"+genero+"', tamanhoGame = "+tamanho+", precoGame = "+preco+", Desenvolvedora_idDesenvolvedora = "+idDesenvolvedora+" WHERE idGame = "+idGame;
                declaracao.executeUpdate(sql);
                JOptionPane.showMessageDialog(
                    null,
                    "Game alterado com sucesso!",
                    "Cadastro",
                    1
                );
                conexao.commit();
            }else{
                conexao.commit();
                JOptionPane.showMessageDialog(
                    null,
                    "Game não cadastrado!",
                    "Cadastro",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    public List<Game> consultarDesenvolvedoras() throws SQLException{
        try{
            Game desenvolvedora;
            Statement declaracao = conexao.createStatement();
            
            if(desenvolvedoras != null){
                desenvolvedoras.removeAll(desenvolvedoras);
            }
            
            String sql = "SELECT * FROM desenvolvedora";
            ResultSet resultado = declaracao.executeQuery(sql);
            
            while(resultado.next()){
                desenvolvedora = new Game();
                desenvolvedora.setIdDesenvolvedora(resultado.getInt("idDesenvolvedora"));
                desenvolvedora.setDesenvolvedora(resultado.getString("nomeDesenvolvedora"));
                desenvolvedoras.add(desenvolvedora);
            }
            conexao.commit();
            return desenvolvedoras;
        }catch(SQLException e){
            conexao.rollback();
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }
}//fim da classe
