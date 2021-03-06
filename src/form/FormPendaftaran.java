/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package form;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import workshopapp.Koneksi;

/**
 *
 * @author Sultan
 */
public class FormPendaftaran extends javax.swing.JFrame {

    /**
     * Creates new form FormPendaftaran
     */
    public FormPendaftaran() {
        initComponents();
    }

    public void getHideLabel(){
        lIdSesi.setVisible(false);
        lIdPeserta.setVisible(false);
    }
    
    public int genID() {
        Random r = new Random(System.currentTimeMillis());
        int number = 10000;
        for(int counter=1; counter<=1;counter++){
            number = 10000+r.nextInt(60000);
        }
        return number;
    }
    
    public void getDataSesi(String idSesi){
        String SQL = "SELECT (SELECT nama_narasumber FROM tb_narasumber n WHERE n.id_narasumber = s.id_narasumber) AS nama_narasumber, "
                + "(SELECT nama_materi FROM tb_materi m WHERE m.id_materi = s.id_materi) AS nama_materi, "
                + "(SELECT nama_ruangan FROM tb_ruangan r WHERE r.id_ruangan = s.id_ruangan) AS nama_ruangan, "
                + "tema, tanggal_mulai, tanggal_selesai, id_sesi "
                + "FROM tb_sesi s WHERE s.id_sesi = '"+idSesi+"'";
        ResultSet rs = Koneksi.executeQuery(SQL);
        try {
            while(rs.next()) {
                lNarasumber.setText(": "+rs.getString(1));
                lMateri.setText(": "+rs.getString(2));
                lRuangan.setText(": "+rs.getString(3));
                lTema.setText(": "+rs.getString(4));
                lMulai.setText(": "+rs.getString(5));
                lSelesai.setText(": "+rs.getString(6));
                lIdSesi.setText(rs.getString(7));
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormUtama.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getCekPeserta(){
        String SQL = "SELECT count(*) FROM tb_peserta_sesi WHERE id_sesi = '"+lIdSesi.getText()+"' AND id_peserta = '"+tIdAnggota.getText()+"'";
        ResultSet rs = Koneksi.executeQuery(SQL);
        try{
            if(rs.next()){
                int count = Integer.valueOf(rs.getString(1));
                int s = 1;
                if(count >= s){
                    JOptionPane.showMessageDialog(this, "Kamu sudah terdaftar", "Gagal", JOptionPane.INFORMATION_MESSAGE);
                }else{
                    getDataPeserta();
                }
            }
        }catch(SQLException ex){
            Logger.getLogger(FormPendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDataPeserta(){
        String SQL = "SELECT * FROM peserta WHERE id_peserta = '"+tIdAnggota.getText()+"'";
        ResultSet rs = Koneksi.executeQuery(SQL);
        try {
            if(rs.next()) {
                lIdPeserta.setText(rs.getString(1));
                lNama.setText(": "+rs.getString(2));
                lTelp.setText(": "+rs.getString(3));
                lJenisKelamin.setText(": "+rs.getString(4));
                lTempatLahir.setText(": "+rs.getString(5));
                lTanggalLahir.setText(": "+rs.getString(6));
                lEmail.setText(": "+rs.getString(7));
                lAlamat.setText(": "+rs.getString(8));
                bDaftar.setEnabled(true);
            }else{
                JOptionPane.showMessageDialog(this, "Data tidak ditemukan", "Gagal", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException ex) {
            Logger.getLogger(FormPendaftaran.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void getDaftar(){
        if ("".equals(lIdSesi.getText()) || "".equals(lIdPeserta.getText())) {
            JOptionPane.showMessageDialog(this, "Harap Lengkapi Data", "Error", JOptionPane.WARNING_MESSAGE);
        } else {
            String SQL = "INSERT INTO tb_peserta_sesi (id_daftar, id_sesi, id_peserta) "
                    + "VALUES('DAF-2018"+genID()+"','"+lIdSesi.getText()+"','"+lIdPeserta.getText()+"')";
            int status = Koneksi.execute(SQL);
            if (status == 1) {
                JOptionPane.showMessageDialog(this, "Berhasil terdaftar", "Sukses", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal ditambahkan", "Sukses", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lTema = new javax.swing.JLabel();
        lNarasumber = new javax.swing.JLabel();
        lMateri = new javax.swing.JLabel();
        lMulai = new javax.swing.JLabel();
        lRuangan = new javax.swing.JLabel();
        lSelesai = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        tIdAnggota = new javax.swing.JTextField();
        bCek = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        lNama = new javax.swing.JLabel();
        lTelp = new javax.swing.JLabel();
        lJenisKelamin = new javax.swing.JLabel();
        lTanggalLahir = new javax.swing.JLabel();
        lTempatLahir = new javax.swing.JLabel();
        lEmail = new javax.swing.JLabel();
        lAlamat = new javax.swing.JLabel();
        lIdPeserta = new javax.swing.JLabel();
        lIdSesi = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        bDaftar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("PENDAFTARAN");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 350, 50));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 430, 70));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Tema");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel2.setText("Narasumber");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel3.setText("Materi");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setText("Mulai");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, -1));

        jLabel5.setText("Selesai");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 100, -1, -1));

        jLabel6.setText("Ruangan");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, -1));

        lTema.setText(": ");
        jPanel1.add(lTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        lNarasumber.setText(": ");
        jPanel1.add(lNarasumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, -1, -1));

        lMateri.setText(": ");
        jPanel1.add(lMateri, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, -1, -1));

        lMulai.setText(": ");
        jPanel1.add(lMulai, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        lRuangan.setText(": ");
        jPanel1.add(lRuangan, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, -1, -1));

        lSelesai.setText(": ");
        jPanel1.add(lSelesai, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 100, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 410, 10));

        jLabel14.setText("Masukkan ID Anggota :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));
        jPanel1.add(tIdAnggota, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 220, 20));

        bCek.setText("Cek");
        bCek.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCekActionPerformed(evt);
            }
        });
        jPanel1.add(bCek, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 130, 60, 20));

        jLabel15.setText("Nama");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        jLabel16.setText("No. Telepon");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, -1, -1));

        jLabel17.setText("Jenis Kelamin");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, -1, -1));

        jLabel18.setText("Tempat Lahir");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        jLabel19.setText("Tanggal Lahir");
        jPanel1.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, -1));

        jLabel20.setText("Email");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 200, -1, -1));

        jLabel21.setText("Alamat");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, -1, -1));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 410, 10));

        lNama.setText(": ");
        jPanel1.add(lNama, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, -1, -1));

        lTelp.setText(": ");
        jPanel1.add(lTelp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        lJenisKelamin.setText(": ");
        jPanel1.add(lJenisKelamin, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        lTanggalLahir.setText(": ");
        jPanel1.add(lTanggalLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, -1, -1));

        lTempatLahir.setText(": ");
        jPanel1.add(lTempatLahir, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 260, -1, -1));

        lEmail.setText(": ");
        jPanel1.add(lEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        lAlamat.setText(": ");
        jPanel1.add(lAlamat, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, -1, -1));

        lIdPeserta.setText("idPeserta");
        jPanel1.add(lIdPeserta, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 280, -1, -1));

        lIdSesi.setText("idSesi");
        jPanel1.add(lIdSesi, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 280, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 430, 310));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        bDaftar.setText("Daftar");
        bDaftar.setEnabled(false);
        bDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDaftarActionPerformed(evt);
            }
        });
        jPanel2.add(bDaftar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 410, 20));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 430, 40));

        setSize(new java.awt.Dimension(446, 458));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bCekActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCekActionPerformed
        getCekPeserta();
    }//GEN-LAST:event_bCekActionPerformed

    private void bDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDaftarActionPerformed
        getDaftar();
    }//GEN-LAST:event_bDaftarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPendaftaran.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormPendaftaran().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCek;
    private javax.swing.JButton bDaftar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lAlamat;
    private javax.swing.JLabel lEmail;
    private javax.swing.JLabel lIdPeserta;
    private javax.swing.JLabel lIdSesi;
    private javax.swing.JLabel lJenisKelamin;
    private javax.swing.JLabel lMateri;
    private javax.swing.JLabel lMulai;
    private javax.swing.JLabel lNama;
    private javax.swing.JLabel lNarasumber;
    private javax.swing.JLabel lRuangan;
    private javax.swing.JLabel lSelesai;
    private javax.swing.JLabel lTanggalLahir;
    private javax.swing.JLabel lTelp;
    private javax.swing.JLabel lTema;
    private javax.swing.JLabel lTempatLahir;
    private javax.swing.JTextField tIdAnggota;
    // End of variables declaration//GEN-END:variables
}
