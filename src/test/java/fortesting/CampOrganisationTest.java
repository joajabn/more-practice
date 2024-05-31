package fortesting;

import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CampOrganisationTest {
    private CampOrganisation campOrganisation;

    @BeforeAll
    public void setUp(){
        campOrganisation = new CampOrganisation(new ArrayList<>());
    }

    @Test
    public void shouldReturnTransformedName(){
        //given when

        String actual = campOrganisation.transformName("Anna", "Nowak");
        // then
        assertEquals("Anna Nowak", actual);
    }
    @Test
    public void shouldThrowExceptionWhenNullFirstName(){
        //given
        String newStudentFirstName = "Anna";
        String newStudentLastName = null;

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () ->campOrganisation.addStudent(newStudentFirstName, newStudentLastName));
    }

    @Test
    public void shouldThrowExceptionWhenNullLastName(){
        //given
        String newStudentFirstName = null;
        String newStudentLastName = "Nowak";

        //when then
        Assertions.assertThrows(IllegalArgumentException.class, () ->campOrganisation.addStudent(newStudentFirstName, newStudentLastName));
    }
    @Test
    public void shouldReturnFalseWhenStudentAlreadyExists(){
        //given
        CampOrganisation campOrganisation1 = new CampOrganisation(List.of("Anna Nowak"));

        //when
        boolean actual = campOrganisation1.addStudent("Anna", "Nowak");

        //then
        assertFalse(actual);
    }
    @Test
    public void shouldReturnTrueWhenAddingStudent() {
        //given when then
        assertTrue(campOrganisation.addStudent("Anna", "Nowak"));
    }

}