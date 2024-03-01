package com.example.myjavafx;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;


public class StoneStoryController {

    @FXML
    private TextField ElemDmgTextField;
    @FXML
    private CheckBox ElemDmgCheckbox;

    public void ElemDmgCheckboxAction() {
        double x = ElemDmgCheckbox.getLayoutX();
        if (ElemDmgCheckbox.isSelected()) {
            ElemDmgCheckbox.setLayoutX(x += 83);
            ElemDmgTextField.setVisible(true);
        } else {
            ElemDmgCheckbox.setLayoutX(x -= 83);
            ElemDmgTextField.setVisible(false);
        }
    }

    @FXML
    private CheckBox ArmMultiCheckbox;
    @FXML
    private TextField ArmMultiTextField;

    public void ArmMultiCheckboxAction() {
        double x = ArmMultiCheckbox.getLayoutX();
        if (ArmMultiCheckbox.isSelected()) {
            ArmMultiCheckbox.setLayoutX(x += 81);
            ArmMultiTextField.setVisible(true);
        } else {
            ArmMultiCheckbox.setLayoutX(x -= 81);
            ArmMultiTextField.setVisible(false);
        }
    }

    @FXML
    private Label AtkSpdLabel;
    @FXML
    private CheckBox AtkSpdCheckbox;
    @FXML
    private Label DamagePerSecond;
    @FXML
    private TextField DmgPerSecTextField;

    public void AtkSpdCheckboxAction() {
        double x = AtkSpdCheckbox.getLayoutX();
        if (AtkSpdCheckbox.isSelected()) {
            AtkSpdLabel.setVisible(false);
            AtkSpdTextField.setVisible(false);
            DmgPerSecTextField.setVisible(true);
            DamagePerSecond.setVisible(true);
            AtkSpdCheckbox.setLayoutX(x + 70);
        } else {
            AtkSpdLabel.setVisible(true);
            AtkSpdTextField.setVisible(true);
            DmgPerSecTextField.setVisible(false);
            DamagePerSecond.setVisible(false);
            AtkSpdCheckbox.setLayoutX(x - 70);
        }

    }

    @FXML
    private CheckBox CritCheckBox;
    @FXML
    private TextField CritRateTextField;
    @FXML
    private Label CritColon;
    @FXML
    private Label CritDamage;
    @FXML
    private TextField CritDamageTextField;

    public void CritCheckboxAction() {
        double x = CritCheckBox.getLayoutX();
        if (CritCheckBox.isSelected()) {
            CritCheckBox.setLayoutX(x += 86);
            CritRateTextField.setVisible(true);
            CritColon.setVisible(true);
            CritDamage.setVisible(true);
            CritDamageTextField.setVisible(true);
        } else {
            CritCheckBox.setLayoutX(x -= 86);
            CritRateTextField.setVisible(false);
            CritColon.setVisible(false);
            CritDamage.setVisible(false);
            CritDamageTextField.setVisible(false);
        }
    }

