package com.aluracursos.conversormoneda.principal;
import com.aluracursos.conversormoneda.modelos.EntradaValor;
import com.aluracursos.conversormoneda.modelos.Resultado;
import com.aluracursos.conversormoneda.modelos.SeleccionOpciones;

public class Principal {
    public static void main(String[] args) {
        double valorAConvertir = EntradaValor.obtenerValor();
        if (valorAConvertir == 0.0) {
            System.out.println("Operación cancelada.");
            return;
        }

        String seleccion = SeleccionOpciones.seleccionarConversion();
        if (seleccion == null) {
            System.out.println("Operación cancelada.");
            return;
        }

        String[] partes = seleccion.split(" ");
        String monedaOrigen = partes[1];
        String monedaDestino = partes[3];

        // Interpretación de tipo de selección monedas
        if (monedaOrigen.equals("Pesos") && monedaDestino.equals("Dólar")) {
            monedaOrigen = "CLP";
            monedaDestino = "USD";}

        else if (monedaOrigen.equals("Pesos") && monedaDestino.equals("Euro")) {
            monedaOrigen = "CLP";
            monedaDestino = "EUR";  }
        else if (monedaOrigen.equals("Pesos") && monedaDestino.equals("Libras")) {
            monedaOrigen = "CLP";
            monedaDestino = "GBP";  }
        else if (monedaOrigen.equals("Pesos") && monedaDestino.equals("Yen")) {
            monedaOrigen = "CLP";
            monedaDestino = "JPY";  }
        else if (monedaOrigen.equals("Pesos") && monedaDestino.equals("Won")) {
            monedaOrigen = "CLP";
            monedaDestino = "KRW";  }
        else if (monedaOrigen.equals("Dólar") && monedaDestino.equals("Pesos")) {
            monedaOrigen = "USD";
            monedaDestino = "CLP";}
        else if (monedaOrigen.equals("Euro") && monedaDestino.equals("Pesos")) {
            monedaOrigen = "EUR";
            monedaDestino = "CLP";  }
        else if (monedaOrigen.equals("Libras") && monedaDestino.equals("Pesos")) {
            monedaOrigen = "EUR";
            monedaDestino = "GBP";  }
        else {
            // Otros tipos de conversión si es necesario
            System.out.println("Tipo de conversión no compatible.");
            return;
        }

        Resultado resultado = new Resultado();
        double resultadoConversion = resultado.obtenerResultado(valorAConvertir, monedaOrigen, monedaDestino);
        System.out.println("Resultado de la conversión: " + resultadoConversion);
    }
}
