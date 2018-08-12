/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStoneWall.App;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.apache.commons.io.FilenameUtils;
import DataStoneWall.Cryptography.AppCipher;
import DataStoneWall.QRCode.QRCodeWriterReader;
import DataStoneWall.Steganography.LSBEncoding;
import DataStoneWall.Utility.FileUtility;
import DataStoneWall.Utility.ImageBase64;
import DataStoneWall.Utility.ImageUtility;
import DataStoneWall.Utility.Message;
import DataStoneWall.Utility.RecoverImage;
import DataStoneWall.Utility.TransformImage;

/**
 *
 * @author AbdulRehman
 */
public class MainWindow extends javax.swing.JFrame {

    public String data = "";
    BufferedImage coverImage = null;
    BufferedImage qrImage = null;
    BufferedImage targetImage = null;
    BufferedImage stegoImageRead = null;
    ImageUtility imageUtility = new ImageUtility();
    String encodedData;
    String fileExt = "";
    String targetfileExt = "";
    boolean isTransformed = false;
    boolean isRecovered = false;
    AppCipher crypto = new AppCipher();

    public MainWindow() {
        initComponents();
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMainWindowTab = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTargetImage = new javax.swing.JLabel();
        jCoverImage = new javax.swing.JLabel();
        jButtonCoverImage = new javax.swing.JButton();
        jButtonTargetImage = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTranformImage = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButtonSaveStegoImage = new javax.swing.JButton();
        jQRImage = new javax.swing.JLabel();
        jStegoImage = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButtonLoadData = new javax.swing.JButton();
        jButtonGenQr = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTAData = new javax.swing.JTextArea();
        jLabel12 = new javax.swing.JLabel();
        jButtonApplyTransformation = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jButtonChooseStego = new javax.swing.JButton();
        jRealImage = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jImageDecodeRespose = new javax.swing.JTextArea();
        jButtonDecodeReset = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jButtonChooseQR = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabelResponse = new javax.swing.JTextArea();
        jButtonChooseQRReset = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jRBText = new javax.swing.JRadioButton();
        jRBUrl = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jButtonChooseFile = new javax.swing.JButton();
        jRBFile = new javax.swing.JRadioButton();
        jTFURL = new javax.swing.JTextField();
        jButtonEncode = new javax.swing.JButton();
        jShowImage = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jFileSeletedName = new javax.swing.JTextArea();
        jButtonEncodeReset1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Data-StoneWall");
        setBackground(new java.awt.Color(0, 102, 255));
        setLocation(new java.awt.Point(400, 100));
        setMinimumSize(new java.awt.Dimension(750, 483));
        setName("mainWindow"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(750, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jMainWindowTab.setBackground(java.awt.SystemColor.window);
        jMainWindowTab.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        jMainWindowTab.setAutoscrolls(true);
        getContentPane().setBackground(Color.WHITE);
        jMainWindowTab.setName("Encode"); // NOI18N
        jMainWindowTab.setSize(700, 500);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Steganography");

        jTargetImage.setText("Target");
        jTargetImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jCoverImage.setText("Cover");
        jCoverImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jCoverImage.setPreferredSize(new java.awt.Dimension(40, 18));

        jButtonCoverImage.setText("Browse Cover Image");
        jButtonCoverImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCoverImageActionPerformed(evt);
            }
        });

        jButtonTargetImage.setText("Browse Target Image");
        jButtonTargetImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonTargetImageActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("QR Code Image");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Target Image");

        jTranformImage.setText("DWT");
        jTranformImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Transformation");

