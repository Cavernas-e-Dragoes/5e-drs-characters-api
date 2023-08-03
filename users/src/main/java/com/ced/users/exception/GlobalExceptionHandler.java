package com.ced.users.exception;

import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoWriteException;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MongoWriteException.class)
    @ResponseStatus(code = HttpStatus.CONFLICT, value = HttpStatus.CONFLICT)
    protected ResponseEntity<Object> handleDuplicateKeyException(final MongoWriteException ex) {
        logException(ex);
        return ResponseEntity.status(HttpStatus.CONFLICT).body("O email já está registrado.");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
    }

    private static void logException(final Throwable throwable) {
        final var optionalRootThrowable = Optional.ofNullable(ExceptionUtils.getRootCause(throwable));
        if (optionalRootThrowable.isEmpty()) {
            logger.error(throwable.getMessage(), throwable);
        } else {
            logger.error(optionalRootThrowable.get().getMessage(), optionalRootThrowable.get());
        }
    }

}
