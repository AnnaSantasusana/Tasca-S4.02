package cat.itacademy.barcelonactiva.santasusana.anna.s04.t02.n03.model.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Getter
@Setter
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;

}
