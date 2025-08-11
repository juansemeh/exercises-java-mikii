import java.util.Scanner;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(String titular, String numeroCuenta, double saldoInicial) {
        if (titular == null || titular.trim().isEmpty()) {
            throw new IllegalArgumentException("El titular no puede estar vacío");
        }
        if (numeroCuenta == null || numeroCuenta.trim().isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede estar vacío");
        }
        if (saldoInicial < 0) {
            throw new IllegalArgumentException("El saldo inicial no puede ser negativo");
        }
        this.titular = titular.trim();
        this.numeroCuenta = numeroCuenta.trim();
        this.saldo = saldoInicial;
    }

    public String getTitular() {
        return titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            saldo += cantidad;
            System.out.println("Depósito exitoso. Nuevo saldo: $" + saldo);
        } else {
            System.out.println("Error: La cantidad a depositar debe ser positiva.");
        }
    }

    public boolean retirar(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser positiva.");
            return false;
        }
        if (Double.isNaN(cantidad) || Double.isInfinite(cantidad)) {
            System.out.println("Error: Cantidad inválida.");
            return false;
        }
        if (cantidad > saldo) {
            System.out.println("Error: Fondos insuficientes. Saldo actual: $" + String.format("%.2f", saldo));
            return false;
        }
        saldo -= cantidad;
        System.out.println("Retiro exitoso. Nuevo saldo: $" + String.format("%.2f", saldo));
        return true;
    }

    public boolean transferir(CuentaBancaria cuentaDestino, double cantidad) {
        if (cantidad <= 0) {
            System.out.println("Error: La cantidad debe ser positiva.");
            return false;
        }
        if (Double.isNaN(cantidad) || Double.isInfinite(cantidad)) {
            System.out.println("Error: Cantidad inválida.");
            return false;
        }
        if (cuentaDestino == null) {
            System.out.println("Error: Cuenta destino no válida.");
            return false;
        }
        if (cuentaDestino == this) {
            System.out.println("Error: No puede transferir a la misma cuenta.");
            return false;
        }
        if (cantidad > saldo) {
            System.out.println("Error: Fondos insuficientes. Saldo actual: $" + String.format("%.2f", saldo));
            return false;
        }
        
        this.retirar(cantidad);
        cuentaDestino.depositar(cantidad);
        System.out.println("Transferencia exitosa a " + cuentaDestino.getTitular());
        return true;
    }

    public void mostrarDatos() {
        System.out.println("\n=== DATOS DE LA CUENTA ===");
        System.out.println("Titular: " + titular);
        System.out.println("Número de cuenta: " + numeroCuenta);
        System.out.println("Saldo actual: $" + saldo);
        System.out.println("==========================\n");
    }

    private static int getValidInt(Scanner scanner, int min, int max, String prompt) {
        int number = 0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextInt()) {
                    number = scanner.nextInt();
                    if (number >= min && number <= max) {
                        valid = true;
                    } else {
                        System.out.println("Error: Por favor ingrese un número entre " + min + " y " + max + ".");
                    }
                } else {
                    System.out.println("Error: Por favor ingrese solo números enteros.");
                    scanner.next(); // clear invalid input
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Solo se permiten números.");
                scanner.next(); // clear invalid input
            }
        }
        return number;
    }

    private static double getValidDouble(Scanner scanner, String prompt) {
        double number = 0.0;
        boolean valid = false;
        
        while (!valid) {
            System.out.print(prompt);
            try {
                if (scanner.hasNextDouble()) {
                    number = scanner.nextDouble();
                    if (number > 0) {
                        valid = true;
                    } else {
                        System.out.println("Error: Por favor ingrese un número positivo.");
                    }
                } else {
                    System.out.println("Error: Por favor ingrese solo números (decimales permitidos).");
                    scanner.next(); // clear invalid input
                }
            } catch (Exception e) {
                System.out.println("Error: Entrada inválida. Solo se permiten números.");
                scanner.next(); // clear invalid input
            }
        }
        return number;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        CuentaBancaria cuenta1 = new CuentaBancaria("Juan Pérez", "1234567890", 1000.0);
        CuentaBancaria cuenta2 = new CuentaBancaria("María García", "0987654321", 500.0);
        
        int opcion;
        
        do {
            System.out.println("\n=== MENÚ DE CUENTA BANCARIA ===");
            System.out.println("1. Mostrar datos de cuenta");
            System.out.println("2. Depositar dinero");
            System.out.println("3. Retirar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = getValidInt(scanner, 1, 5, "");
            
            switch (opcion) {
                case 1:
                    int cuentaMostrar = getValidInt(scanner, 1, 2, "¿Qué cuenta desea ver? (1-Juan, 2-María): ");
                    if (cuentaMostrar == 1) {
                        cuenta1.mostrarDatos();
                    } else if (cuentaMostrar == 2) {
                        cuenta2.mostrarDatos();
                    } else {
                        System.out.println("Cuenta no válida.");
                    }
                    break;
                    
                case 2:
                    System.out.print("¿En qué cuenta desea depositar? (1-Juan, 2-María): ");
                    int cuentaDeposito = scanner.nextInt();
                    System.out.print("Ingrese la cantidad a depositar: $");
                    double cantidadDeposito = scanner.nextDouble();
                    
                    if (cuentaDeposito == 1) {
                        cuenta1.depositar(cantidadDeposito);
                    } else if (cuentaDeposito == 2) {
                        cuenta2.depositar(cantidadDeposito);
                    } else {
                        System.out.println("Cuenta no válida.");
                    }
                    break;
                    
                case 3:
                    System.out.print("¿De qué cuenta desea retirar? (1-Juan, 2-María): ");
                    int cuentaRetiro = scanner.nextInt();
                    System.out.print("Ingrese la cantidad a retirar: $");
                    double cantidadRetiro = scanner.nextDouble();
                    
                    if (cuentaRetiro == 1) {
                        cuenta1.retirar(cantidadRetiro);
                    } else if (cuentaRetiro == 2) {
                        cuenta2.retirar(cantidadRetiro);
                    } else {
                        System.out.println("Cuenta no válida.");
                    }
                    break;
                    
                case 4:
                    int cuentaOrigen = getValidInt(scanner, 1, 2, "¿Desde qué cuenta desea transferir? (1-Juan, 2-María): ");
                    int cuentaDestino = getValidInt(scanner, 1, 2, "¿A qué cuenta desea transferir? (1-Juan, 2-María): ");
                    double cantidadTransferir = getValidDouble(scanner, "Ingrese la cantidad a transferir: $");
                    
                    if (cuentaOrigen == cuentaDestino) {
                        System.out.println("Error: No puede transferir a la misma cuenta.");
                        break;
                    }
                    
                    if (cuentaOrigen == 1 && cuentaDestino == 2) {
                        cuenta1.transferir(cuenta2, cantidadTransferir);
                    } else if (cuentaOrigen == 2 && cuentaDestino == 1) {
                        cuenta2.transferir(cuenta1, cantidadTransferir);
                    } else {
                        System.out.println("Cuenta no válida.");
                    }
                    break;
                    
                case 5:
                    System.out.println("Gracias por usar el sistema bancario.");
                    break;
                    
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            
        } while (opcion != 5);
        
        scanner.close();
    }
}