        jButtonSaveStegoImage.setText("Save Stego Image");
        jButtonSaveStegoImage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveStegoImageActionPerformed(evt);
            }
        });

        jQRImage.setText("QR");
        jQRImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jQRImage.setPreferredSize(new java.awt.Dimension(40, 18));

        jStegoImage.setText("Stego");
        jStegoImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Data");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Cover Image");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("QR Code Image");

        jButtonLoadData.setText("Reset");
        jButtonLoadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadDataActionPerformed(evt);
            }
        });

        jButtonGenQr.setText("Generate QR Code");
        jButtonGenQr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGenQrActionPerformed(evt);
            }
        });

        jTAData.setColumns(20);
        jTAData.setLineWrap(true);
        jTAData.setRows(5);
        jTAData.setWrapStyleWord(true);
        jScrollPane2.setViewportView(jTAData);

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Stego Image");

        jButtonApplyTransformation.setText("Apply Tranformation");
        jButtonApplyTransformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonApplyTransformationActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel6))
                        .addGap(95, 95, 95)
                        .addComponent(jLabel8)
                        .addGap(113, 113, 113)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jQRImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jTargetImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonLoadData, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonGenQr, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonTargetImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonApplyTransformation, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSaveStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(106, 106, 106)
                        .addComponent(jLabel12)
                        .addGap(111, 111, 111)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jTranformImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel4)
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel6)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jQRImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jCoverImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTargetImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButtonLoadData)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonGenQr)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonCoverImage)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonTargetImage)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonApplyTransformation)
                        .addGap(7, 7, 7)
                        .addComponent(jButtonSaveStegoImage)))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel12)
                    .addComponent(jLabel10))
                .addGap(5, 5, 5)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTranformImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jStegoImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jMainWindowTab.addTab("Steganography", jPanel4);

        jButtonChooseStego.setText("Choose PNG");
        jButtonChooseStego.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseStegoActionPerformed(evt);
            }
        });

        jRealImage.setText("jLabel8");
        jRealImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Read Stego Image");

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Encrypted and After Decrypt Message");

        jImageDecodeRespose.setEditable(false);
        jImageDecodeRespose.setColumns(20);
        jImageDecodeRespose.setLineWrap(true);
        jImageDecodeRespose.setRows(5);
        jImageDecodeRespose.setWrapStyleWord(true);
        jImageDecodeRespose.setEnabled(false);
        jScrollPane5.setViewportView(jImageDecodeRespose);

        jButtonDecodeReset.setText("Reset");
        jButtonDecodeReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDecodeResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRealImage, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 455, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jButtonChooseStego, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonDecodeReset, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(52, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(9, 9, 9))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jRealImage, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane5))
                .addGap(22, 22, 22)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonChooseStego)
                    .addComponent(jButtonDecodeReset))
                .addGap(179, 179, 179))
        );

        jMainWindowTab.addTab("Read Stego Image", jPanel5);

        jPanel2.setBackground(javax.swing.UIManager.getDefaults().getColor("window"));
        jPanel2.setPreferredSize(new java.awt.Dimension(740, 495));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel5.setText("QR Code Decode");
        jLabel5.setAlignmentX(40.0F);

        jButtonChooseQR.setText("Choose PNG File");
        jButtonChooseQR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseQRActionPerformed(evt);
            }
        });

        jLabelResponse.setEditable(false);
        jLabelResponse.setColumns(20);
        jLabelResponse.setLineWrap(true);
        jLabelResponse.setRows(5);
        jLabelResponse.setWrapStyleWord(true);
        jLabelResponse.setEnabled(false);
        jScrollPane3.setViewportView(jLabelResponse);

        jButtonChooseQRReset.setText("Reset");
        jButtonChooseQRReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseQRResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jButtonChooseQR, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jButtonChooseQRReset, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel5)
                .addGap(21, 21, 21)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonChooseQR)
                    .addComponent(jButtonChooseQRReset)))
        );

        jPanel2.add(jPanel3, java.awt.BorderLayout.CENTER);

        jMainWindowTab.addTab("Decode", jPanel2);

        jPanel1.setPreferredSize(new java.awt.Dimension(740, 450));
        jPanel1.setSize(700, 490);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("QR Code Encode");
        jLabel1.setAlignmentX(40.0F);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Select Option For Encode");

        jRBText.setSelected(true);
        jRBText.setText("Text");
        jRBText.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBTextItemStateChanged(evt);
            }
        });

        jRBUrl.setText("URL");
        jRBUrl.setToolTipText("");
        jRBUrl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBUrlItemStateChanged(evt);
            }
        });

        jTextArea.setColumns(20);
        jTextArea.setLineWrap(true);
        jTextArea.setRows(5);
        jTextArea.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Enter Text Here");

        jButtonChooseFile.setText("Choose File");
        jButtonChooseFile.setEnabled(false);
        jButtonChooseFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonChooseFileActionPerformed(evt);
            }
        });

        jRBFile.setText("File");
        jRBFile.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jRBFileItemStateChanged(evt);
            }
        });

        jTFURL.setToolTipText("Enter URL Here");
        jTFURL.setEnabled(false);

        jButtonEncode.setText("Encode");
        jButtonEncode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncodeActionPerformed(evt);
            }
        });

        jShowImage.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jFileSeletedName.setEditable(false);
        jFileSeletedName.setColumns(20);
        jFileSeletedName.setLineWrap(true);
        jFileSeletedName.setRows(3);
        jFileSeletedName.setWrapStyleWord(true);
        jFileSeletedName.setEnabled(false);
        jScrollPane4.setViewportView(jFileSeletedName);

        jButtonEncodeReset1.setText("Reset");
        jButtonEncodeReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEncodeReset1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel2))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jRBText))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jRBUrl)
                .addGap(15, 15, 15)
                .addComponent(jTFURL, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jRBFile)
                .addGap(19, 19, 19)
                .addComponent(jButtonChooseFile, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jShowImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonEncode, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(jButtonEncodeReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(11, 11, 11)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jRBText)
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBUrl)
                    .addComponent(jTFURL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jRBFile)
                    .addComponent(jButtonChooseFile))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jShowImage, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonEncode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonEncodeReset1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
        );

        jMainWindowTab.addTab("Encode", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainWindowTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jMainWindowTab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        jMainWindowTab.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jRBTextItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBTextItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            checkboxValueChanged(true, false, false);
        }
    }//GEN-LAST:event_jRBTextItemStateChanged

    private void jRBUrlItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBUrlItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            checkboxValueChanged(false, true, false);
        }

    }//GEN-LAST:event_jRBUrlItemStateChanged

    private void jRBFileItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jRBFileItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == evt.SELECTED) {
            checkboxValueChanged(false, false, true);
        }
    }//GEN-LAST:event_jRBFileItemStateChanged
    private void checkboxValueChanged(boolean text, boolean url, boolean file) {
        jRBText.setSelected(text);
        jTextArea.setEnabled(text);
        if (text == false) {
            jTextArea.setText("");
        }

        jRBUrl.setSelected(url);
        jTFURL.setEnabled(url);
        if (url == false) {
            jTFURL.setText("");
        }

        jRBFile.setSelected(file);
        jButtonChooseFile.setEnabled(file);
        if (file == false) {
            data = "";
            jFileSeletedName.setText("");
        }

    }
    private void jButtonEncodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncodeActionPerformed
        // TODO add your handling code here:
        try {
            if (jTextArea.getText().equalsIgnoreCase("") && jRBText.isSelected()) {
                Message.showMessage("Please enter text", "warning");
                return;
            }
            if (jTFURL.getText().equalsIgnoreCase("") && jRBUrl.isSelected()) {
                Message.showMessage("Please enter url", "warning");
                return;
            }
            if (data.equalsIgnoreCase("") && jRBFile.isSelected()) {
                Message.showMessage("Please select file", "warning");
                return;
            }
            if (jRBText.isSelected() && !jTextArea.getText().equalsIgnoreCase("")) {
                String encryptedData = crypto.encrypt(jTextArea.getText());
                if (encryptedData == null) {
                    Message.showMessage("Failed to encrypt", "error");
                }
                jShowImage.setIcon(new ImageIcon(QRCodeWriterReader.createQRCodeInFile(encryptedData, 180, 180)));
            }
            if (jRBUrl.isSelected() && !jTFURL.getText().equalsIgnoreCase("")) {
                String encryptedData = crypto.encrypt(jTFURL.getText());
                if (encryptedData == null) {
                    Message.showMessage("Failed to encrypt", "error");
                }
                jShowImage.setIcon(new ImageIcon(QRCodeWriterReader.createQRCodeInFile(encryptedData, 180, 180)));
            }
            if (jRBFile.isSelected() && !data.equalsIgnoreCase("")) {
                String encryptedData = crypto.encrypt(data);
                if (encryptedData == null) {
                    Message.showMessage("Failed to encrypt", "error");
                }
                jShowImage.setIcon(new ImageIcon(QRCodeWriterReader.createQRCodeInFile(encryptedData, 180, 180)));
            }
        } catch (Exception ex) {
            Message.showMessage("Error in QR Code Generating \n " + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_jButtonEncodeActionPerformed
    private void jButtonChooseFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseFileActionPerformed
        // TODO add your handling code here:
        FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        fd.setDirectory(System.getProperty("user.home") + "/Desktop");
        fd.setVisible(true);
        String path = "";
        path = fd.getDirectory() + fd.getFile();
        if (path != null && !path.isEmpty()) {
            data = path;
            jFileSeletedName.setText(data);
        } else {
            Message.showMessage("Please select file", "");
        }
    }//GEN-LAST:event_jButtonChooseFileActionPerformed
    private void jButtonChooseQRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseQRActionPerformed
        // Read QR Code from PNG file.
        FileDialog fd = new FileDialog(this, "Choose a file", FileDialog.LOAD);
        fd.setDirectory("./");
        fd.setFile("*.png");
        fd.setVisible(true);
        String path = new File(fd.getFile()).getAbsolutePath();
        if (path != null && !path.isEmpty()) {
            try {
                String fileExt = FileUtility.getExtension(path);
                if (!fileExt.equalsIgnoreCase("png")) {
                    Message.showMessage("Invalid file extention.", "warning");
                    return;
                }
                String result = QRCodeWriterReader.readQRCode(ImageIO.read(new File(fd.getFile())));
                result = crypto.decrypt(result);
                if (result == null) {
                    Message.showMessage("Failed to decrypt", "error");
                }
                fileExt = FileUtility.getExtension(result);
                if (fileExt.equalsIgnoreCase("png")) {
                    File f = new File(result);
                    Desktop dt = Desktop.getDesktop();
                    dt.open(f);
                }
                jLabelResponse.setText(result);

            } catch (Exception ex) {
                Message.showMessage("Error file load. \n" + ex.getMessage(), "error");
            }
        }
    }//GEN-LAST:event_jButtonChooseQRActionPerformed
    @SuppressWarnings("UseSpecificCatch")
    private void jButtonCoverImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCoverImageActionPerformed
        // Select cover
        try {
            JFileChooser fileopen = new JFileChooser();
            fileopen.addChoosableFileFilter(new FileNameExtensionFilter("Images", "png", "bmp"));
            fileopen.setCurrentDirectory(new File("./"));
            int ret = fileopen.showDialog(null, "Open file");

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                fileExt = FileUtility.getExtension(file.getName());
                if (imageUtility.isImage(file.getName())) {
                    coverImage = ImageIO.read(file);
                    Image dimg = coverImage.getScaledInstance(jCoverImage.getWidth(), jCoverImage.getHeight(), Image.SCALE_SMOOTH);
                    jCoverImage.setIcon(new ImageIcon(dimg));
                } else {
                    Message.showMessage("Please select image(.png, bmp)", "warning");
                }
            }
        } catch (Exception ex) {
            Message.showMessage("While selecting file something goes wrong \n " + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_jButtonCoverImageActionPerformed
    private void jButtonTargetImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonTargetImageActionPerformed
        // Select Image which need to be hide
        if (qrImage != null) {
            int result = JOptionPane.showConfirmDialog(null, "Press Yes to load target image or No to continue with QRCode Image", "Choose Image", JOptionPane.YES_NO_OPTION);
            if (result == JOptionPane.NO_OPTION) {
                targetImage = qrImage;
                Image dimg = targetImage.getScaledInstance(jTargetImage.getWidth(), jTargetImage.getHeight(), Image.SCALE_SMOOTH);
                jTargetImage.setIcon(new ImageIcon(dimg));
                encodedData = ImageBase64.encodeToString(targetImage, targetfileExt);
                return;
            }
        }
        try {
            JFileChooser fileopen = new JFileChooser();
            fileopen.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png", "bmp"));
            fileopen.setCurrentDirectory(new File("./"));
            int ret = fileopen.showDialog(null, "Open file");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                if (imageUtility.isPNGImage(file.getName())) {
                    targetImage = ImageIO.read(file);
                    targetfileExt = FilenameUtils.getExtension(file.getName());
                    Image dimg = targetImage.getScaledInstance(jTargetImage.getWidth(), jTargetImage.getHeight(), Image.SCALE_SMOOTH);
                    jTargetImage.setIcon(new ImageIcon(dimg));
                    encodedData = ImageBase64.encodeToString(targetImage, FilenameUtils.getExtension(file.getName()));
                } else {
                    Message.showMessage("Please select image(.jpg, .png, bmp)", "warning");
                }
            }
        } catch (Exception ex) {
            Message.showMessage("While selecting file something goes wrong \n " + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_jButtonTargetImageActionPerformed

    private void jButtonSaveStegoImageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveStegoImageActionPerformed
        // Save Image after transformate and embed data
        try {
            if (isTransformed && coverImage != null && encodedData != null && !encodedData.equalsIgnoreCase("")) {
                LSBEncoding lsbEncoding = new LSBEncoding();
                int bitArray[] = new int[8];
                for (int i = 0; i < 8; i++) {
                    if (i == 0) {
                        bitArray[i] = 1;
                    } else {
                        bitArray[i] = 0;
                    }
                }
               
                lsbEncoding.encodeText(coverImage, encodedData, bitArray);
               // Steganography stego1 = new Steganography
                BufferedImage tranformedImage = RecoverImage.RecoverTransformImage(coverImage, fileExt);
                coverImage = tranformedImage;
                Image dimg = coverImage.getScaledInstance(jStegoImage.getWidth(), jStegoImage.getHeight(), Image.SCALE_SMOOTH);
                jStegoImage.setIcon(new ImageIcon(dimg));
                saveSteganoImage(coverImage);
            }
        } catch (Exception ex) {
            Message.showMessage("Error while embedding image" + ex.getMessage(), "error");
        }

    }//GEN-LAST:event_jButtonSaveStegoImageActionPerformed
    private void jButtonChooseStegoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseStegoActionPerformed
        // TODO add your handling code here:
        try {
            JFileChooser fileopen = new JFileChooser();
            fileopen.addChoosableFileFilter(new FileNameExtensionFilter("Images", "png"));
            fileopen.setCurrentDirectory(new File("./"));
            int ret = fileopen.showDialog(null, "Open file");

            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                if (imageUtility.isImage(file.getName())) {
                    stegoImageRead = ImageIO.read(file);
                    BufferedImage tranformedImage = TransformImage.TransformNormalImage(stegoImageRead, fileExt);
                    stegoImageRead = tranformedImage;
                    BufferedImage temp = imageUtility.convertImage(stegoImageRead);

                    if (temp != null) {
                        targetImage = temp;
                    }
                    LSBEncoding lsbEncoding = new LSBEncoding();
                    int bitArray[] = new int[8];
                    for (int i = 0; i < 8; i++) {
                        if (i == 0) {
                            bitArray[i] = 1;
                        } else {
                            bitArray[i] = 0;
                        }
                    }
                    String message = lsbEncoding.decodeText(stegoImageRead, bitArray);
                    stegoImageRead = ImageBase64.decodeToImage(message);
                    String result = QRCodeWriterReader.readQRCode(stegoImageRead);

                    String afterDecryptResult = crypto.decrypt(result);
                    if (afterDecryptResult == null) {
                        Message.showMessage("Failed to decrypt", "error");
                    }
                    jImageDecodeRespose.setText(result + "\n \n " + afterDecryptResult);
                    Image dimg = stegoImageRead.getScaledInstance(jRealImage.getWidth(), jRealImage.getHeight(), Image.SCALE_SMOOTH);
                    jRealImage.setIcon(new ImageIcon(dimg));
                } else {
                    Message.showMessage("Please select png file", "");
                }

            }
        } catch (Exception ex) {
            Message.showMessage("Unable to read data from image \n " + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_jButtonChooseStegoActionPerformed
    private void jButtonLoadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadDataActionPerformed
        // TODO add your handling code here:
        coverImage = null;
        qrImage = null;
        targetImage = null;
        stegoImageRead = null;
        jCoverImage.setIcon(null);
        jTargetImage.setIcon(null);
        jQRImage.setIcon(null);
        jTranformImage.setIcon(null);
        jStegoImage.setIcon(null);
        jTAData.setText("");
    }//GEN-LAST:event_jButtonLoadDataActionPerformed

    private void jButtonGenQrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGenQrActionPerformed
        // TODO add your handling code here:
        try {
            if (jTAData.getText().equalsIgnoreCase("")) {
                Message.showMessage("Please enter data", "warning");
                return;
            }
            String encryptedData = crypto.encrypt(jTAData.getText());
            if (encryptedData == null) {
                Message.showMessage("Failed to encrypt", "error");
            }
            System.out.println(encryptedData);
            qrImage = QRCodeWriterReader.createQRCode(encryptedData, 180, 180);
            targetfileExt = "png";
            Image dimg = qrImage.getScaledInstance(jQRImage.getWidth(), jQRImage.getHeight(), Image.SCALE_DEFAULT);
            jQRImage.setIcon(new ImageIcon(dimg));
        } catch (Exception ex) {
            Message.showMessage("QR Code Generate Error \n" + ex.getMessage(), "error");
        }
    }//GEN-LAST:event_jButtonGenQrActionPerformed

    private void jButtonApplyTransformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonApplyTransformationActionPerformed
        // TODO add your handling code here:
        try {
            if (coverImage != null && targetImage != null) {
                BufferedImage tranformedImage = TransformImage.TransformNormalImage(coverImage, fileExt);
                if (tranformedImage == null) {
                    Message.showMessage("No Image transformed", "warning");
                }
                coverImage = tranformedImage;
                isTransformed = true;
                Image dimg = coverImage.getScaledInstance(jTranformImage.getWidth(), jTranformImage.getHeight(), Image.SCALE_SMOOTH);
                jTranformImage.setIcon(new ImageIcon(dimg));

            } else {
                Message.showMessage("No Image for transformation", "warning");
            }
        } catch (Exception ex) {
            Message.showMessage("Image Transform Error \n" + ex.getMessage(), "error");
        }

    }//GEN-LAST:event_jButtonApplyTransformationActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // TODO add your handling code here:
        jTAData.setText("Student Name: Test \n Reg No: 3433/FBAS/BSSE/F14 \n CGPA: 3.80");
    }//GEN-LAST:event_formWindowActivated

    private void jButtonDecodeResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDecodeResetActionPerformed
        // TODO add your handling code here:
        jRealImage.setIcon(null);
        jImageDecodeRespose.setText("");
    }//GEN-LAST:event_jButtonDecodeResetActionPerformed

    private void jButtonEncodeReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEncodeReset1ActionPerformed
        // TODO add your handling code here:
        jRBText.setSelected(true);
        jTextArea.setText("");
    }//GEN-LAST:event_jButtonEncodeReset1ActionPerformed

    private void jButtonChooseQRResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonChooseQRResetActionPerformed
        // TODO add your handling code here:
        jLabelResponse.setText("");
    }//GEN-LAST:event_jButtonChooseQRResetActionPerformed
    private void saveSteganoImage(BufferedImage steganoImage) {
        try {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Choose a location");
            fileChooser.setCurrentDirectory(new File("./"));
            int returnVal = fileChooser.showSaveDialog(this);
            if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                if (FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("png")) {
                    // filename is OK as-is
                } else {
                    file = new File(file.toString() + ".png");  // append .xml if "foo.jpg.xml" is OK
                    file = new File(file.getParentFile(), FilenameUtils.getBaseName(file.getName()) + ".png"); // ALTERNATIVELY: remove the extension (if any) and replace it with ".xml"
                }
                if (!FilenameUtils.getExtension(file.getName()).equalsIgnoreCase("png")) {
                    Message.showMessage("File extentin must be png", "warning");
                    return;
                }
                imageUtility.saveImage(steganoImage, file);
//            if (imageUtility.isImage(file.getName())) {
//                imageUtility.saveImage(steganoImage, file);
//            } else {
//                alert("Invalid file name");
//            }
            }
        } catch (Exception ex) {
            Message.showMessage("Error while saving file \n " + ex.getMessage(), "error");
        }

    }

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
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }
// <editor-fold>
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonApplyTransformation;
    private javax.swing.JButton jButtonChooseFile;
    private javax.swing.JButton jButtonChooseQR;
    private javax.swing.JButton jButtonChooseQRReset;
    private javax.swing.JButton jButtonChooseStego;
    private javax.swing.JButton jButtonCoverImage;
    private javax.swing.JButton jButtonDecodeReset;
    private javax.swing.JButton jButtonEncode;
    private javax.swing.JButton jButtonEncodeReset1;
    private javax.swing.JButton jButtonGenQr;
    private javax.swing.JButton jButtonLoadData;
    private javax.swing.JButton jButtonSaveStegoImage;
    private javax.swing.JButton jButtonTargetImage;
    private javax.swing.JLabel jCoverImage;
    private javax.swing.JTextArea jFileSeletedName;
    private javax.swing.JTextArea jImageDecodeRespose;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextArea jLabelResponse;
    private javax.swing.JTabbedPane jMainWindowTab;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JLabel jQRImage;
    private javax.swing.JRadioButton jRBFile;
    private javax.swing.JRadioButton jRBText;
    private javax.swing.JRadioButton jRBUrl;
    private javax.swing.JLabel jRealImage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel jShowImage;
    private javax.swing.JLabel jStegoImage;
    private javax.swing.JTextArea jTAData;
    private javax.swing.JTextField jTFURL;
    private javax.swing.JLabel jTargetImage;
    private javax.swing.JTextArea jTextArea;
    private javax.swing.JLabel jTranformImage;
    // End of variables declaration//GEN-END:variables
// </editor-fold>
}
