public class EmptyQueueException extends RuntimeException{

    public EmptyQueueException(){this("A fila esta vazia");}

    public EmptyQueueException(String exception){super(exception);}

}
