package principal;

import modelo.Transaccion;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Transaccion transaccion = new Transaccion();


        System.out.println("*************************************************");
        System.out.println("Bienvenidos al connversor de monedas AluraCash");

        String lol;
        String eleccionMoneda;
        String monedaOrigen = "";
        String monedaDestino = "";
        Double tasaConversion;
        String eleccionMonto;

        do {

            System.out.println("*************************************************\n");
            System.out.println("Elija la opción de la connversión: \n");
            System.out.println("1: Pesos Argentinos ARS   ->  Dólares USD");
            System.out.println("2: Dólares USD ´          ->  Pesos Argentinos ARS");
            System.out.println("3: Reales Brasileños BRL  ->  Dólares USD");
            System.out.println("4: Dólares USD            ->  Reales Brasileños BRL");
            System.out.println("5: Pesos Colombianos COP  ->  Dólares USD");
            System.out.println("6: Dólares USD            ->  Pesos Colombianos COP");
            System.out.println("7: Salir");
            System.out.println("*************************************************");

            eleccionMoneda = scanner.nextLine().toLowerCase();
            boolean convertir = true;
            switch (eleccionMoneda) {
                case "1":

                    //   System.out.println("ARS a USD");
                    monedaOrigen = "ARS";
                    monedaDestino = "USD";
                    break;
                case "2":
                    //    System.out.println("USD a ARS");
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case "3":
                    //    System.out.println("BRL a USD");
                    monedaOrigen = "BRL";
                    monedaDestino = "USD";
                    break;
                case "4":
                    //     System.out.println("USD a BRL");
                    monedaOrigen = "USD";
                    monedaDestino = "BRL";
                    break;
                case "5":
                    //     System.out.println("COP a USD");
                    monedaOrigen = "COP";
                    monedaDestino = "USD";
                    break;
                case "6":
                    //  System.out.println("USD a COP");
                    monedaOrigen = "USD";
                    monedaDestino = "COP";
                    break;
                case "7":
                    convertir = false;
                    System.out.println("Volviendo atrás");
                    break;
                default:
                    convertir = false;
                    System.out.println("Por favor ingrese una opción válida");
            }
            if (convertir) {
                tasaConversion = transaccion.obtenerTasa(monedaOrigen, monedaDestino);
                System.out.println("La tasa de conversión de [" + monedaOrigen + "] a [" + monedaDestino + "] es  :"
                        + tasaConversion + "\n");
                System.out.println("[ Ingrese el monto a convertir ] ó [ 7 para salir ]");
                eleccionMonto = scanner.nextLine();
                if (eleccionMonto.equalsIgnoreCase("7")) {
                    System.out.println("Gracias por usar nuestro sistema");
                    break;
                }
                try {
                    double montoOrigen = Double.parseDouble(eleccionMonto);
                    if (montoOrigen >= 0) {
                        Transaccion miTransaccion =
                                new Transaccion(monedaOrigen, monedaDestino, montoOrigen, tasaConversion);

                        System.out.println("*************************************************");
                        System.out.println("Se ha realizado la conversion con exito ");
                        System.out.println(miTransaccion);
                        System.out.println("*************************************************");


                    } else {
                        System.out.println("Ingrese un monto válido");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ingrese un número válido o 'x' para salir");
                }
                System.out.println("Desea  continuar ¿ Si o No?");
                eleccionMoneda = scanner.nextLine();
                if (eleccionMoneda.equalsIgnoreCase("NO")) {
                    System.out.println("Gracias por usar nuestro sistema");
                    break;
                }else if(eleccionMoneda.equalsIgnoreCase("si") ){
                    eleccionMoneda=" ";
                }
            }
        } while (!"7".equalsIgnoreCase(eleccionMoneda));


    }
}
