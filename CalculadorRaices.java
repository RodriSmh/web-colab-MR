package metodosNumericos;

import java.util.Scanner;

public class CalculadorRaices {
    // Definimos la función f(x) = -0.0000234(x - 80)^2 + 1.5
    public static double funcion(double x) {
        return -0.0000234 * Math.pow(x - 80, 2) + 1.5;
    }

    // Definimos h(x) = f(x) - 1.35024 para buscar los puntos mínimos (x = 0 y x = 160)
    public static double funcionAncho(double x) {
        return funcion(x) - 1.35024;
    }

    // Definimos la derivada f'(x)
    public static double derivadaFuncion(double x) {
        return -0.0000468 * (x - 80);
    }

   

    // Método de la Secante (Proceso de cálculo A)
    public static void procesoSecante(double valorInicial1, double valorInicial2, double errorDeseado, int iteracionesMaximas) {
        double valorAnterior = valorInicial1; // Punto anterior
        double valorActual = valorInicial2; // Punto actual
        int iteracion = 1;

        System.out.println("---------------------------------------------------");
        System.out.println("Instituto Tecnológico de Culiacán, Ing. En Sistemas Computacionales");
        System.out.println("Lugo Lopez Ulises");
        System.out.println("Solución de Ecuaciones: 14:00-15:00 horas.");
        System.out.println("Este programa ejecuta la solucion de problemas utilizando los procesos logicos de calculo de Raices de una ecuacion con diversos metodos numericos.");
        System.out.println("Pregunta del problema:¿Cual es el ancho de la cancha?");
        System.out.println("---------------------------------------------------");

        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n", 
            "No.", "X1", "F(x1)", "F'(x1)", "X2", "F(x2)");

