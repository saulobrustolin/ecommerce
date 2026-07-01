package saulo.brustolin.api.entities;

import java.util.Objects;

import com.github.f4b6a3.ulid.UlidCreator;
import com.mongodb.lang.NonNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    
    private String id = "ADD_" + UlidCreator.getMonotonicUlid().toString().toLowerCase();;

    @NonNull private String street;
    @NonNull private String number;
    @NonNull private String neighborhood;
    @NonNull private String city;
    @NonNull private String uf;
    @NonNull private String cep;
    @NonNull private String obs;

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
