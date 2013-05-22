/*
 * MonomerManager.java
 *
 * Created on November 24, 2008, 12:59 PM
 */
package org.helm.editor.manager;

import org.helm.editor.componentPanel.sequenceviewpanel.SequenceViewLayout;
import org.helm.editor.editor.MacromoleculeEditor;
import org.helm.editor.manager.OligonucleotideFragmentTableModel.Fragment;
import org.helm.editor.renderer.HELMGraphTableCellRenderer;
import org.helm.editor.worker.OligonucleotideFragmenter;
import org.helm.notation.tools.ComplexNotationParser;
import java.awt.Cursor;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumn;

/**
 *
 * @author  zhangtianhong
 */
public class OligonucleotideFragmentDialog extends javax.swing.JDialog {

    private MacromoleculeEditor editor;
    private OligonucleotideFragmentTableModel model;

    public OligonucleotideFragmentDialog(MacromoleculeEditor editor, boolean modal) {
        super(editor.getFrame(), modal);
        this.editor = editor;
        initComponents();
        customInit();
    }

    private void customInit() {
        int defaultRowHeight = fragmentTable.getRowHeight();
        fragmentTable.setRowHeight(defaultRowHeight * 2);
        model = new OligonucleotideFragmentTableModel();
        fragmentTable.setModel(model);
        List<TableColumn> columns = fragmentTable.getColumns();
        for (TableColumn column : columns) {
            if (column.getModelIndex() == OligonucleotideFragmentTableModel.STRUCTURE_COLUMN_INDEX) {
                column.setCellRenderer(new HELMGraphTableCellRenderer(HELMGraphTableCellRenderer.MINIMAL_GAP_VIEW_TYPE, SequenceViewLayout.LEFT_ALIGNMENT));
            } else {
                column.setMaxWidth(OligonucleotideFragmentTableModel.NON_STRUCTURE_COLUMN_MAX_WIDTH);
            }
        }
    }

