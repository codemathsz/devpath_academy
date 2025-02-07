package br.com.codemathsz.dev_path_academy.exceptions;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    private final MessageSource messageSource;

    public ExceptionHandlerController(MessageSource message){
        this.messageSource = message;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageResponseDTO>> handleExceptionMethodArgumentNotValidException(MethodArgumentNotValidException e){
        List<ErrorMessageResponseDTO> dto = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(err -> {
            String message = this.messageSource.getMessage(err, LocaleContextHolder.getLocale());
            dto.add(new ErrorMessageResponseDTO(message, err.getField()));
        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CourseNotFoundException.class)
    public ResponseEntity<ErrorMessageResponseDTO> handleExceptionCourseNotFound(CourseNotFoundException e){
        var responseBody = ErrorMessageResponseDTO.builder()
                .message(e.getMessage())
                .field("Course id")
                .build();

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<ErrorMessageResponseDTO> handleExceptionCategoryNotFound(CategoryNotFoundException e){
        var responseBody = ErrorMessageResponseDTO.builder()
                .message(e.getMessage())
                .field("categoryId")
                .build();

        return new ResponseEntity<>(responseBody, HttpStatus.BAD_REQUEST);
    }
}
