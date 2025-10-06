package io.desafio.VirtualLibabry.domainDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
public class BookDTO {
    @NotBlank (message = "O título é obrigatório")
    @Id
    String idTitle;

    @NotBlank(message = "O título é obrigatório")
    String author;

    @Min(value = 1500,message = "Year may be higher than 1500")
    @NotNull
    int releaseYear;
}
