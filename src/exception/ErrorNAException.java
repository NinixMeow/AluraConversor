package exception;

public class ErrorNAException extends RuntimeException{

    private String mensaje;

    public ErrorNAException(String mensaje)
    {
        this.mensaje = mensaje;
    }

    @Override
    public String toString() {
        return this.mensaje;
    }

}