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
import javax.swing.table.DefaultTableModel;


public class TelaLojaGames extends javax.swing.JFrame {
    public static TelaLojaGames unicaTelaLojaGames;
    
    private BDconnection bdCon;
    private static Connection conexao = null;
    
    private List<Game> listaGames;
    
    public TelaLojaGames() {
        initComponents();
        bdCon = BDconnection.getBDconnection();
        conexao = bdCon.getConexao();
        listarGames();
    }
    
    public static TelaLojaGames getTelaLojaGames(){
        if(unicaTelaLojaGames == null){
            unicaTelaLojaGames = new TelaLojaGames();
        }
        return unicaTelaLojaGames;
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogo = new javax.swing.JLabel();
        labelSeleGene = new javax.swing.JLabel();
        comboGenero = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGames = new javax.swing.JTable();
        btComprar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Games Store");
        setResizable(false);
        setSize(new java.awt.Dimension(960, 560));

        labelLogo.setFont(new java.awt.Font("Consolas", 3, 50)); // NOI18N
        labelLogo.setText("GAMES STORE");

        labelSeleGene.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        labelSeleGene.setText("SELECIONE O GENERO:");

        comboGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos", "RPG", "FPS", "Aventura" }));
        comboGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboGeneroActionPerformed(evt);
            }
        });

        tabelaGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Tamanho", "Preco"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGames.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaGames.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaGames);

        btComprar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btComprar.setText("Comprar");
        btComprar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btComprarActionPerformed(evt);
            }
        });

        btVoltar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
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
                .addContainerGap(256, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelLogo)
                        .addGap(299, 299, 299))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(327, 327, 327))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSeleGene, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(204, 204, 204))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelLogo)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(comboGenero)
                    .addComponent(labelSeleGene, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btComprar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btVoltar)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        TelaMenu.getTelaMenu().setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void comboGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboGeneroActionPerformed
        switch(comboGenero.getSelectedIndex()){
            case 1:
                listarRPG();
                break;
            case 2:
                listarFPS();
                break;
            case 3:
                listarAventura();
                break;
            default:
                listarGames();
                break;
        }  
    }//GEN-LAST:event_comboGeneroActionPerformed

    private void btComprarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btComprarActionPerformed
        comprarGame();
    }//GEN-LAST:event_btComprarActionPerformed

    public void listarRPG(){
        try{
            listaGames = bdCon.consultarRPGs();
            DefaultTableModel modelo = (DefaultTableModel) tabelaGames.getModel();
            int posLin = 0;
            modelo.setRowCount(posLin);

            for(Game game : listaGames){
                modelo.insertRow(posLin, new Object []{game.getTitulo(), game.getTamanho(), game.getPreco()});
                posLin++;
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
    
    public void listarFPS(){
        try{
            listaGames = bdCon.consultarFPSs();
            DefaultTableModel modelo = (DefaultTableModel) tabelaGames.getModel();
            int posLin = 0;
            modelo.setRowCount(posLin);

            for(Game game : listaGames){
                modelo.insertRow(posLin, new Object []{game.getTitulo(), game.getTamanho(), game.getPreco()});
                posLin++;
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
    
    public void listarAventura(){
        try{
            listaGames = bdCon.consultarAVTs();
            DefaultTableModel modelo = (DefaultTableModel) tabelaGames.getModel();
            int posLin = 0;
            modelo.setRowCount(posLin);

            for(Game game : listaGames){
                modelo.insertRow(posLin, new Object []{game.getTitulo(), game.getTamanho(), game.getPreco()});
                posLin++;
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
    
    public void listarGames(){
        try{
            listaGames = bdCon.consultarTodosGames();
            DefaultTableModel modelo = (DefaultTableModel) tabelaGames.getModel();
            int posLin = 0;
            modelo.setRowCount(posLin);

            for(Game game : listaGames){
                modelo.insertRow(posLin, new Object []{game.getTitulo(), game.getTamanho(), game.getPreco()});
                posLin++;
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
    
    public void comprarGame(){
        try{
            String tituloGame = "";
            int posLin = tabelaGames.getSelectedRow();
            tituloGame = tabelaGames.getModel().getValueAt(posLin,0).toString();
            System.out.println(tituloGame);
            bdCon.comprarGame(tituloGame);
        }catch(SQLException e){
            JOptionPane.showMessageDialog(
                null,
                "Error Code: " + ((SQLException) e).getErrorCode() + "\n" + "Message: " + e.getMessage(),
                "Erro de conexao",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btComprar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JComboBox<String> comboGenero;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JLabel labelSeleGene;
    private javax.swing.JTable tabelaGames;
    // End of variables declaration//GEN-END:variables
}
