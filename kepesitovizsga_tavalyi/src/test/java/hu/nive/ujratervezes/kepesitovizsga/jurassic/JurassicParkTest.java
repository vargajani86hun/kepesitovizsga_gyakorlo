package hu.nive.ujratervezes.kepesitovizsga.jurassic;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mariadb.jdbc.MariaDbDataSource;

import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JurassicParkTest {


    private JurassicPark jurassicPark;

    @BeforeEach
    void init() throws SQLException {
        MariaDbDataSource dataSource;
        dataSource = new MariaDbDataSource();
        dataSource.setUrl("jdbc:mariadb://localhost:3306/jurassic_park?useUnicode=true");
        dataSource.setUser("root");
        dataSource.setPassword("Jani1234");

        Flyway flyway = Flyway.configure().dataSource(dataSource).load();

        flyway.clean();
        flyway.migrate();

        jurassicPark = new JurassicPark(dataSource);

    }


    @Test
    void test_check() {
        assertEquals(List.of("Hypsilophodontida", "Maiasaurus", "Velociraptor"), jurassicPark.checkOverpopulation());
    }


}