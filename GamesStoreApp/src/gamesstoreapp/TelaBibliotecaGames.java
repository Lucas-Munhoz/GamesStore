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

public class TelaBibliotecaGames extends javax.swing.JFrame {

    public static TelaBibliotecaGames unicaTelaBibliotecaGames;
    
    private BDconnection bdCon;
    private static Connection conexao = null;
    
    private List<Game> listaGames;
    
    public TelaBibliotecaGames() {
        initComponents();
        bdCon = BDconnection.getBDconnection();
        conexao = bdCon.getConexao();
        listarGames();
    }
    
    public static TelaBibliotecaGames getTelaBibliotecaGames(){
        if(unicaTelaBibliotecaGames == null){
            unicaTelaBibliotecaGames = new TelaBibliotecaGames();
        }
        return unicaTelaBibliotecaGames;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelLogo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaGames = new javax.swing.JTable();
        btAtualizar = new javax.swing.JButton();
        btVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Biblioteca");
        setResizable(false);
        setSize(new java.awt.Dimension(960, 560));

        labelLogo.setFont(new java.awt.Font("Consolas", 3, 50)); // NOI18N
        labelLogo.setText("BIBLIOTECA");

        tabelaGames.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Titulo", "Tamanho", "Chave Ativação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabelaGames.setColumnSelectionAllowed(true);
        tabelaGames.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tabelaGames.setEnabled(false);
        tabelaGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaGames.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tabelaGames.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabelaGames);
        tabelaGames.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        btAtualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btAtualizar.setText("Atualizar");
        btAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAtualizarActionPerformed(evt);
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
                .addContainerGap(206, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelLogo)
                        .addGap(318, 318, 318))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(333, 333, 333))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(labelLogo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btAtualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btVoltar)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVoltarActionPerformed
        setVisible(false);
        TelaMenu.getTelaMenu().setVisible(true);
    }//GEN-LAST:event_btVoltarActionPerformed

    private void btAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAtualizarActionPerformed
        listarGames();
    }//GEN-LAST:event_btAtualizarActionPerformed

    public void listarGames(){
        try{
            listaGames = bdCon.consultarGamesDoUsuario();
            DefaultTableModel modelo = (DefaultTableModel) tabelaGames.getModel();
            int posLin = 0;
            modelo.setRowCount(posLin);

            for(Game game : listaGames){
                modelo.insertRow(posLin, new Object []{game.getTitulo(), game.getTamanho(), game.getChaveAtivacao()});
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAtualizar;
    private javax.swing.JButton btVoltar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelLogo;
    private javax.swing.JTable tabelaGames;
    // End of variables declaration//GEN-END:variables
}
