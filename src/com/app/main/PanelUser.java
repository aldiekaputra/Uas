/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.main;

import com.app.components.TextField;
import com.app.entity.PageResult;
import com.app.entity.Result;
import com.app.entity.Users;
import com.app.services.UserService;
import com.app.tablemodel.AppTableModel;
import java.awt.CardLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Farmaku
 */
public class PanelUser extends javax.swing.JPanel {
    private UserService service;
    private PageResult<Users> pageResult;
    private AppTableModel<Users> tableModel;
    private int page = 1;
    private int pageSize = 10;
    private String[] columnNames = {"User ID", "Name", "Title", "Birth Date", "Hire Date", "Position", "Email"};
    private CardLayout layout = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MMM-dd");
    private boolean isNew = false;
    private Users users;
    
    /**
     * Creates new form PanelHome
     */
    public PanelUser() {
        initComponents();
        layout = (CardLayout) getLayout();
        service = new UserService();
        loadData();
        textSearch.getTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    loadData();
                }
            }
            
        });
    }
    
    private void loadData() {
        try {
            String search = textSearch.getText();
            String sort = ddlSort.getSelectedItem().toString().replace(" ", "");
            pageResult = service.getPage(search, page, pageSize, sort, ascending.isSelected());
            tableModel = new AppTableModel<>(pageResult.getContent(), columnNames);
            tableUser.setModel(tableModel);

            labelTotalRow.setText(pageResult.getTotalElements() + "");
            labelPage.setText(String.format("Page %d / %d", page, pageResult.getTotalPages()));
            buttonPrev.setEnabled(!pageResult.isFirst());
            buttonNext.setEnabled(!pageResult.isLast());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
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

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelList = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        textSearch = new com.app.components.TextSearch();
        buttonSeacrh = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        ddlSort = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        ascending = new javax.swing.JRadioButton();
        descending = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        labelTotalRow = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        buttonNext = new javax.swing.JButton();
        buttonPrev = new javax.swing.JButton();
        labelPage = new javax.swing.JLabel();
        ddlPerPage = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        buttonDelete = new javax.swing.JButton();
        buttonAdd = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        panelDetail = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        textUserID = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        textName = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        textTitle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        textBirthDate = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        textHireDate = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        textPosition = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        textEmail = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        textPassword = new javax.swing.JTextField();
        buttonSave = new javax.swing.JButton();
        ButtonCancel = new javax.swing.JButton();

        setLayout(new java.awt.CardLayout());

        panelList.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel2.setText("Daftar User");

        textSearch.setPlaceHolder("Cari berdasarkan nama product ...");

        buttonSeacrh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/app/icons/icons8_search_24px.png"))); // NOI18N
        buttonSeacrh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSeacrhActionPerformed(evt);
            }
        });

        jLabel3.setText("Sort By");

        ddlSort.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "User ID", "Name", "Title", "Birth Date", "Hire Date", "Email" }));
        ddlSort.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlSortActionPerformed(evt);
            }
        });

        jLabel4.setText("Direction");

        ascending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(ascending);
        ascending.setSelected(true);
        ascending.setText("Ascending");
        ascending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ascendingActionPerformed(evt);
            }
        });

        descending.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(descending);
        descending.setText("Descending");
        descending.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                descendingActionPerformed(evt);
            }
        });

        tableUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableUser.setRowHeight(22);
        tableUser.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(tableUser);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Total Row: ");

        labelTotalRow.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelTotalRow.setText("0");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Row(s)");

        buttonNext.setText("Next");
        buttonNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNextActionPerformed(evt);
            }
        });

        buttonPrev.setText("Prev");
        buttonPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonPrevActionPerformed(evt);
            }
        });

        labelPage.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        labelPage.setText("Page 1 / 10");

        ddlPerPage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "25", "50", "100" }));
        ddlPerPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ddlPerPageActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Per Page");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelTotalRow, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 423, Short.MAX_VALUE)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ddlPerPage, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelPage, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(buttonPrev)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonNext))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(26, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelTotalRow)
                    .addComponent(jLabel6)
                    .addComponent(buttonNext)
                    .addComponent(buttonPrev)
                    .addComponent(labelPage)
                    .addComponent(ddlPerPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(15, 15, 15))
        );

        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonAdd.setText("Add");
        buttonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddActionPerformed(evt);
            }
        });

        buttonUpdate.setText("Update");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelListLayout = new javax.swing.GroupLayout(panelList);
        panelList.setLayout(panelListLayout);
        panelListLayout.setHorizontalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListLayout.createSequentialGroup()
                        .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelListLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(textSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonSeacrh))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelListLayout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ddlSort, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ascending)
                        .addGap(18, 18, 18)
                        .addComponent(descending)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonDelete)))
                .addContainerGap())
        );
        panelListLayout.setVerticalGroup(
            panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSeacrh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(textSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(ddlSort, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(ascending)
                    .addComponent(descending)
                    .addComponent(buttonDelete)
                    .addComponent(buttonAdd)
                    .addComponent(buttonUpdate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        add(panelList, "list");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Users Detail");

        jLabel9.setText("User ID");

        jLabel10.setText("Name");

        jLabel11.setText("Title");

        jLabel12.setText("Birth Date");

        jLabel13.setText("Hire Date");

        jLabel14.setText("Position");

        jLabel15.setText("Email");

        jLabel16.setText("Password");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textUserID, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textPosition, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(584, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(textUserID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(textName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(textTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(textBirthDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(textHireDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(textPosition, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(textEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(textPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        buttonSave.setText("Save");
        buttonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSaveActionPerformed(evt);
            }
        });

        ButtonCancel.setText("Cancel");
        ButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelDetailLayout = new javax.swing.GroupLayout(panelDetail);
        panelDetail.setLayout(panelDetailLayout);
        panelDetailLayout.setHorizontalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(panelDetailLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addComponent(buttonSave, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144)
                .addComponent(ButtonCancel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelDetailLayout.setVerticalGroup(
            panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelDetailLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelDetailLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButtonCancel)
                    .addComponent(buttonSave))
                .addContainerGap(277, Short.MAX_VALUE))
        );

        add(panelDetail, "detail");
    }// </editor-fold>//GEN-END:initComponents

    private void buttonSeacrhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSeacrhActionPerformed
        page = 1;
        loadData();
    }//GEN-LAST:event_buttonSeacrhActionPerformed

    private void ddlSortActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlSortActionPerformed
        loadData();
    }//GEN-LAST:event_ddlSortActionPerformed

    private void ascendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ascendingActionPerformed
        loadData();
    }//GEN-LAST:event_ascendingActionPerformed

    private void descendingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_descendingActionPerformed
        loadData();
    }//GEN-LAST:event_descendingActionPerformed

    private void buttonNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNextActionPerformed
        page++;
        loadData();
    }//GEN-LAST:event_buttonNextActionPerformed

    private void buttonPrevActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonPrevActionPerformed
        page--;
        loadData();
    }//GEN-LAST:event_buttonPrevActionPerformed

    private void ddlPerPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ddlPerPageActionPerformed
        pageSize = Integer.valueOf(ddlPerPage.getSelectedItem().toString());
        page = 1;
        loadData();
    }//GEN-LAST:event_ddlPerPageActionPerformed

    private void ButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonCancelActionPerformed
        layout.show(this, "list");
    }//GEN-LAST:event_ButtonCancelActionPerformed

    private void buttonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAddActionPerformed
        isNew = true;
        clearTextField();
        layout.show(this, "detail");
        textUserID.setEditable(true);
    }//GEN-LAST:event_buttonAddActionPerformed

    private void buttonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSaveActionPerformed
        try {
            if (isDataValid()) {
                populateObject();
                Result result = null;
                if(isNew){
                    System.out.println("Users = " + users.toJson().toString());
                    result = service.create(users);
                }else{
                    result = service.update(users);
                }
                if(result.getMeta().isSuccess()){
                    JOptionPane.showMessageDialog(this, "Save Data Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                    layout.show(this, "list");
                }else{
                    JOptionPane.showMessageDialog(this, "Error" + result.getMeta().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }    
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error Save Data ", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_buttonSaveActionPerformed

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonUpdateActionPerformed
        int index = tableUser.getSelectedRow();
        if (index > -1){
            isNew = false;
            users = pageResult.getContent().get(index);
            populateControl();
            layout.show(this, "detail");
        }
    }//GEN-LAST:event_buttonUpdateActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        int index = tableUser.getSelectedRow();
        if (index > -1){
            boolean answer = JOptionPane.showConfirmDialog(this, "Are you sure", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION ;
            if (answer) {
                int id = pageResult.getContent().get(index).getUserID();
                
                try {
                    Result result = service.delete(id);
                    if(result.getMeta().isSuccess()){
                    JOptionPane.showMessageDialog(this, "Delete Data Success", "Success", JOptionPane.INFORMATION_MESSAGE);
                    loadData();
                }else{
                    JOptionPane.showMessageDialog(this, "Error" + result.getMeta().getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                } catch (IOException ex) {
                    
                }
            }
        }
    }//GEN-LAST:event_buttonDeleteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonCancel;
    private javax.swing.JRadioButton ascending;
    private javax.swing.JButton buttonAdd;
    private javax.swing.JButton buttonDelete;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonNext;
    private javax.swing.JButton buttonPrev;
    private javax.swing.JButton buttonSave;
    private javax.swing.JButton buttonSeacrh;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<String> ddlPerPage;
    private javax.swing.JComboBox<String> ddlSort;
    private javax.swing.JRadioButton descending;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelPage;
    private javax.swing.JLabel labelTotalRow;
    private javax.swing.JPanel panelDetail;
    private javax.swing.JPanel panelList;
    private javax.swing.JTable tableUser;
    private javax.swing.JTextField textBirthDate;
    private javax.swing.JTextField textEmail;
    private javax.swing.JTextField textHireDate;
    private javax.swing.JTextField textName;
    private javax.swing.JTextField textPassword;
    private javax.swing.JTextField textPosition;
    private com.app.components.TextSearch textSearch;
    private javax.swing.JTextField textTitle;
    private javax.swing.JTextField textUserID;
    // End of variables declaration//GEN-END:variables

    private void clearTextField() {
        textUserID.setText("");
        textName.setText("");
        textTitle.setText("");
        textBirthDate.setText("");
        textHireDate.setText("");
        textPosition.setText("");
        textEmail.setText("");
        textPassword.setText("");
    }

    private boolean isDataValid() {
        String message = "";
        if(textUserID.getText().equals("")){
            message = "Users ID tidak boleh kosong";
        }else if(textName.getText().equals("")){
            message = "Name tidak boleh kosong";
        }else if(textTitle.getText().equals("")){
            message = "Title tidak boleh kosong";
        }else if(textBirthDate.getText().equals("")){
            message = "Birth Date tidak boleh kosong";
        }else if(textHireDate.getText().equals("")){
            message = "Hire Date tidak boleh kosong";
        }else if(textPosition.getText().equals("")){
            message = "Position tidak boleh kosong";
        }else if(textEmail.getText().equals("")){
            message = "Email tidak boleh kosong";
        }else if(textPassword.getText().equals("")){
            message = "Password tidak boleh kosong";
        }
        else{
            return true;
        }
        JOptionPane.showMessageDialog(this, message, "Error Input Text", JOptionPane.ERROR_MESSAGE);
        return false;
    }

    private void populateObject() throws ParseException {
        if(isNew){
            users = new Users();
            users.setUserID(Integer.valueOf(textUserID.getText()));
        }      
        users.setName(textName.getText());
        users.setTitle(textTitle.getText());
        users.setBirthDate(sdf.parse(textBirthDate.getText()));
        users.setHireDate(sdf.parse(textHireDate.getText()));
        users.setPosition(textPosition.getText());
        users.setEmail(textEmail.getText());
        users.setPassword(textPassword.getText());
    }

    private void populateControl() {
        textUserID.setEditable(false);
        if (users != null){
            textUserID.setText(users.getUserID()+"");
            textName.setText(users.getName());
            textTitle.setText(users.getTitle());
            textBirthDate.setText(sdf.format(users.getBirthDate()));
            textHireDate.setText(sdf.format(users.getHireDate()));
            textPosition.setText(users.getPosition());
            textEmail.setText(users.getEmail());
            textPassword.setText(users.getPassword());  
        }
    }
}
