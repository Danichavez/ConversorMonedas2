package com.aluracursos.conversormoneda.modelos;

import javax.swing.JOptionPane;

public class EntradaValor {
    public static double obtenerValor() {
        String valorStr = JOptionPane.showInputDialog(null, "Ingrese el valor a convertir:");
        if (valorStr == null || valorStr.isEmpty()) {
            return 0.0;
        } else {
            try {
                return Double.parseDouble(valorStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
                return 0.0;
            }
        }
    }
}