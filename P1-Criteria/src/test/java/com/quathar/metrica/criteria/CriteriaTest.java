package com.quathar.metrica.criteria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * <h1>Criteria Tests</h1>
 *
 * @since 2023-09-26
 * @version 1.0
 * @author Q
 */
class CriteriaTest {

    // <<-FIELDS->>
    private Criteria<Object> c1;
    private Criteria<Object> c2;
    private Criteria<Object> c3;
    private Criteria<Object> c4;
    private Criteria<Object> c5;
    private Criteria<Object> c6;
    private Criteria<Object> c7;
    private MultipleCriteria c8;

    // <<-TESTS->>
    @BeforeEach
    void setup() {
        this.c1 = (Criteria<Object>)  Criteria.get("EvenNumber");
        this.c2 = (Criteria<Object>)  Criteria.get("Palindrome");
        this.c3 = (Criteria<Object>)  Criteria.get("NotNullList");
        this.c4 = (Criteria<Object>)  Criteria.get("ValueNotRepeated");
        this.c5 = (Criteria<Object>)  Criteria.get("ValidNID");
        this.c6 = (Criteria<Object>)  Criteria.get("ValidLicensePlate");
        this.c7 = (Criteria<Object>)  Criteria.get("ValidDate");
        this.c8 = new MultipleCriteria();
    }

    @Test
    @Tag("UnitTest")
    void testIgualdad() {
        assertEquals   (c1, c1);
        assertEquals   (c1, Criteria.get("EvenNumber"));
        assertEquals   (c2, Criteria.get("Palindrome"));
        assertEquals   (c3, Criteria.get("NotNullList"));
        assertNotEquals(c1, Criteria.get("NotNullList"));
        assertNull     (Criteria.get("noExiste"));
        assertNotEquals(c1, c2);
        assertNotEquals(c1, null);
    }

    @Test
    @Tag("UnitTest")
    void testConsistencia() {
        assertEquals(CriteriaEvenNumber.class.getName(),  c1.toString());
        assertEquals(CriteriaPalindrome.class.getName(),  c2.toString());
        assertEquals(CriteriaNotNullList.class.getName(), c3.toString());
        assertTrue(c1.comply(32));
        c1 = c2;
        assertEquals(c1, c2);
        try {
            c1.comply(32);
            fail();
        } catch (ClassCastException ignored) {
        }
    }

    @Test
    @Tag("UnitTest")
    void testPalindromo() {
        assertTrue(c2.comply("dabale arroz a la zorra el abad"));
        assertFalse(c2.comply("dabale arroz al abad la zorra"));
    }

    @Test
    @Tag("UnitTest")
    void testListaNoNula() {
        List<String> lista = List.of("hola", "que", "tal");
        assertTrue(c3.comply(lista));
        lista = new java.util.ArrayList<>();
        assertTrue(c3.comply(lista));
        for (int i = 0; i < 100; i++)
            lista.add("palabra");
        assertTrue(c3.comply(lista));
        lista.add(30, null);
        assertFalse(c3.comply(lista));
    }

    @Test
    @Tag("UnitTest")
    void testParidad() {
        assertTrue (c1.comply(10));
        assertFalse(c1.comply(5));
        assertFalse(c1.comply(null));
        assertTrue (c1.comply(-50));
    }

    @Test
    void testNoRepetidos() {
        assertTrue (c4.comply("uno"));
        assertTrue (c4.comply("dos"));
        assertFalse(c4.comply("uno"));
        assertTrue (c4.comply("tres"));
        assertFalse(c4.comply("uno"));
        assertTrue (c4.comply(Criteria.get("par")));
        assertFalse(c4.comply(Criteria.get("par")));
    }

    @Test
    void testDNIValido() {
        assertTrue (c5.comply("12345678B"));
        assertTrue (c5.comply("12345678B"));
        assertFalse(c5.comply("A2345678A"));
    }

    @Test
    void testMatriculaValida() {
        assertTrue (c6.comply("1234 ABC"));
        assertFalse(c6.comply("ABCD 123"));
        assertFalse(c6.comply("1234ABC"));
        assertFalse(c6.comply(null));
    }

    @Test
    void testFechaValida() {
        assertTrue (c7.comply("2023-02-14"));
        assertFalse(c7.comply("14-02-2023"));
        assertFalse(c7.comply("2023-13-14"));
    }

    @Test
    void testConjuntoCriterios() {
        c8.setCriteria(List.of(c1, c2));
        assertTrue(c8.comply("2442"));
        assertFalse(c8.comply("2443"));
    }

}