    @FXML
    private Button EnterButton;
    @FXML
    private TextField WeaponNameTextField;
    @FXML
    private TextField LevelTextField;
    @FXML
    private TextField EnchantmentLevelTextField;
    @FXML
    private TextField AtkSpdTextField;
    @FXML
    private TextField BaseDmgTextField;
    @FXML
    private Label OutputText;
    @FXML
    int Level;
    String WeaponName;
    int EnchantmentLevel;
    float AtkSpd;
    int BaseDmg;
    int ElementalDamage;
    float ArmMulti;
    float DmgPerSec;
    float CritRate;
    float CritDamageNum;
    public void Enter(javafx.event.ActionEvent Event) {

        WeaponName = WeaponNameTextField.getText();

        try {
            String OutputError = null;
            BaseDmg = Integer.parseInt(BaseDmgTextField.getText());
            if (!LevelTextField.getText().isEmpty()) {
                Level = Integer.parseInt(LevelTextField.getText());
            }
            if (!EnchantmentLevelTextField.getText().isEmpty()) {
                EnchantmentLevel = Integer.parseInt(EnchantmentLevelTextField.getText());
            }
            if (ElemDmgTextField.isVisible()) {
                ElementalDamage = Integer.parseInt(ElemDmgTextField.getText());
            }
            if (ArmMultiTextField.isVisible()) {
                ArmMulti = Float.parseFloat(ArmMultiTextField.getText());
            }
            if (AtkSpdTextField.isVisible()) {
                AtkSpd = Integer.parseInt(AtkSpdTextField.getText());
            }
            if (DmgPerSecTextField.isVisible()) {
                DmgPerSec = Float.parseFloat(DmgPerSecTextField.getText());
            }
            if (CritDamageTextField.isVisible()) {
                CritDamageNum = Float.parseFloat(CritDamageTextField.getText());
            }
            if (CritRateTextField.isVisible()) {
                CritRate = Float.parseFloat(CritRateTextField.getText());
            }

            String OutputText2 = null;
            if (!WeaponNameTextField.getText().isEmpty()) {
                OutputText2 = "The " + WeaponName + " ";
            }
            else if (WeaponNameTextField.getText().isEmpty()){
                OutputText2 = "The weapon ";
            }
            if (LevelTextField.getText().isEmpty()){
                OutputError = "Level pls";
            }
            else {
                Level += EnchantmentLevel;
                OutputText2 += "with the level of " + Level + " ";
            }

            float TotalBaseDamage = BaseDmg + ElementalDamage;
            if (DmgPerSecTextField.isVisible()) {
                AtkSpd = DmgPerSec / TotalBaseDamage;
            }
            OutputText2 += "has a damage of " + TotalBaseDamage + " and attacks " + AtkSpd + " times per second. ";

            if (ElemDmgTextField.isVisible() && ArmMultiTextField.isVisible() && CritRateTextField.isVisible()) {
                OutputError = "Now.. you can't have all the stat boosters";
            }
            else if (ArmMultiTextField.isVisible() && CritRateTextField.isVisible()) {
                OutputError = "Nope";
            }
            else if (ArmMultiTextField.isVisible()) {
                float DamageAgainstArmoredFoes = TotalBaseDamage * ArmMulti;
                float AverageDamagePerSecond = TotalBaseDamage * AtkSpd;
                OutputText2 += "It has a average damage of " + AverageDamagePerSecond + " and does " + DamageAgainstArmoredFoes + " to armored foes.";
            }
            else if (CritRateTextField.isVisible()) {
                float AverageDamagePerSecond = (TotalBaseDamage + TotalBaseDamage * CritRate * CritDamageNum) * AtkSpd;
                OutputText2 += "It has an average damage of " + AverageDamagePerSecond + ".";
            }
            else {
                float AverageDamagePerSecond = TotalBaseDamage * AtkSpd;
                OutputText2 += "It has an average damage of " + AverageDamagePerSecond + ".";
            }

            if (OutputText2.length() > 50) {
                int a;
                String NewLine = "\n";
                for (a = 49; a < 57; a++) {
                    if (OutputText2.charAt(a) == ' ') {
                        StringBuilder sb = new StringBuilder(OutputText2);
                        sb.insert(a+1, NewLine);
                        OutputText2 = sb.toString();
                        break;
                    }
                }
                if (OutputText2.length() > 101) {
                    for (int b = 50 + a; b < 58 + a; b++) {
                        if (OutputText2.charAt(b) == ' ') {
                            StringBuilder sb = new StringBuilder(OutputText2);
                            sb.insert(b + 1, NewLine);
                            OutputText2 = sb.toString();
                            break;
                        }
                    }
                }
            }

            if (OutputError == null) {
                OutputText.setText(OutputText2);
            }
            else {
                OutputText.setText(OutputError);
            }


        }
        catch (NumberFormatException e) {
            System.out.print("Error");
            if (BaseDmgTextField.getText().isEmpty()) {
                OutputText.setText("Base damage needed");
            }
            else if (ElemDmgTextField.getText().isEmpty() && ElemDmgTextField.isVisible()) {
                OutputText.setText("Elemental damage needed");
            }
            else if (ArmMultiTextField.getText().isEmpty() && ArmMultiTextField.isVisible()) {
                OutputText.setText("Armor multiplier needed");
            }
            else if (AtkSpdTextField.getText().isEmpty() && AtkSpdTextField.isVisible()) {
                OutputText.setText("Attack speed needed");
            }
            else if (DmgPerSecTextField.getText().isEmpty() && DmgPerSecTextField.isVisible()) {
                OutputText.setText("Damage per second needed");
            }
            else if (CritRateTextField.getText().isEmpty() && CritRateTextField.isVisible()) {
                OutputText.setText("Crit rate needed");
            }
            else if (CritDamageTextField.getText().isEmpty() && CritRateTextField.isVisible()) {
                OutputText.setText("Crit damage needed");
            }

        }
        catch (Exception e){
            String str = "uhhh, some error i'm too lazy to fix. If it works it works.";
            System.out.print(str);
            if (str.length() > 50) {
                int a;
                String NewLine = "\n";
                for (a = 49; a < 57; a++) {
                    if (str.charAt(a) == ' ') {
                        StringBuilder sb = new StringBuilder(str);
                        sb.insert(a+1, NewLine);
                        str = sb.toString();
                        break;
                    }
                }
                for (int b = 50+a; b < 58+a; b++){
                    if (str.charAt(b) == ' '){
                        StringBuilder sb = new StringBuilder(str);
                        sb.insert(b+1, NewLine);
                        str = sb.toString();
                        break;
                    }
                }
            }
        }
    }
}