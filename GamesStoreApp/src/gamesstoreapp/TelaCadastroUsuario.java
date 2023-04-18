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
import javax.swing.JOptionPane;

public class TelaCadastroUsuario extends javax.swing.JFrame {
    public static TelaCadastroUsuario unicaTelaCadastroUsuario;
    
    private BDconnection bdCon;
    private static Connection conexao = null;
    
    public TelaCadastroUsuario() {
        initComponents();
        bdCon = BDconnection.getBDconnection();
        conexao = bdCon.getConexao();
    }
    
    public static TelaCadastroUsuario getTelaCadastroUsuario(){
        if(unicaTelaCadastroUsuario == null){
            unicaTelaCadastroUsuario = new TelaCadastroUsuario();
        }
        return unicaTelaCadastroUsuario;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelTituloTela = new javax.swing.JLabel();
        labelCpf = new javax.swing.JLabel();
        txtCpf = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        labelSobrenome = new javax.swing.JLabel();
        txtSobrenome = new javax.swing.JTextField();
        labelLogin = new javax.swing.JLabel();
        txtLogin = new javax.swing.JTextField();
        labelSenha = new javax.swing.JLabel();
        pswSenha = new javax.swing.JPasswordField();
        btCadastrar = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();
        labelCepEnd = new javax.swing.JLabel();
        txtCepEnd = new javax.swing.JTextField();
        labelRuaEnd = new javax.swing.JLabel();
        txtRuaEnd = new javax.swing.JTextField();
        labelNumeroEnd = new javax.swing.JLabel();
        txtNumeroEnd = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Usuários");
        setResizable(false);
        setSize(new java.awt.Dimension(960, 560));

        labelTituloTela.setFont(new java.awt.Font("Consolas", 3, 50)); // NOI18N
        labelTituloTela.setText("CADASTRO");

        labelCpf.setText("CPF:");

        labelNome.setText("Nome:");

        labelSobrenome.setText("Sobrenome:");

        labelLogin.setText("Login:");

        labelSenha.setText("Senha:");

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

        labelCepEnd.setText("CEP:");

        labelRuaEnd.setText("Rua:");

        labelNumeroEnd.setText("Numero:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(248, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelTituloTela)
                        .addGap(333, 333, 333))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(131, 131, 131))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelNome)
                                    .addComponent(labelCpf)
                                    .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelLogin)
                                    .addComponent(labelCepEnd)
                                    .addComponent(txtCepEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelRuaEnd)
                                    .addComponent(txtRuaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelSobrenome)
                                            .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelSenha)
                                            .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelNumeroEnd)
                                            .addComponent(txtNumeroEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(194, 194, 194))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(labelTituloTela)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelCpf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelSobrenome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSobrenome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelLogin)
                    .addComponent(labelSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pswSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelCepEnd)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCepEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelRuaEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRuaEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelNumeroEnd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNumeroEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btConsultar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        GamesStore.getGamesStore().setVisible(true);
        limpar();
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        cadUsuario();
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed
        conUsuario();
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        excUsuario();
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        altUsuario();
    }//GEN-LAST:event_btAlterarActionPerformed

    private void cadUsuario(){
        if(
            txtCpf.getText().isEmpty()||
            txtNome.getText().isEmpty()||
            txtSobrenome.getText().isEmpty()||
            txtLogin.getText().isEmpty()||
            pswSenha.getText().isEmpty()||
            txtCepEnd.getText().isEmpty()||
            txtRuaEnd.getText().isEmpty()||
            txtNumeroEnd.getText().isEmpty()
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
                bdCon.cadastrarUsuario(Integer.parseInt(txtCpf.getText()), txtNome.getText(), txtSobrenome.getText(), txtLogin.getText(), pswSenha.getText(), txtRuaEnd.getText(), Integer.parseInt(txtNumeroEnd.getText()), Integer.parseInt(txtCepEnd.getText()));
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
    
    public void conUsuario(){
        if(txtCpf.getText().isEmpty()){
            limpar();
            JOptionPane.showMessageDialog(
                null,
                "O campo cpf nao pode ser vazio!",
                "Cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }else{
            try{
                Usuario usuario = bdCon.consultarUsuario(Integer.parseInt(txtCpf.getText()));
                if(usuario != null){
                    txtNome.setText(usuario.getNome());
                    txtSobrenome.setText(usuario.getSobrenome());
                    txtLogin.setText(usuario.getLogin());
                    txtCepEnd.setText(Integer.toString(usuario.endereco.getCep()));
                    txtRuaEnd.setText(usuario.endereco.getRua());
                    txtNumeroEnd.setText(Integer.toString(usuario.endereco.getNumero()));
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
    
    public void excUsuario(){
        if(txtCpf.getText().isEmpty()){
            limpar();
            JOptionPane.showMessageDialog(
                null,
                "O campo cpf nao pode ser vazio!",
                "Cadastro",
                JOptionPane.ERROR_MESSAGE
            );
        }else{
            try{
                bdCon.excluirUsuario(Integer.parseInt(txtCpf.getText()));
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
    
    public void altUsuario(){
        if(
            txtCpf.getText().isEmpty()||
            txtNome.getText().isEmpty()||
            txtSobrenome.getText().isEmpty()||
            txtLogin.getText().isEmpty()||
            pswSenha.getText().isEmpty()||
            txtCepEnd.getText().isEmpty()||
            txtRuaEnd.getText().isEmpty()||
            txtNumeroEnd.getText().isEmpty()
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
                bdCon.alterarUsuario(Integer.parseInt(txtCpf.getText()), txtNome.getText(), txtSobrenome.getText(), txtLogin.getText(), pswSenha.getText(), txtRuaEnd.getText(), Integer.parseInt(txtNumeroEnd.getText()), Integer.parseInt(txtCepEnd.getText()));
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
    
    private void limpar(){
        txtCpf.setText("");
        txtNome.setText("");
        txtSobrenome.setText("");
        txtLogin.setText("");
        pswSenha.setText("");
        txtCepEnd.setText("");
        txtRuaEnd.setText("");
        txtNumeroEnd.setText("");
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btVoltar;
    private javax.swing.JLabel labelCepEnd;
    private javax.swing.JLabel labelCpf;
    private javax.swing.JLabel labelLogin;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNumeroEnd;
    private javax.swing.JLabel labelRuaEnd;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelSobrenome;
    private javax.swing.JLabel labelTituloTela;
    private javax.swing.JPasswordField pswSenha;
    private javax.swing.JTextField txtCepEnd;
    private javax.swing.JTextField txtCpf;
    private javax.swing.JTextField txtLogin;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNumeroEnd;
    private javax.swing.JTextField txtRuaEnd;
    private javax.swing.JTextField txtSobrenome;
    // End of variables declaration//GEN-END:variables
}
