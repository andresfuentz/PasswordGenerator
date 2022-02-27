package javaapplicationpassword;

public class Password {
    private static final int LONGITUD = 8;
    
    private int longitud;
    private String contrasena;

    public Password() {
        this(LONGITUD);
    }

    public Password(int longitud) {
        this.longitud = longitud >= LONGITUD ? longitud:LONGITUD;
        contrasena = generarPassword();
    }

    @Override
    public String toString() {
        return String.format("%s (%d)", contrasena , longitud);
    }
    
    public int getLongitud() {
        return longitud;
    }

    public String getContrasena() {
        return contrasena;
    }

    private String generarPassword() {
        String cadena;
        do {
            cadena = "";
            for (int i = 0; i < longitud; i++) {
                int rndm = enteroRandom(1, 100);
                if (rndm <= 10) {
                    cadena += caracterRandom('a', 'z');
                } else {
                    if (rndm <= 20) {
                        cadena += caracterRandom('A', 'Z');
                    } else {
                        cadena += caracterRandom('0', '9');
                    }
                }
            }
        } while (!esFuerte(cadena));
        return cadena;
    }

    private static char caracterRandom(char d,char h){
        return (char) (Math.random() * (h-d+1) + d);
    }
    
    private static int enteroRandom(int d, int h) {
        return (int) (Math.random() * (h-d+1) + d);
    }

    private boolean esFuerte(String cadena) {
        int mayus = 0;
        int minus = 0;
        int digit = 0;
        
        for (int i = 0; i < longitud; i++) {
            if (esMayuscula(cadena.charAt(i))) {
                mayus++;
            }
            if (esMinuscula(cadena.charAt(i))) {
                minus++;
            }
            if (esDigito(cadena.charAt(i))) {
                digit++;
            }
        }
        return mayus >= 2 && minus >= 1 && digit >= 5;
    }
    
    private boolean esMayuscula(int c) {
        return c >= 'A' && c <= 'Z';
    }
    
    private boolean esMinuscula(int c) {
        return c>='a' && c<='z';
    }    

    private boolean esDigito(int c) {
        return c>='0' && c<='z';
    }
    
}
