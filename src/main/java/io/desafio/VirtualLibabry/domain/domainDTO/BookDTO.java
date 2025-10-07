package io.desafio.VirtualLibabry.domainDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.OffsetDateTime;
import java.time.Year;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {

    @NotBlank (message = "The title is necessary")
    @Id
    String idTitle;

    @NotBlank(message = "The author is necessary")
    String author;

    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    @PastOrPresent
    @NotNull
    Year releaseYear;
}
