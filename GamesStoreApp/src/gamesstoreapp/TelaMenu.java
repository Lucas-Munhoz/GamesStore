//Lucas Andre Munhoz da Cruz
//Joao Victor Viera dos Anjos
//Matheus Augusto da Cruz Grossi
//RA 2418312
//RA 2311500
//RA 2348110
//JDK 18.0.1.1
//Netbeans 15

package gamesstoreapp;

public class TelaMenu extends javax.swing.JFrame {
    
    private final GamesStore gs = GamesStore.getGamesStore();
    private Boolean adm;
    
    public static TelaMenu unicaTelaMenu;
    
    public TelaMenu() {
        adm = gs.getAdm();
        initComponents();
        if(adm == false){
            btCadastrarGames.setEnabled(false);
            btCadastrarGames.setVisible(false);
            btTodosUsuarios.setEnabled(false);
            btTodosUsuarios.setVisible(false);
        }else{
            btCadastrarGames.setEnabled(true);
            btCadastrarGames.setVisible(true);
            btTodosUsuarios.setEnabled(true);
            btTodosUsuarios.setVisible(true);
        }
    }
    

    public static TelaMenu getTelaMenu(){
        if(unicaTelaMenu == null){
            unicaTelaMenu = new TelaMenu();
        }
        return unicaTelaMenu;
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogo = new javax.swing.JLabel();
        labelBemvindo = new javax.swing.JLabel();
        btCadastrarGames = new javax.swing.JButton();
        btTodosUsuarios = new javax.swing.JButton();
        btLoja = new javax.swing.JButton();
        btBiblioteca = new javax.swing.JButton();
        btSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Menu");
        setResizable(false);
        setSize(new java.awt.Dimension(960, 560));

        labelLogo.setFont(new java.awt.Font("Consolas", 3, 70)); // NOI18N
        labelLogo.setText("GAMES STORE");

        labelBemvindo.setText("Bem vindo ...");

        btCadastrarGames.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btCadastrarGames.setText("Cadastrar Games");
        btCadastrarGames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarGamesActionPerformed(evt);
            }
        });

        btTodosUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btTodosUsuarios.setText("Todos Usuarios");
        btTodosUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTodosUsuariosActionPerformed(evt);
            }
        });

        btLoja.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btLoja.setText("Loja");
        btLoja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLojaActionPerformed(evt);
            }
        });

        btBiblioteca.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btBiblioteca.setText("Biblioteca");
        btBiblioteca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBibliotecaActionPerformed(evt);
            }
        });

        btSair.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btSair.setText("Sair");
        btSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSairActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(277, 277, 277)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelBemvindo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(265, 265, 265))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSair, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(btBiblioteca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
                            .addComponent(btLoja, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE))
                        .addGap(322, 322, 322))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btTodosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCadastrarGames, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(347, 347, 347))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(labelLogo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelBemvindo)
                .addGap(18, 18, 18)
                .addComponent(btCadastrarGames, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTodosUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(btLoja, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btBiblioteca, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btSair, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSairActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btSairActionPerformed

    private void btLojaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLojaActionPerformed
        setVisible(false);
        TelaLojaGames.getTelaLojaGames().setVisible(true);
    }//GEN-LAST:event_btLojaActionPerformed

    private void btCadastrarGamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarGamesActionPerformed
        setVisible(false);
        TelaCadastroGame.getTelaCadastroGame().setVisible(true);
    }//GEN-LAST:event_btCadastrarGamesActionPerformed

    private void btBibliotecaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBibliotecaActionPerformed
        setVisible(false);
        TelaBibliotecaGames.getTelaBibliotecaGames().setVisible(true);
    }//GEN-LAST:event_btBibliotecaActionPerformed

    private void btTodosUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTodosUsuariosActionPerformed
        setVisible(false);
        TelaUsuarios.getTelaUsuarios().setVisible(true);
    }//GEN-LAST:event_btTodosUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBiblioteca;
    private javax.swing.JButton btCadastrarGames;
    private javax.swing.JButton btLoja;
    private javax.swing.JButton btSair;
    private javax.swing.JButton btTodosUsuarios;
    private javax.swing.JLabel labelBemvindo;
    private javax.swing.JLabel labelLogo;
    // End of variables declaration//GEN-END:variables
}
