/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Restaurants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Ashish
 */
public class Calculator extends javax.swing.JFrame implements ActionListener{

    double firstNum, secondNum, result ;
    String operation, whoSigned, time,time1, date, ProdName[], ProdPrice[], ProdQuant[];
    public Calculator() {
        initComponents();
        setTitle("Calculator");
        setLocationRelativeTo(null);
        AddActionOfCalculaor();
    }
    private void AddActionOfCalculaor() {
        Zero.addActionListener(this);
        One.addActionListener(this);
        Two.addActionListener(this);
        Three.addActionListener(this);
        Four.addActionListener(this);
        Five.addActionListener(this);
        Six.addActionListener(this);
        Seven.addActionListener(this);
        Eight.addActionListener(this);
        Nine.addActionListener(this);
        Dot.addActionListener(this);
        PlusButton.addActionListener(this);
        CutButton.addActionListener(this);
        Multiplication.addActionListener(this);
        Divide.addActionListener(this);
        Minus.addActionListener(this);
        PlusMinusButton.addActionListener(this);
        ArrowButton.addActionListener(this);
        Equal.addActionListener(this);
    }
        private void CalculatorOperationOnEqualClick(){
        String answer;
        secondNum = Double.parseDouble(DisplayField.getText());
        if(operation=="+")
        {
            result = firstNum + secondNum;
            answer = String.format("%.2f", result);
            DisplayField.setText(answer);
        }
        if(operation=="-")
        {
            result = firstNum - secondNum;
            answer = String.format("%.2f", result);
            DisplayField.setText(answer);
        }
        if(operation=="*")
        {
            result = firstNum * secondNum;
            answer = String.format("%.2f", result);
            DisplayField.setText(answer);
        }
        if(operation=="/")
        {
            result = firstNum / secondNum;
            answer = String.format("%.2f", result);
            DisplayField.setText(answer);
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //CALCULATOR CODE STARTS FROM HERE.....
        if (e.getSource() == Zero) {
            String Number = DisplayField.getText() + Zero.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == One) {
            String Number = DisplayField.getText() + One.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Two) {
            String Number = DisplayField.getText() + Two.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Three) {
            String Number = DisplayField.getText() + Three.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Four) {
            String Number = DisplayField.getText() + Four.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Five) {
            String Number = DisplayField.getText() + Five.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Six) {
            String Number = DisplayField.getText() + Six.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Seven) {
            String Number = DisplayField.getText() + Seven.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Eight) {
            String Number = DisplayField.getText() + Eight.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Nine) {
            String Number = DisplayField.getText() + Nine.getText();
            DisplayField.setText(Number);
        }
        if (e.getSource() == Dot) {
            DisplayField.setText(DisplayField.getText() + Dot.getText());
        }
        if (e.getSource() == ArrowButton) {
            String backspace = null;
            if (DisplayField.getText().length() > 0) {
                StringBuilder strB = new StringBuilder(DisplayField.getText());
                strB.deleteCharAt(DisplayField.getText().length() - 1);
                backspace = strB.toString();
                DisplayField.setText(backspace);
            }

        }
        if (e.getSource() == CutButton) {
            DisplayField.setText(null);
        }
        if (e.getSource() == PlusButton) {
            firstNum = Double.parseDouble(DisplayField.getText());
            DisplayField.setText("");
            operation = "+";
        }
        if (e.getSource() == Minus) {
            firstNum = Double.parseDouble(DisplayField.getText());
            DisplayField.setText("");
            operation = "-";
        }
        if (e.getSource() == Multiplication) {
            firstNum = Double.parseDouble(DisplayField.getText());
            DisplayField.setText("");
            operation = "*";
        }
        if (e.getSource() == Divide) {
            firstNum = Double.parseDouble(DisplayField.getText());
            DisplayField.setText("");
            operation = "/";
        }
        if(e.getSource()== PlusMinusButton){
            double d = Double.parseDouble(String.valueOf(DisplayField.getText()));
            d = d*(-1);
            DisplayField.setText(String.valueOf(d));
        }
        if(e.getSource()== Equal){
            CalculatorOperationOnEqualClick();
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

        jPanel7 = new javax.swing.JPanel();
        DisplayField = new javax.swing.JTextField();
        ArrowButton = new javax.swing.JButton();
        PlusButton = new javax.swing.JButton();
        PlusMinusButton = new javax.swing.JButton();
        CutButton = new javax.swing.JButton();
        Minus = new javax.swing.JButton();
        Nine = new javax.swing.JButton();
        Eight = new javax.swing.JButton();
        Seven = new javax.swing.JButton();
        Multiplication = new javax.swing.JButton();
        Six = new javax.swing.JButton();
        Five = new javax.swing.JButton();
        Four = new javax.swing.JButton();
        Divide = new javax.swing.JButton();
        Three = new javax.swing.JButton();
        Two = new javax.swing.JButton();
        One = new javax.swing.JButton();
        Equal = new javax.swing.JButton();
        Dot = new javax.swing.JButton();
        Zero = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setBackground(new java.awt.Color(255, 255, 0));

        DisplayField.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        DisplayField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        DisplayField.setText("0");
        DisplayField.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 4));

        ArrowButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        ArrowButton.setText("<=");
        ArrowButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        PlusButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PlusButton.setText("+");
        PlusButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        PlusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusButtonActionPerformed(evt);
            }
        });

        PlusMinusButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        PlusMinusButton.setText("+/-");
        PlusMinusButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        PlusMinusButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlusMinusButtonActionPerformed(evt);
            }
        });

        CutButton.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        CutButton.setText("C");
        CutButton.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        CutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CutButtonActionPerformed(evt);
            }
        });

        Minus.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Minus.setText("-");
        Minus.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MinusActionPerformed(evt);
            }
        });

        Nine.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Nine.setText("9");
        Nine.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Nine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NineActionPerformed(evt);
            }
        });

        Eight.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Eight.setText("8");
        Eight.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Eight.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EightActionPerformed(evt);
            }
        });

        Seven.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Seven.setText("7");
        Seven.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        Multiplication.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Multiplication.setText("*");
        Multiplication.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Multiplication.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MultiplicationActionPerformed(evt);
            }
        });

        Six.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Six.setText("6");
        Six.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Six.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SixActionPerformed(evt);
            }
        });

        Five.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Five.setText("5");
        Five.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Five.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FiveActionPerformed(evt);
            }
        });

        Four.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Four.setText("4");
        Four.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        Divide.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Divide.setText("/");
        Divide.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Divide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DivideActionPerformed(evt);
            }
        });

        Three.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Three.setText("3");
        Three.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Three.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThreeActionPerformed(evt);
            }
        });

        Two.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Two.setText("2");
        Two.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Two.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoActionPerformed(evt);
            }
        });

        One.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        One.setText("1");
        One.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        Equal.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Equal.setText("=");
        Equal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Equal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EqualActionPerformed(evt);
            }
        });

        Dot.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Dot.setText(".");
        Dot.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));
        Dot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DotActionPerformed(evt);
            }
        });

        Zero.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Zero.setText("0");
        Zero.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, null));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DisplayField)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(ArrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(CutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PlusMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Seven, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Eight, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Nine, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Minus, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Zero, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Dot, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Equal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(One, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Two, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Three, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Divide, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(Four, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Five, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Six, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DisplayField, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ArrowButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlusMinusButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Seven, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Minus, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Nine, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Eight, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Four, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Multiplication, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Six, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Five, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(One, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Divide, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Three, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Two, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Zero, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Equal, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Dot, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 392, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(12, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(12, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 499, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void PlusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlusButtonActionPerformed

    private void PlusMinusButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlusMinusButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PlusMinusButtonActionPerformed

    private void CutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CutButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CutButtonActionPerformed

    private void MinusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MinusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MinusActionPerformed

    private void NineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NineActionPerformed

    private void EightActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EightActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EightActionPerformed

    private void MultiplicationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MultiplicationActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MultiplicationActionPerformed

    private void SixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SixActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SixActionPerformed

    private void FiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FiveActionPerformed

    private void DivideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DivideActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DivideActionPerformed

    private void ThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThreeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ThreeActionPerformed

    private void TwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TwoActionPerformed

    private void EqualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EqualActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EqualActionPerformed

    private void DotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DotActionPerformed

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
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Calculator.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Calculator().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ArrowButton;
    private javax.swing.JButton CutButton;
    private javax.swing.JTextField DisplayField;
    private javax.swing.JButton Divide;
    private javax.swing.JButton Dot;
    private javax.swing.JButton Eight;
    private javax.swing.JButton Equal;
    private javax.swing.JButton Five;
    private javax.swing.JButton Four;
    private javax.swing.JButton Minus;
    private javax.swing.JButton Multiplication;
    private javax.swing.JButton Nine;
    private javax.swing.JButton One;
    private javax.swing.JButton PlusButton;
    private javax.swing.JButton PlusMinusButton;
    private javax.swing.JButton Seven;
    private javax.swing.JButton Six;
    private javax.swing.JButton Three;
    private javax.swing.JButton Two;
    private javax.swing.JButton Zero;
    private javax.swing.JPanel jPanel7;
    // End of variables declaration//GEN-END:variables

    
}
