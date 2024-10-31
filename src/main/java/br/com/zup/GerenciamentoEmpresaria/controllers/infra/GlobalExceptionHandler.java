package br.com.zup.GerenciamentoEmpresaria.controllers.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Tratamento de erro 400 (Bad Request)
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> handleBadRequest(IllegalArgumentException ex, WebRequest request) {
        return new ResponseEntity<>("Verifique os dados" + ex.getMessage(), HttpStatus.BAD_REQUEST);
    }

    // Tratamento de erro 404 (Not Found)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleNotFound(EntityNotFoundException ex, WebRequest request) {
        return new ResponseEntity<>("Pagina em branco" + ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    // Tratamento de erro 500 (Internal Server Error)
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException(RuntimeException ex, WebRequest request) {
        return new ResponseEntity<>("Ocorreu um erro inesperado: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
