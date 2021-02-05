/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package casaortiz.view;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author jorge
 */
public class VerificarSoloNumeros extends InputVerifier{
    
    Pattern regexNumero = Pattern.compile("^[0-9]+([.][0-9]+)?$");
    Matcher mat;

    @Override
    public boolean verify(JComponent jc) {        
        if(jc instanceof JTextField){
            String texto = ((JTextField) jc).getText();
            mat = regexNumero.matcher(texto);
            if(mat.matches()){
                return true;
            }
            JOptionPane.showMessageDialog(jc, "Por favor ingresar solo números o usar punto para separar decimales");
            System.out.println("Error: ingresar solo números");
            return false;
        }
        return false;
    }
}