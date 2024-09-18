package org.example.entity;

import jakarta.persistence.*;
import org.example.valueobject.StatusTransporte;

import java.util.Objects;

@Entity
@Table(name = "Transporte")
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String dataEnvio;
    private StatusTransporte status;


    public Transporte() {}

    public Transporte(String dataEnvio) {
        this.dataEnvio = dataEnvio;
        this.status = StatusTransporte.EM_TRANSITO;
    }

    // Método para marcar o transporte como entregue
    public void entregar() {
        if (status == StatusTransporte.EM_TRANSITO) {
            this.status = StatusTransporte.ENTREGUE;
        } else {
            throw new IllegalStateException("O transporte já foi entregue ou não está em trânsito.");
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(String dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public StatusTransporte getStatus() {
        return status;
    }

    public void setStatus(StatusTransporte status) {
        this.status = status;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transporte transporte = (Transporte) o;
        return Objects.equals(id, transporte.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
