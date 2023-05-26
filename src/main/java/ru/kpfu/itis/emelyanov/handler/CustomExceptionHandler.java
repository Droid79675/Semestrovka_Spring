package ru.kpfu.itis.emelyanov.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.kpfu.itis.emelyanov.dto.ExceptionDto;
import org.webjars.NotFoundException;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFound(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(ExceptionDto.builder()
                        .message(ex.getMessage())
                        .status(HttpStatus.NOT_FOUND.value())
                        .build());
    }

//    @CustomExceptionHandler(NotFoundException.class)
//    public ResponseEntity<ExceptionDto> handleNotFound(NotFoundException ex) {
//        return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                .body(ExceptionDto.builder()
//                        .message(ex.getMessage())
//                        .status(HttpStatus.NOT_FOUND.value())
//                        .build());
//    }
}
