    package com.gymbe.powergymweb.repository;

    import org.springframework.data.jpa.repository.JpaRepository;

    import com.gymbe.powergymweb.Entity.MusculoObjetivo;
    import java.util.Optional;



    public interface MusculoObjetivoRepository extends JpaRepository<MusculoObjetivo, Integer>{
        MusculoObjetivo findByDescripcion(String descripcion);
        Optional<MusculoObjetivo> findById(int id);
    }
