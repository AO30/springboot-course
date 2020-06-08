package com.example.springbootexperiments.expriment03.repository;

        import com.example.springbootexperiments.expriment03.entity.Address03;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;
        import org.springframework.stereotype.Repository;

        import java.util.List;

@Repository
public interface Address03Repository extends BaseRepository<Address03, Integer> {
    @Query("from Address02 a where a.detail=:detail")
    List<Address03> list(@Param("detail") String detail);
}
