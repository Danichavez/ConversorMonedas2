package com.aluracursos.conversormoneda.modelos;
import javax.swing.JOptionPane;

public class SeleccionOpciones {
    public static String seleccionarConversion() {
        String[] opciones = {
                "De Pesos a Dólar",
                "De Pesos a Euro",
                "De Pesos a Libras",
                "De Pesos a Yen",
                "De Pesos a Won Coreano",
                "De Dólar a Pesos",
                "De Euro a Pesos",
                "De Libras a Pesos"
        };

        return (String) JOptionPane.showInputDialog(null, "Seleccione el tipo de conversión:", "Seleccionar Opción",
                JOptionPane.PLAIN_MESSAGE, null, opciones, opciones[0]);
    }
}
