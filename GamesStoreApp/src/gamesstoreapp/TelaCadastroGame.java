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
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class TelaCadastroGame extends javax.swing.JFrame {
    
    public static TelaCadastroGame unicaTelaCadastroGame;
    
    private List<Game> desenvolvedoras;
    
    private BDconnection bdCon;
    
    public TelaCadastroGame() {
        initComponents();
        bdCon = BDconnection.getBDconnection();
        carregaComboGames();
    }
    
    public static TelaCadastroGame getTelaCadastroGame(){
        if(unicaTelaCadastroGame == null){
            unicaTelaCadastroGame = new TelaCadastroGame();
        }
        return unicaTelaCadastroGame;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTituloTela = new javax.swing.JLabel();
        labelTitulo = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        labelGenero = new javax.swing.JLabel();
        txtGenero = new javax.swing.JTextField();
        labelTamanho = new javax.swing.JLabel();
        txtTamanho = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        labelDesenvolvedora = new javax.swing.JLabel();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        comboDesenvolvedora = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Games");

        labelTituloTela.setFont(new java.awt.Font("Consolas", 3, 50)); // NOI18N
        labelTituloTela.setText("CADASTRO DE GAMES");

        labelTitulo.setText("Titulo:");

        labelGenero.setText("Genero:");

        labelTamanho.setText("Tamanho (GB's):");

        labelPreco.setText("Preço:");

        labelDesenvolvedora.setText("Desenvolvedora:");

        btCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        btConsultar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        btAlterar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        btVoltar.setText("Voltar");
        btVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVoltarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(131, 131, 131))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(labelTitulo)
                                        .addComponent(txtTamanho, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                        .addComponent(labelTamanho)
                                        .addComponent(labelDesenvolvedora)
                                        .addComponent(comboDesenvolvedora, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelGenero)
                                                .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelPreco)))))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(194, 194, 194))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTituloTela)
                        .addGap(217, 217, 217))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(labelTituloTela)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelGenero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTamanho)
                    .addComponent(labelPreco))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelDesenvolvedora)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboDesenvolvedora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        TelaMenu.getTelaMenu().setVisible(true);
        limpar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        cadGame();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        conGame();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excGame();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        altGame();
    }//GEN-LAST:event_btAlterarActionPerformed

    
    private void cadGame(){
        if(
            txtTitulo.getText().isEmpty()||
            txtGenero.getText().isEmpty()||
            txtTamanho.getText().isEmpty()||
            txtPreco.getText().isEmpty()||
            comboDesenvolvedora.getSelectedIndex() == 0
        ){
            JOptionPane.showMessageDialog(
                null,
                "Todos os campos devem ser preenchidos!",
                "Erro de cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }
        else{
            try{
                bdCon.cadastrarGame(txtTitulo.getText(), txtGenero.getText(), Float.parseFloat(txtTamanho.getText()), Float.parseFloat(txtPreco.getText()), comboDesenvolvedora.getSelectedItem().toString());
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(
                    null,
                    "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                    "Erro de conexao",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        limpar();
    }
    
    public void conGame(){
        if(txtTitulo.getText().isEmpty()){
            limpar();
            JOptionPane.showMessageDialog(
                null,
                "O campo titulo nao pode ser vazio!",
                "Cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }else{
            try{
                Game game = bdCon.consultarGame(txtTitulo.getText());
                if(game != null){
                    txtTitulo.setText(game.getTitulo());
                    txtGenero.setText(game.getGenero());
                    txtTamanho.setText(Float.toString(game.getTamanho()));
                    txtPreco.setText(Float.toString(game.getPreco()));
                    comboDesenvolvedora.setSelectedItem(game.getDesenvolvedora());
                }
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(
                    null,
                    "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                    "Erro de conexao",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    public void excGame(){
        if(txtTitulo.getText().isEmpty()){
            limpar();
            JOptionPane.showMessageDialog(
                null,
                "O campo titulo nao pode ser vazio!",
                "Cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }else{
            try{
                bdCon.excluirGame(txtTitulo.getText());
                limpar();
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(
                    null,
                    "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                    "Erro de conexao",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }
    
    public void altGame(){
        if(
            txtTitulo.getText().isEmpty()||
            txtGenero.getText().isEmpty()||
            txtTamanho.getText().isEmpty()||
            txtPreco.getText().isEmpty()||
            comboDesenvolvedora.getSelectedIndex() == 0
        ){
            JOptionPane.showMessageDialog(
                null,
                "Todos os campos devem ser preenchidos!",
                "Erro de cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }
        else{
            try{
                bdCon.alterarGame(txtTitulo.getText(), txtGenero.getText(), Float.parseFloat(txtTamanho.getText()), Float.parseFloat(txtPreco.getText()), comboDesenvolvedora.getSelectedItem().toString());
            }
            catch(SQLException e){
                JOptionPane.showMessageDialog(
                    null,
                    "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                    "Erro de conexao",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
        limpar();
    }
    
    public void carregaComboGames(){
        try{
            comboDesenvolvedora.removeAllItems();
            comboDesenvolvedora.addItem("Escolha uma Desenvolvedora");
            desenvolvedoras = bdCon.consultarDesenvolvedoras();
            for(Game desenvolvedora : desenvolvedoras){
                comboDesenvolvedora.addItem(desenvolvedora.getDesenvolvedora().toString());
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }        
    }
    
    private void limpar(){
        txtTitulo.setText("");
        txtGenero.setText("");
        txtTamanho.setText("");
        txtPreco.setText("");
        comboDesenvolvedora.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> comboDesenvolvedora;
    private javax.swing.JLabel labelDesenvolvedora;
    private javax.swing.JLabel labelGenero;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelTitulo;
    private javax.swing.JLabel labelTituloTela;
    private javax.swing.JTextField txtGenero;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtTamanho;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
