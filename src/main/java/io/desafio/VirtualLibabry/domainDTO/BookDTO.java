package io.desafio.VirtualLibabry.domainDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Entity
public class BookDTO {
    @NotNull
    @Id
    String title;

    @NotNull
    String author;

    @Min(value = 1500,message = "Year may be higher than 1500")
    @NotNull
    int releaseYear;
}
