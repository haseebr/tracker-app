package co.haseeb.trackerapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "end time cannot be less than start time")
public class BadRangeException extends RuntimeException {
    public BadRangeException(String error) {
        super(error);
    }
}
