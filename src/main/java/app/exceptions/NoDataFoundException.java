package app.exceptions;

import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoDataFoundException extends RuntimeException {
  public NoDataFoundException(String message, Object... args) {
    super(MessageFormatter.arrayFormat(message, args).getMessage());
  }
}
