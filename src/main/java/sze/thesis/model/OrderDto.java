package sze.thesis.model;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import sze.thesis.persistence.entity.Item;
import sze.thesis.persistence.entity.User;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class OrderDto implements Serializable {
    @NotBlank
    private String status;
    @NotBlank
    private LocalDateTime createdAt;
    @NotBlank
    private User user;
    @NotBlank
    private List<Item> items;
}