    public void refreshResults(List<Fragment> fragments) {
        //remove table sorting first
        fragmentTable.resetSortOrder();
        model.setFragments(fragments);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        monomerNumberbuttonGroup = new javax.swing.ButtonGroup();
        configPanel = new javax.swing.JPanel();
        directionLabel = new javax.swing.JLabel();
        fiveEndCheckBox = new javax.swing.JCheckBox();
        threeEndCheckBox = new javax.swing.JCheckBox();
        monomerNumLabel = new javax.swing.JLabel();
        stepLabel = new javax.swing.JLabel();
        stepTextField = new javax.swing.JTextField();
        monomerNumber1RadioButton = new javax.swing.JRadioButton();
        monomerNumber2RadioButton = new javax.swing.JRadioButton();
        midButtonPanel = new javax.swing.JPanel();
        fragmentButton = new javax.swing.JButton();
        loadToEditorButton1 = new javax.swing.JButton();
        resultPanel = new javax.swing.JPanel();
        tableScrollPane = new javax.swing.JScrollPane();
        fragmentTable = new org.jdesktop.swingx.JXTable();
        bottomButtonPanel = new javax.swing.JPanel();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HELM Editor Oligonucleotide Fragmenter");

        configPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Fragmentation Setup"));

        directionLabel.setText("Where to start fragmentation?  ");

        fiveEndCheckBox.setText("5' End");
        fiveEndCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        threeEndCheckBox.setSelected(true);
        threeEndCheckBox.setText("3' End");
        threeEndCheckBox.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        monomerNumLabel.setText("How many backbone monomers to remove per step? ");

        stepLabel.setText("What is the maximum number of steps to perform?");

        stepTextField.setText("4");

        monomerNumberbuttonGroup.add(monomerNumber1RadioButton);
        monomerNumber1RadioButton.setText("1");
        monomerNumber1RadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        monomerNumberbuttonGroup.add(monomerNumber2RadioButton);
        monomerNumber2RadioButton.setSelected(true);
        monomerNumber2RadioButton.setText("2");
        monomerNumber2RadioButton.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        org.jdesktop.layout.GroupLayout configPanelLayout = new org.jdesktop.layout.GroupLayout(configPanel);
        configPanel.setLayout(configPanelLayout);
        configPanelLayout.setHorizontalGroup(
            configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(configPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                        .add(stepLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(monomerNumLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(directionLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(configPanelLayout.createSequentialGroup()
                        .add(fiveEndCheckBox)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(threeEndCheckBox))
                    .add(configPanelLayout.createSequentialGroup()
                        .add(monomerNumber1RadioButton)
                        .add(26, 26, 26)
                        .add(monomerNumber2RadioButton))
                    .add(stepTextField))
                .addContainerGap())
        );
        configPanelLayout.setVerticalGroup(
            configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(configPanelLayout.createSequentialGroup()
                .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(fiveEndCheckBox)
                    .add(threeEndCheckBox)
                    .add(directionLabel))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(monomerNumLabel)
                    .add(monomerNumber1RadioButton)
                    .add(monomerNumber2RadioButton))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(configPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(stepLabel)
                    .add(stepTextField, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
        );

        midButtonPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        fragmentButton.setText("Fragment Sequence from Editor");
        fragmentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fragmentButtonActionPerformed(evt);
            }
        });

        loadToEditorButton1.setText("Load Selected Sequence into Editor");
        loadToEditorButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadToEditorButton1ActionPerformed(evt);
            }
        });

        midButtonPanel.add(javax.swing.Box.createHorizontalGlue());

        org.jdesktop.layout.GroupLayout midButtonPanelLayout = new org.jdesktop.layout.GroupLayout(midButtonPanel);
        midButtonPanel.setLayout(midButtonPanelLayout);
        midButtonPanelLayout.setHorizontalGroup(
            midButtonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(midButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .add(midButtonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, fragmentButton, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(org.jdesktop.layout.GroupLayout.LEADING, loadToEditorButton1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        midButtonPanelLayout.setVerticalGroup(
            midButtonPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(midButtonPanelLayout.createSequentialGroup()
                .add(16, 16, 16)
                .add(fragmentButton)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(loadToEditorButton1)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        midButtonPanel.add(javax.swing.Box.createHorizontalGlue());

        resultPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Fragmentation Results"));

        fragmentTable.setModel(new javax.swing.table.DefaultTableModel(
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
        tableScrollPane.setViewportView(fragmentTable);

        org.jdesktop.layout.GroupLayout resultPanelLayout = new org.jdesktop.layout.GroupLayout(resultPanel);
        resultPanel.setLayout(resultPanelLayout);
        resultPanelLayout.setHorizontalGroup(
            resultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        resultPanelLayout.setVerticalGroup(
            resultPanelLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(tableScrollPane, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
        );

        bottomButtonPanel.setLayout(new javax.swing.BoxLayout(bottomButtonPanel, javax.swing.BoxLayout.LINE_AXIS));
        bottomButtonPanel.add(javax.swing.Box.createHorizontalGlue());

        closeButton.setText("Close");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        bottomButtonPanel.add(closeButton);

        bottomButtonPanel.add(javax.swing.Box.createHorizontalGlue());

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(bottomButtonPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 672, Short.MAX_VALUE)
            .add(layout.createSequentialGroup()
                .add(configPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(midButtonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
            .add(resultPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(midButtonPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(configPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(resultPanel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(bottomButtonPanel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void fragmentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fragmentButtonActionPerformed
    model.clear();

    OligonucleotideFragmentTableModel.FragmentationParameter parameter = new OligonucleotideFragmentTableModel.FragmentationParameter();
    parameter.setInputComplexNotation(editor.getNotation());
    parameter.setStartFromFiveEnd(fiveEndCheckBox.isSelected());
    parameter.setStartFromThreeEnd(threeEndCheckBox.isSelected());
    parameter.setMonomerNumber((monomerNumber1RadioButton.isSelected()) ? 1 : 2);
    parameter.setStepText(stepTextField.getText());
    String validationResult = parameter.validate();

    if (validationResult.length() > 0) {
        JOptionPane.showMessageDialog(this, "Unable to perform oligonucleotide fragmentation due to the following error(s):\n" + validationResult, "Fragmentation Warning", JOptionPane.WARNING_MESSAGE);
        return;
    }

    OligonucleotideFragmenter worker = new OligonucleotideFragmenter(this, parameter);
    worker.execute();
    setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
}//GEN-LAST:event_fragmentButtonActionPerformed

private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
    setVisible(false);
}//GEN-LAST:event_closeButtonActionPerformed

private void loadToEditorButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadToEditorButton1ActionPerformed
    if (model.getRowCount() == 0) {
        JOptionPane.showMessageDialog(this, "The fragmentation result table is empty!", "Load Selected Sequence into Editor", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int rowIndex = fragmentTable.getSelectedRow();
    if (rowIndex < 0) {
        JOptionPane.showMessageDialog(this, "Please select a record from the fragmentation result table first!", "Load Selected Sequence into Editor", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int modelIndex = fragmentTable.convertRowIndexToModel(rowIndex);
    String selectedNotation = model.getFragments().get(modelIndex).getNotation();
    String oldNotation = editor.getNotation();
    try {
        String newNotation = ComplexNotationParser.getCombinedComlexNotation(oldNotation, selectedNotation);
        editor.setNotation(newNotation);
        editor.getFrame().setVisible(true);
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error combining selected sequence with editor structure!", "Load Selected Sequence into Editor", JOptionPane.ERROR_MESSAGE);
        Logger.getLogger(OligonucleotideFragmentDialog.class.getName()).log(Level.SEVERE, null, ex);
    }
}//GEN-LAST:event_loadToEditorButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomButtonPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel configPanel;
    private javax.swing.JLabel directionLabel;
    private javax.swing.JCheckBox fiveEndCheckBox;
    private javax.swing.JButton fragmentButton;
    private org.jdesktop.swingx.JXTable fragmentTable;
    private javax.swing.JButton loadToEditorButton1;
    private javax.swing.JPanel midButtonPanel;
    private javax.swing.JLabel monomerNumLabel;
    private javax.swing.JRadioButton monomerNumber1RadioButton;
    private javax.swing.JRadioButton monomerNumber2RadioButton;
    private javax.swing.ButtonGroup monomerNumberbuttonGroup;
    private javax.swing.JPanel resultPanel;
    private javax.swing.JLabel stepLabel;
    private javax.swing.JTextField stepTextField;
    private javax.swing.JScrollPane tableScrollPane;
    private javax.swing.JCheckBox threeEndCheckBox;
    // End of variables declaration//GEN-END:variables
}