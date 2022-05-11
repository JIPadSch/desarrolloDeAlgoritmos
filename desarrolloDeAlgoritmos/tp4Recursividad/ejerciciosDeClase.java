package desarrolloDeAlgoritmos.tp4Recursividad;
import java.util.*;
/**
 *
 * @author JuanPadSch
 */
public class ejerciciosDeClase {
    /* Main para invocar los módulos */
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int opcion;
        do{
            System.out.println("--------------------------------------------------");
            System.out.println("1. Calcular factorial");            
            System.out.println("2. Calcular Fibonacci");
            System.out.println("3. Contar iteraciones de un número dentro de otro");
            System.out.println("4. Saber si un numero es primo o no");
            System.out.println("5. Salir del programa");
            System.out.println("--------------------------------------------------");
            opcion=scan.nextInt();
            scan.nextLine();
            menu(opcion);
        }while(opcion!=5);
    }
    /* Menu */
    public static void menu(int opcion){
        Scanner scan = new Scanner(System.in);
        int n;
        switch(opcion){
            case 1:
                do{
                    System.out.println("Ingrese un número para mostrar su factorial: ");
                    n=scan.nextInt();
                    if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
                    scan.nextLine();
                }while (n<1);
                System.out.println("El factorial de "+n+" es :"+factorial(n));
                break;
            case 2:
                do{
                    System.out.println("Ingrese el número que desea ver en Fibonacci: ");
                    n=scan.nextInt();
                    if (n<1) System.out.println("El número ingresado debe ser mayor o igual a 1");
                    scan.nextLine();
                }while(n<1);
                System.out.println("El Fibonacci de "+n+" es: "+fibonacci(n));        
                break;
            case 3:
                    int chequear;
                    System.out.println("Ingrese el numero a revisar: ");
                    n=scan.nextInt();
                    scan.nextLine();
                    System.out.println("Ingrese que numero desea buscar: ");
                    chequear=scan.nextInt();
                    scan.nextLine();
                    System.out.println("El numero "+chequear+" se encuentra "+contarVeces(n,chequear)+" veces en "+n);
                break;
            case 4:
                do{
                    System.out.println("Ingrese un número a verificar si es primo: ");
                    n=scan.nextInt();
                    if (n<=0) System.out.println("El numero no puede ser menor o igual a 0");
                    scan.nextLine();
                } while (n<=0);
                System.out.println("El numero "+n+" ¿Es primo? "+esPrimo(n,n-1));
                break;
            case 5:
                System.out.println("Adios!");
                break;
            default:
                System.out.println("ERROR: Opcion invalida. Volviendo al menu");
                break;
        }
    }
    /* Método para sacar factorial */
    public static int factorial(int n){
        int resultado;
        if (n==1){
            resultado=1;
        } else{
            resultado=n*factorial(n-1);
        }
        return resultado;
    }
    /* Metodo para sacar Fibonacci */
    public static int fibonacci(int n){
        int resultado;
        if(n==0){
            resultado=0;
        }else if(n==1){
            resultado=1;
        } else {
            resultado=fibonacci(n-2)+fibonacci(n-1);
        }
        return resultado;
    }
    /* Metodo para contar las iteraciones dentro de un numero */
    public static int contarVeces(int num, int chequear){
        int contadorT=0;
        if (num!=0){
            if(num%10==chequear){
                contadorT=contarVeces(num/10,chequear)+1;
            } else{
                contadorT=contarVeces(num/10,chequear);
            }
        }
        return contadorT;
    }
    /* Hacer una funcion recursiva para saber si un numero es primo */
    public static boolean esPrimo(int aVerificar, int num){
        boolean primoBoolean=false;
        if(aVerificar!=1 || (aVerificar%2)==0){ //Verificamos las excepciones
            if (num==1){ //Caso base, si llegas al final, es primo
                primoBoolean=true;
            } else{ //Caso general
                if ((aVerificar%num) != 0){ //Si no es divisible por el numero, entramos en recursividad
                    primoBoolean=esPrimo(aVerificar,num-1);
                } else{ //Si es divisible por un numero que no sea si mismo, entonces no es primo
                    primoBoolean=false;
                }
            }
        } else{
            primoBoolean=false; //Excepciones, si aVerificar es 1 o es par, no es primo
        }
        return primoBoolean;
    }
}