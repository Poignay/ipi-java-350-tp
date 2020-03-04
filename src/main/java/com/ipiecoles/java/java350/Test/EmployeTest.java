package com.ipiecoles.java.java350.Test;

import com.ipiecoles.java.java350.model.Employe;
import com.ipiecoles.java.java350.model.Entreprise;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class EmployeTest {

    @Test
    //Embauché en 2020, on est en 2020 : 0 an anciente
    public void testNombrezAnneeAnceinneteNow(){
        //Given
        LocalDate now = LocalDate.now();
        Employe employe = new Employe();
        employe.setDateEmbauche(now);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }

    @Test
    //Embauché en 2019, on est en 2020 : 1 an anciente
    public void testNombrezAnneeAnceinneteNMoins1(){
        //Given
        LocalDate nMoins1 = LocalDate.now().minusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nMoins1);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(1);
    }

    @Test
    //Embauché en 2021, on est en 2020 : -1 an anciente
    public void testNombrezAnneeAnceinneteNPlus1(){
        //Given
        LocalDate nPlus1 = LocalDate.now().plusYears(1);
        Employe employe = new Employe();
        employe.setDateEmbauche(nPlus1);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(-1);
    }

    @Test
    //Embauché en null, on est en 2020 : null an anciente
    public void testNombrezAnneeAnceinneteNull(){
        //Given
        LocalDate nul = null;
        Employe employe = new Employe();
        employe.setDateEmbauche(nul);

        //When
        Integer nbAnneesAnciennete = employe.getNombreAnneeAnciennete();

        //Then
        Assertions.assertThat(nbAnneesAnciennete).isEqualTo(0);
    }
}
