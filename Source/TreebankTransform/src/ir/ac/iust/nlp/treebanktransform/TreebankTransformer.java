package ir.ac.iust.nlp.treebanktransform;

import ir.ac.iust.nlp.treebanktransform.enums.NumberTransferType;
import ir.ac.iust.nlp.treebanktransform.enums.POSCopyType;
import ir.ac.iust.nlp.treebanktransform.utilities.Transform;
import ir.ac.iust.nlp.treebanktransform.utilities.TransformNumber;
import ir.ac.iust.nlp.treebanktransform.utilities.TransformRa;
import java.awt.GridLayout;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import se.vxu.msi.malteval.treeviewer.MaltTreeViewerGui;
import se.vxu.msi.malteval.treeviewer.gui.NavigationPanel;
import se.vxu.msi.malteval.treeviewer.gui.TreeViewer;

/**
 *
 * @author Mojtaba Khallash
 */
public class TreebankTransformer extends javax.swing.JFrame {

    MaltTreeViewerGui gui;
    String input;
    String output;
    
    /**
     * Creates new form TreebankTransformer
     */
    public TreebankTransformer() {
        initComponents();
        
        setDrop();
    }
    
    private void setDrop() {
        FileDrop fd;
        fd = new FileDrop(null, txtInputFile, new FileDrop.Listener() {
            @Override
            public void filesDropped(java.io.File[] files) {
                if (files.length > 0) {
                    try {
                        boolean dropped = false;
                        for (int i = 0; i < files.length; i++) {
                            if (files[i].isFile()) {
                                txtInputFile.setText(files[i].getCanonicalPath());
                                dropped = true;
                                break;
                            }
                        }
                        if (dropped == false) {
                            JOptionPane.showMessageDialog(null, "File needed.");
                        }
                    } // end try
                    catch (java.io.IOException e) {
                    }
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
        
        fd = new FileDrop(null, txtOutputPath, new FileDrop.Listener() {
            @Override
            public void filesDropped(java.io.File[] files) {
                if (files.length > 0) {
                    try {
                        if (files[0].isFile()) {
                            files[0] = files[0].getParentFile();
                        }

                        txtOutputPath.setText(files[0].getCanonicalPath() + File.separator);
                    } // end try
                    catch (java.io.IOException e) {
                    }
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgNumberTransform = new javax.swing.ButtonGroup();
        bgDirection = new javax.swing.ButtonGroup();
        bgPOSCopy = new javax.swing.ButtonGroup();
        pnlMain = new javax.swing.JPanel();
        tabSetting = new javax.swing.JTabbedPane();
        pnlSettings = new javax.swing.JPanel();
        lblInputFile = new javax.swing.JLabel();
        txtInputFile = new javax.swing.JTextField();
        btnBrowseInputFile = new javax.swing.JButton();
        btnBrowseOutputPath = new javax.swing.JButton();
        txtOutputPath = new javax.swing.JTextField();
        lblOutputPath = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnlGlobalSettings = new javax.swing.JPanel();
        pnlDirection = new javax.swing.JPanel();
        rbLtr = new javax.swing.JRadioButton();
        rbRtl = new javax.swing.JRadioButton();
        chkCompoundVerb = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        pnlNumber = new javax.swing.JPanel();
        rbNone = new javax.swing.JRadioButton();
        rbNormalNumber = new javax.swing.JRadioButton();
        rbBinning = new javax.swing.JRadioButton();
        chkCopyL2F = new javax.swing.JCheckBox();
        chkRmSpaces = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        pnlCopyPOS = new javax.swing.JPanel();
        rbCopyNone = new javax.swing.JRadioButton();
        rbPOSinCPOS = new javax.swing.JRadioButton();
        rbCPOSinPOS = new javax.swing.JRadioButton();
        jPanel4 = new javax.swing.JPanel();
        lblRemoveAttrib = new javax.swing.JLabel();
        txtRemoveAttrib = new javax.swing.JTextField();
        btnRemoveAttrib = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listRemoveAttrib = new javax.swing.JList(new DefaultListModel());
        jScrollPane2 = new javax.swing.JScrollPane();
        listAddAttrib = new javax.swing.JList(new DefaultListModel());
        lblAddAttrib = new javax.swing.JLabel();
        txtAddAttrib = new javax.swing.JTextField();
        btnAddAttrib = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        chkRaTransform = new javax.swing.JCheckBox();
        chkRemoveDeprelHead = new javax.swing.JCheckBox();
        chkSetHeadsDeprelRoot = new javax.swing.JCheckBox();
        pnlResults = new javax.swing.JPanel();
        pnlNavigation = new javax.swing.JPanel();
        lblCurrentTotal = new javax.swing.JLabel();
        btnPrev = new javax.swing.JButton();
        btnNext = new javax.swing.JButton();
        sliderSentences = new javax.swing.JSlider();
        jSplitPane1 = new javax.swing.JSplitPane();
        pnlInputTree = new javax.swing.JPanel();
        pnlOutputTree = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        lblViewMode = new javax.swing.JLabel();
        cboViewMode = new javax.swing.JComboBox();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        btnPrevChange = new javax.swing.JToggleButton();
        btnNextChange = new javax.swing.JButton();
        mnuMain = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Treebank Transformer");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMain.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlSettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblInputFile.setText("Input File:");
        pnlSettings.add(lblInputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        txtInputFile.setEditable(false);
        pnlSettings.add(txtInputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 12, 465, -1));

        btnBrowseInputFile.setText("...");
        btnBrowseInputFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseInputFile_Click(evt);
            }
        });
        pnlSettings.add(btnBrowseInputFile, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 11, 30, -1));

        btnBrowseOutputPath.setText("...");
        btnBrowseOutputPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBrowseOutputPath_Click(evt);
            }
        });
        pnlSettings.add(btnBrowseOutputPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(554, 45, 30, -1));

        txtOutputPath.setEditable(false);
        pnlSettings.add(txtOutputPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(83, 46, 465, -1));

        lblOutputPath.setText("Output Path:");
        pnlSettings.add(lblOutputPath, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 49, -1, -1));

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStart_Click(evt);
            }
        });
        pnlSettings.add(btnStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 331, 84, 31));

        pnlGlobalSettings.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDirection.setBorder(javax.swing.BorderFactory.createTitledBorder("Direction"));
        pnlDirection.setLayout(new java.awt.GridLayout(1, 0));

        bgDirection.add(rbLtr);
        rbLtr.setSelected(true);
        rbLtr.setText("Left to Right");
        pnlDirection.add(rbLtr);

        bgDirection.add(rbRtl);
        rbRtl.setText("Right To Left");
        pnlDirection.add(rbRtl);

        pnlGlobalSettings.add(pnlDirection, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 196, -1));

        chkCompoundVerb.setText("Mark Compound Verb");
        pnlGlobalSettings.add(chkCompoundVerb, new org.netbeans.lib.awtextra.AbsoluteConstraints(436, 11, -1, -1));

        jTabbedPane1.addTab("Global", pnlGlobalSettings);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNumber.setBorder(javax.swing.BorderFactory.createTitledBorder("Number"));
        pnlNumber.setLayout(new java.awt.GridLayout());

        bgNumberTransform.add(rbNone);
        rbNone.setSelected(true);
        rbNone.setText("None");
        pnlNumber.add(rbNone);

        bgNumberTransform.add(rbNormalNumber);
        rbNormalNumber.setText("Normal");
        pnlNumber.add(rbNormalNumber);

        bgNumberTransform.add(rbBinning);
        rbBinning.setText("Binning");
        pnlNumber.add(rbBinning);

        jPanel2.add(pnlNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        chkCopyL2F.setText("Copy Lemma in Word Form");
        jPanel2.add(chkCopyL2F, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 68, -1, -1));

        chkRmSpaces.setText("Remove Spaces");
        jPanel2.add(chkRmSpaces, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 94, -1, -1));

        jTabbedPane1.addTab("Word Form - Lemma", jPanel2);

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlCopyPOS.setBorder(javax.swing.BorderFactory.createTitledBorder("Copy"));
        pnlCopyPOS.setLayout(new java.awt.GridLayout());

        bgPOSCopy.add(rbCopyNone);
        rbCopyNone.setSelected(true);
        rbCopyNone.setText("None");
        pnlCopyPOS.add(rbCopyNone);

        bgPOSCopy.add(rbPOSinCPOS);
        rbPOSinCPOS.setText("POS in CPOS");
        pnlCopyPOS.add(rbPOSinCPOS);

        bgPOSCopy.add(rbCPOSinPOS);
        rbCPOSinPOS.setText("CPOS in POS");
        pnlCopyPOS.add(rbCPOSinPOS);

        jPanel3.add(pnlCopyPOS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

        jTabbedPane1.addTab("POS - CPOS", jPanel3);

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblRemoveAttrib.setText("Remove Attribute:");
        jPanel4.add(lblRemoveAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 15, -1, -1));

        txtRemoveAttrib.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRemoveAttrib_KeyReleased(evt);
            }
        });
        jPanel4.add(txtRemoveAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(103, 12, 116, -1));

        btnRemoveAttrib.setText("Add");
        btnRemoveAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveAttrib_Click(evt);
            }
        });
        jPanel4.add(btnRemoveAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 11, -1, -1));

        listRemoveAttrib.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listRemoveAttrib_KeyRealeased(evt);
            }
        });
        jScrollPane1.setViewportView(listRemoveAttrib);

        jPanel4.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 266, 162));

        listAddAttrib.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                listAddAttrib_KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(listAddAttrib);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 40, 266, 162));

        lblAddAttrib.setText("Add Attribute:");
        jPanel4.add(lblAddAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(286, 15, -1, -1));

        txtAddAttrib.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAddAttrib_KeyRealesed(evt);
            }
        });
        jPanel4.add(txtAddAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(359, 12, 136, -1));

        btnAddAttrib.setText("Add");
        btnAddAttrib.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAttrib_Click(evt);
            }
        });
        jPanel4.add(btnAddAttrib, new org.netbeans.lib.awtextra.AbsoluteConstraints(501, 11, -1, -1));

        jTabbedPane1.addTab("FEATS", jPanel4);

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        chkRaTransform.setText("Transform Ra Notation");
        jPanel5.add(chkRaTransform, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 7, -1, -1));

        chkRemoveDeprelHead.setText("Remove");
        jPanel5.add(chkRemoveDeprelHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 33, -1, -1));

        chkSetHeadsDeprelRoot.setText("Set All Head Deprel to ROOT");
        jPanel5.add(chkSetHeadsDeprelRoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 59, -1, -1));

        jTabbedPane1.addTab("Deprel - Head", jPanel5);

        pnlSettings.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 79, 574, 241));

        tabSetting.addTab("Settings", pnlSettings);

        pnlResults.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                pnlResults_Show(evt);
            }
        });
        pnlResults.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlNavigation.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCurrentTotal.setText("-/-");
        pnlNavigation.add(lblCurrentTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(572, 4, -1, -1));

        btnPrev.setText("Prev");
        btnPrev.setEnabled(false);
        btnPrev.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrev_Click(evt);
            }
        });
        pnlNavigation.add(btnPrev, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, -1, -1));

        btnNext.setText("Next");
        btnNext.setEnabled(false);
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNext_Click(evt);
            }
        });
        pnlNavigation.add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(441, 0, -1, -1));

        sliderSentences.setMaximum(0);
        sliderSentences.setEnabled(false);
        sliderSentences.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sliderSentences_StateChanged(evt);
            }
        });
        pnlNavigation.add(sliderSentences, new org.netbeans.lib.awtextra.AbsoluteConstraints(71, 0, 364, -1));

        pnlResults.add(pnlNavigation, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 594, -1));

        jSplitPane1.setDividerLocation(100);
        jSplitPane1.setOrientation(javax.swing.JSplitPane.VERTICAL_SPLIT);

        pnlInputTree.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                pnlInputTree_Resized(evt);
            }
        });
        pnlInputTree.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jSplitPane1.setTopComponent(pnlInputTree);

        pnlOutputTree.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jSplitPane1.setRightComponent(pnlOutputTree);

        pnlResults.add(jSplitPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 31, 594, 313));

        jToolBar1.setRollover(true);

        lblViewMode.setText("View Mode ");
        jToolBar1.add(lblViewMode);

        cboViewMode.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inline Zoom", "Hierarchical Zoom", "NetGraph Zoom", "Inline Scroll" }));
        cboViewMode.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboViewMode_ValueChanged(evt);
            }
        });
        jToolBar1.add(cboViewMode);

        jSeparator1.setPreferredSize(new java.awt.Dimension(6, 2));
        jToolBar1.add(jSeparator1);

        btnPrevChange.setText("<< Prev Change");
        btnPrevChange.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPrevChange.setFocusable(false);
        btnPrevChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnPrevChange.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnPrevChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevChange_Click(evt);
            }
        });
        jToolBar1.add(btnPrevChange);

        btnNextChange.setText("Next Change >>");
        btnNextChange.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNextChange.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnNextChange.setFocusable(false);
        btnNextChange.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnNextChange.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnNextChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextChange_Click(evt);
            }
        });
        jToolBar1.add(btnNextChange);

        pnlResults.add(jToolBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 594, 25));

        tabSetting.addTab("Results", pnlResults);

        pnlMain.add(tabSetting, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        getContentPane().add(pnlMain, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jMenu1.setText("File");
        mnuMain.add(jMenu1);

        jMenu2.setText("Edit");
        mnuMain.add(jMenu2);

        setJMenuBar(mnuMain);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBrowseInputFile_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseInputFile_Click
        txtInputFile.setText(showFileDialog(txtInputFile.getText(), false, null));
    }//GEN-LAST:event_btnBrowseInputFile_Click

    private void btnBrowseOutputPath_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBrowseOutputPath_Click
        txtOutputPath.setText(showFileDialog(txtOutputPath.getText(), true, null));
    }//GEN-LAST:event_btnBrowseOutputPath_Click

    private void btnStart_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStart_Click
        gui = null;
        System.gc();
        
        input = txtInputFile.getText();
        output = txtOutputPath.getText() + "output";
        
        boolean removeDH = chkRemoveDeprelHead.isSelected();
        if (removeDH == true)
            output += "_removeDeprelHead";
        else if (chkSetHeadsDeprelRoot.isSelected())
            output += "_setDeprelROOT";
        
        TransformNumber number = null;
        if (rbNone.isSelected() == true)
            number = new TransformNumber();
        else if (rbNormalNumber.isSelected() == true) {
            number = new TransformNumber(NumberTransferType.Normal);
            
            output += "_normal";
        }
        else if (rbBinning.isSelected() == true) {
            number = new TransformNumber(NumberTransferType.Binning);
            
            output += "_binning";
        }
        
        if (chkCopyL2F.isSelected() == true)
            output += "_copyLEMtoFORM";
        
        TransformRa ra = null;
        if (removeDH == false && chkRaTransform.isSelected() == true) {
            boolean caseLabelAddEnabled = false;
            boolean raConvertEnableed = true;
            boolean vConJConvertEnabled = false;
            boolean secondObjConvertEnabled = false;
            ra = new TransformRa(caseLabelAddEnabled, raConvertEnableed, vConJConvertEnabled, secondObjConvertEnabled);
            
            output += "_ra";
        }
        
        DefaultListModel removeModel = (DefaultListModel) listRemoveAttrib.getModel();
        Object[] removes = removeModel.toArray();
        if (removes.length != 0)
            output += "_removeFeats";

        DefaultListModel addModel = (DefaultListModel) listAddAttrib.getModel();
        Object[] adds = addModel.toArray();
        if (adds.length != 0)
            output += "_addFeats";
        
        POSCopyType pos_type = POSCopyType.None;
        if (rbCPOSinPOS.isSelected()) {
            output += "_cpos2pos";
            pos_type = POSCopyType.CPOS2FPOS;
        }
        else if (rbPOSinCPOS.isSelected()) {
            output += "_pos2cpos";
            pos_type = POSCopyType.FPOS2CPOS;
        }
        
        if (chkCompoundVerb.isSelected())
            output += "_compoundVerb";
        
        if (rbRtl.isSelected())
            output += "_reversed";

        String extension = input.substring(input.lastIndexOf(".") + 1, input.length());
        output += "." + extension;
        
        File out = new File(output);
        if (out.exists())
            out.delete();
        
        try {
            Transform.PostProcessSentence(input, output, rbRtl.isSelected(), 
                    number, chkCopyL2F.isSelected(), chkRmSpaces.isSelected(), 
                    pos_type, removes, adds, removeDH, ra, 
                    chkSetHeadsDeprelRoot.isSelected(), 
                    chkCompoundVerb.isSelected());
        }
        catch (Exception ex) {}
    }//GEN-LAST:event_btnStart_Click

    private void btnPrev_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrev_Click
        int val = sliderSentences.getValue();
        int min = sliderSentences.getMinimum();
        if (val > min) {
            sliderSentences.setValue(val - 1);
        }
    }//GEN-LAST:event_btnPrev_Click

    private void btnNext_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNext_Click
        int val = sliderSentences.getValue();
        int max = sliderSentences.getMaximum();
        if (val < max) {
            sliderSentences.setValue(val + 1);
        }
    }//GEN-LAST:event_btnNext_Click

    private void sliderSentences_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sliderSentences_StateChanged
        try {
            UpdateTree(sliderSentences.getValue());
        } catch (Exception ex) {
        }
    }//GEN-LAST:event_sliderSentences_StateChanged

    private void cboViewMode_ValueChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboViewMode_ValueChanged
        ChangeViewMode();
    }//GEN-LAST:event_cboViewMode_ValueChanged

    private void pnlInputTree_Resized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlInputTree_Resized
        ChangeViewMode();
    }//GEN-LAST:event_pnlInputTree_Resized

    private void btnPrevChange_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevChange_Click
        this.prevError.doClick();
        lblCurrentTotal.setText(gui.getCurrentSentence() + " / " + gui.getSentenceCount());
        btnPrevChange.setSelected(false);
    }//GEN-LAST:event_btnPrevChange_Click

    private void btnNextChange_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextChange_Click
        this.nextError.doClick();
        lblCurrentTotal.setText(gui.getCurrentSentence() + " / " + gui.getSentenceCount());
        btnNextChange.setSelected(false);
    }//GEN-LAST:event_btnNextChange_Click

    private void btnRemoveAttrib_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveAttrib_Click
        String attrib = txtRemoveAttrib.getText();
        if (attrib.length() != 0) {
            DefaultListModel model = (DefaultListModel) listRemoveAttrib.getModel();
            
            if (attrib.toLowerCase().equals("all")) {
                model.clear();
                model.add(0, attrib);
            }
            else {
                if (model.size() == 1 && model.getElementAt(0).equals("all"))
                    model.clear();
                
                model.add(model.size(), attrib);
            }
            
            txtRemoveAttrib.setText("");
        }
    }//GEN-LAST:event_btnRemoveAttrib_Click

    private void txtRemoveAttrib_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRemoveAttrib_KeyReleased
        if(evt.getKeyCode() == 10)
            btnRemoveAttrib.doClick();
    }//GEN-LAST:event_txtRemoveAttrib_KeyReleased

    private void btnAddAttrib_Click(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAttrib_Click
        String attrib = txtAddAttrib.getText();
        if (attrib.length() != 0) {
            DefaultListModel model = (DefaultListModel) listAddAttrib.getModel();
            model.add(model.size(), attrib);
            txtAddAttrib.setText("");
        }
    }//GEN-LAST:event_btnAddAttrib_Click

    private void txtAddAttrib_KeyRealesed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAddAttrib_KeyRealesed
        if(evt.getKeyCode() == 10)
            btnAddAttrib.doClick();
    }//GEN-LAST:event_txtAddAttrib_KeyRealesed

    private void pnlResults_Show(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_pnlResults_Show
        try
        {
            if (gui == null && output != null && output.length() != 0)
                startGUI();
        }
        catch(Exception ex)
        {
        }
    }//GEN-LAST:event_pnlResults_Show

    private void listRemoveAttrib_KeyRealeased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listRemoveAttrib_KeyRealeased
        if (evt.getKeyCode() == 127 && listRemoveAttrib.getSelectedIndex() != -1) {
            DefaultListModel model = (DefaultListModel) listRemoveAttrib.getModel();
            for (int i = listRemoveAttrib.getSelectedIndices().length - 1; i >= 0; i--) {
                model.removeElementAt(listRemoveAttrib.getSelectedIndices()[i]);
            }
        }
    }//GEN-LAST:event_listRemoveAttrib_KeyRealeased

    private void listAddAttrib_KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_listAddAttrib_KeyReleased
        if (evt.getKeyCode() == 127 && listAddAttrib.getSelectedIndex() != -1) {
            DefaultListModel model = (DefaultListModel) listAddAttrib.getModel();
            for (int i = listAddAttrib.getSelectedIndices().length - 1; i >= 0; i--) {
                model.removeElementAt(listAddAttrib.getSelectedIndices()[i]);
            }
        }
    }//GEN-LAST:event_listAddAttrib_KeyReleased

    private void startGUI() throws Exception {
        String extension = input.substring(input.lastIndexOf(".") + 1, input.length());
        
        gui = new MaltTreeViewerGui(
            new String[] {output}, extension, 
            new String[] {input}, extension);
        gui.setVisible(false);

        btnPrev.setEnabled(false);
        int size = gui.getSentenceCount();
        if (size > 1)
            btnNext.setEnabled(true);
        else
            btnNext.setEnabled(false);
        lblCurrentTotal.setText("1 / " + size);
        sliderSentences.setMinimum(0);
        sliderSentences.setMaximum(size - 1);
        sliderSentences.setValue(0);
        sliderSentences.setEnabled(true);

        GetGUIComponent();
    }
    
    private String showFileDialog(String currentDir, boolean isFolder,
            FileNameExtensionFilter filter) {
        JFileChooser fc = new JFileChooser();
        if (currentDir.length() == 0) {
            fc.setCurrentDirectory(new java.io.File("."));
        } else {
            fc.setCurrentDirectory(new java.io.File(currentDir));
        }
        fc.setMultiSelectionEnabled(false);
        if (filter != null) {
            fc.setFileFilter(filter);
        }
        String title = "Select File";
        if (isFolder == true) {
            fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            title = "Select Folder";
        }

        if (fc.showDialog(this, title) == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();

            String path = file.getPath();
            if (isFolder == true && path.lastIndexOf(File.separator) != path.length() - 1) {
                path = path + File.separator;
            }

            return path;
        } else {
            return currentDir;
        }
    }
    
    private void UpdateTree(int index) throws Exception {
        gui.getCurrentSentenceListComponent().setSelectedSentence(index);
        gui.changeViewMode(cboViewMode.getSelectedIndex() + 1);

        TreeViewer tv = gui.getMediators().get(0);
        javax.swing.JPanel pnl = tv.getSplitPane();
        pnlInputTree.removeAll();
        pnlInputTree.setLayout(new GridLayout());
        pnlInputTree.add(pnl);
        pnlInputTree.revalidate();

        tv = gui.getMediators().get(1);
        pnl = tv.getSplitPane();
        pnlOutputTree.removeAll();
        pnlOutputTree.setLayout(new GridLayout());
        pnlOutputTree.add(pnl);
        pnlOutputTree.revalidate();

        lblCurrentTotal.setText(gui.getCurrentSentence() + " / " + gui.getSentenceCount());
        
        if (index == sliderSentences.getMaximum())
            btnNext.setEnabled(false);
        else
            btnNext.setEnabled(true);
        
        if (index == sliderSentences.getMinimum())
            btnPrev.setEnabled(false);
        else
            btnPrev.setEnabled(true);
        
        // Conll Output
//        DefaultTableModel model = (DefaultTableModel) tblConll.getModel();
//        model.setRowCount(0);
//        TreeViewerSentence sentence = gui.getSentenceList().getSentence(gui.getCurrentSentence());
//        for(int i = 1; i<pdg.nDependencyNode(); i++){
//            MaltWord word = sentence.getWord(i);
//            model.addRow(new String[]{
//                String.valueOf(i),
//                word.getForm(),
//                word.getLemma(),
//                word.getPostag(),
//                word.getFeats(),
//                String.valueOf(word.getHead()),
//                word.getDeprel()
//            });
//        }
    }
    
    private void ChangeViewMode() {
        if (gui != null) {
            gui.changeViewMode(cboViewMode.getSelectedIndex() + 1);
        }
    }
    
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TreebankTransformer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new TreebankTransformer().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgDirection;
    private javax.swing.ButtonGroup bgNumberTransform;
    private javax.swing.ButtonGroup bgPOSCopy;
    private javax.swing.JButton btnAddAttrib;
    private javax.swing.JButton btnBrowseInputFile;
    private javax.swing.JButton btnBrowseOutputPath;
    private javax.swing.JButton btnNext;
    private javax.swing.JButton btnNextChange;
    private javax.swing.JButton btnPrev;
    private javax.swing.JToggleButton btnPrevChange;
    private javax.swing.JButton btnRemoveAttrib;
    private javax.swing.JButton btnStart;
    private javax.swing.JComboBox cboViewMode;
    private javax.swing.JCheckBox chkCompoundVerb;
    private javax.swing.JCheckBox chkCopyL2F;
    private javax.swing.JCheckBox chkRaTransform;
    private javax.swing.JCheckBox chkRemoveDeprelHead;
    private javax.swing.JCheckBox chkRmSpaces;
    private javax.swing.JCheckBox chkSetHeadsDeprelRoot;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblAddAttrib;
    private javax.swing.JLabel lblCurrentTotal;
    private javax.swing.JLabel lblInputFile;
    private javax.swing.JLabel lblOutputPath;
    private javax.swing.JLabel lblRemoveAttrib;
    private javax.swing.JLabel lblViewMode;
    private javax.swing.JList listAddAttrib;
    private javax.swing.JList listRemoveAttrib;
    private javax.swing.JMenuBar mnuMain;
    private javax.swing.JPanel pnlCopyPOS;
    private javax.swing.JPanel pnlDirection;
    private javax.swing.JPanel pnlGlobalSettings;
    private javax.swing.JPanel pnlInputTree;
    private javax.swing.JPanel pnlMain;
    private javax.swing.JPanel pnlNavigation;
    private javax.swing.JPanel pnlNumber;
    private javax.swing.JPanel pnlOutputTree;
    private javax.swing.JPanel pnlResults;
    private javax.swing.JPanel pnlSettings;
    private javax.swing.JRadioButton rbBinning;
    private javax.swing.JRadioButton rbCPOSinPOS;
    private javax.swing.JRadioButton rbCopyNone;
    private javax.swing.JRadioButton rbLtr;
    private javax.swing.JRadioButton rbNone;
    private javax.swing.JRadioButton rbNormalNumber;
    private javax.swing.JRadioButton rbPOSinCPOS;
    private javax.swing.JRadioButton rbRtl;
    private javax.swing.JSlider sliderSentences;
    private javax.swing.JTabbedPane tabSetting;
    private javax.swing.JTextField txtAddAttrib;
    private javax.swing.JTextField txtInputFile;
    private javax.swing.JTextField txtOutputPath;
    private javax.swing.JTextField txtRemoveAttrib;
    // End of variables declaration//GEN-END:variables

    JButton nextError;
    JButton prevError;
    private void GetGUIComponent() {
        // Navigation Panel
        JPanel pnlButtons = (JPanel)new NavigationPanel(gui).getComponent(1);
        this.prevError = (JButton)pnlButtons.getComponent(4);
        this.nextError = (JButton)pnlButtons.getComponent(5);
    }
}