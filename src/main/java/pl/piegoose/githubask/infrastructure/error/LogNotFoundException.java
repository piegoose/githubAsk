package pl.piegoose.githubask.infrastructure.error;

public class LogNotFoundException extends RuntimeException {

    public LogNotFoundException(String message){
        super(message);
    }
}
