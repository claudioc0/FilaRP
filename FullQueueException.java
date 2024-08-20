public class FullQueueException extends RuntimeException {

    public FullQueueException(){this("A fila está cheia");}

    public FullQueueException(String exception){super(exception);}
}
