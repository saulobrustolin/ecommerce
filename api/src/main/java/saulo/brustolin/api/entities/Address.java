package saulo.brustolin.api.entities;

import java.util.Objects;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    
    private String id = UUID.randomUUID().toString();

    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String uf;
    private String cep;
    private String obs;
    private Boolean defaultAddress;

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id);
    }
}