        while (iteracion <= iteracionesMaximas) {
            double valorFuncionAnterior = funcionAncho(valorAnterior);
            double valorFuncionActual = funcionAncho(valorActual);

            if (Math.abs(valorFuncionActual - valorFuncionAnterior) < 1e-10) {
                System.out.println("Diferencia entre f(x) muy pequeña, no se puede continuar.");
                break;
            }

            // Fórmula de la Secante: x2 = x1 - f(x1) * (x1 - x0) / (f(x1) - f(x0))
            double valorNuevo = valorActual - valorFuncionActual * (valorActual - valorAnterior) / (valorFuncionActual - valorFuncionAnterior);
            double valorFuncionNuevo = funcionAncho(valorNuevo);

            // Para la Secante, F'(x1) no se usa, pero mantenemos la columna para coincidir con la tabla
            System.out.printf("%-5d %-15.6f %-15.6f %-15s %-15.6f %-15.6f%n", 
                iteracion, valorAnterior, valorFuncionAnterior, "N/A", valorActual, valorNuevo);

            if (Math.abs(valorFuncionNuevo) < errorDeseado) {
                System.out.println("---------------------------------------------------");
                System.out.printf("El ancho de la cancha es de: %.6f pies %n", valorNuevo);
                break;
            }

            valorAnterior = valorActual;
            valorActual = valorNuevo;
            iteracion++;

            if (iteracion > iteracionesMaximas) {
                System.out.println("Se alcanzó el número máximo de iteraciones.");
                break;
            }
        }
    }
    // Método de Newton-Raphson (Proceso de cálculo B)
    public static void procesoNewtonRaphson(double valorInicial, double errorDeseado, int iteracionesMaximas) {
        double valorActual = valorInicial;
        int iteracion = 1;

        System.out.println("---------------------------------------------------");
        System.out.println("Instituto Tecnológico de Culiacán, Ing. En Sistemas Computacionales");
        System.out.println("Lugo Lopez Ulises");
        System.out.println("Solución de Ecuaciones: 14:00-15:00 horas.");
        System.out.println("Este programa ejecuta la solucion de problemas utilizando los procesos logicos de calculo de Raices de una ecuacion con diversos metodos numericos.");
        System.out.println("Pregunta del problema:¿Cual es el ancho de la cancha?");
        System.out.println("---------------------------------------------------");

        System.out.println("---------------------------------------------------");
        System.out.printf("%-5s %-15s %-15s %-15s %-15s %-15s%n", 
            "No.", "X1", "F(x1)", "F'(x1)", "X2", "F(x2)");

        while (iteracion <= iteracionesMaximas) {
            double valorFuncion = funcionAncho(valorActual);
            double derivada = derivadaFuncion(valorActual);

            if (Math.abs(derivada) < 1e-10) {
                System.out.println("Derivada cercana a cero, no se puede continuar.");
                break;
            }

            double valorNuevo = valorActual - valorFuncion / derivada;
            double valorFuncionNuevo = funcionAncho(valorNuevo);

            System.out.printf("%-5d %-15.6f %-15.6f %-15.6f %-15.6f %-15.6f%n", 
                iteracion, valorActual, valorFuncion, derivada, valorNuevo, valorFuncionNuevo);

            if (Math.abs(valorFuncionNuevo) < errorDeseado) {
                System.out.println("---------------------------------------------------");
                System.out.printf("El ancho de la cancha es de: %.6f pies %n", valorNuevo);
                break;
            }

            valorActual = valorNuevo;
            iteracion++;

            if (iteracion > iteracionesMaximas) {
                System.out.println("Se alcanzó el número máximo de iteraciones.");
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner lector = new Scanner(System.in);

        // Inicio y Pantalla Inicial (según el diagrama)
        System.out.println("Instituto Tecnológico de Culiacán, Ing. En Sistemas Computacionales");
        System.out.println("Lugo Lopez Ulises");
        System.out.println("Solución de Ecuaciones: 14:00-15:00 horas.");
        System.out.println("Este programa ejecuta la solucion de problemas utilizando los procesos logicos de calculo de Raices de una ecuacion con diversos metodos numericos.");
        System.out.println("Pregunta del problema:¿Cual es el ancho de la cancha?");
        System.out.println("---------------------------------------------------");

        // Pregunta: Raíces de una Ecuación
        System.out.println("Cálculo del ancho de la cancha de fútbol usando f(x):");
        System.out.println("1. Método de la Secante");
        System.out.println("2. Método de Newton-Raphson");
        System.out.println("10. FIN");
        System.out.print("Selecciona una opción (1, 2 o 10): ");

        int opcion = lector.nextInt();

        // Opciones según el diagrama (Opción 1, 2 o 10)
        switch (opcion) {
            case 1:
                // Proceso de cálculo A (Secante, opción 1)
                System.out.print("Ingresa el primer valor inicial (x estimado en pies, entre 50 y 250) para la Secante: ");
                double valorInicial1Secante = lector.nextDouble();
                System.out.print("Ingresa el segundo valor inicial (x estimado en pies, entre 50 y 250) para la Secante: ");
                double valorInicial2Secante = lector.nextDouble();
                
                // Preguntar al usuario el error y el número total de cálculos
                System.out.print("Ingresa el error deseado (por ejemplo, 0.00001 como especifica el problema): ");
                double errorDeseado = lector.nextDouble();
                System.out.print("Ingresa el número total de cálculos (iteraciones máximas, máximo 100 como especifica el problema): ");
                int iteracionesMaximas = lector.nextInt();
                
                // Verificar que el error y las iteraciones estén dentro de los límites del problema
                if (errorDeseado > 0.00001 || iteracionesMaximas > 100) {
                    System.out.println("Advertencia: El error debe ser <= 0.00001 y las iteraciones <= 100 según el problema. Usando valores predeterminados.");
                    errorDeseado = 0.00001;
                    iteracionesMaximas = 100;
                }
                
                procesoSecante(valorInicial1Secante, valorInicial2Secante, errorDeseado, iteracionesMaximas);
                break;
            case 2:
                // Proceso de cálculo B (Newton-Raphson, opción 2)
                System.out.print("Ingresa el valor inicial (x estimado en pies, entre 50 y 250) para Newton-Raphson: ");
                double valorInicialNewton = lector.nextDouble();
                
                // Preguntar al usuario el error y el número total de cálculos
                System.out.print("Ingresa el error deseado (por ejemplo, 0.00001 como especifica el problema): ");
                errorDeseado = lector.nextDouble();
                System.out.print("Ingresa el número total de cálculos (iteraciones máximas, máximo 100 como especifica el problema): ");
                iteracionesMaximas = lector.nextInt();
                
                // Verificar que el error y las iteraciones estén dentro de los límites del problema
                if (errorDeseado > 0.00001 || iteracionesMaximas > 100) {
                    System.out.println("Advertencia: El error debe ser <= 0.00001 y las iteraciones <= 100 según el problema. Usando valores predeterminados.");
                    errorDeseado = 0.00001;
                    iteracionesMaximas = 100;
                }
                
                procesoNewtonRaphson(valorInicialNewton, errorDeseado, iteracionesMaximas);
                break;
            case 10:
                // Opción FIN: Termina el programa inmediatamente
                System.out.println("Fin");
                lector.close();
                return;
            default:
                System.out.println("Opción no válida. Por favor, selecciona 1, 2 o 10.");
                lector.close();
                return; // Termina el programa si la opción no es válida
        }

        // Fin (según el diagrama, solo si no se seleccionó la opción 10)
        System.out.println("Fin");
        lector.close();
    }
}