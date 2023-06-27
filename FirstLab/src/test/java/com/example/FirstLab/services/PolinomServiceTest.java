package com.example.FirstLab.services;

import com.example.FirstLab.dao.Storage;
import com.example.FirstLab.dao.api.IResultRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PolinomServiceTest {
    private IResultRepository repository;
    private PolinomService polinomService = new PolinomService(new Storage(),repository);

    @Test
    public void testIsPolinom() {
        assertTrue(polinomService.isPolinom("abccba").isPolinom());
        assertTrue(polinomService.isPolinom("12321").isPolinom());
        assertTrue(polinomService.isPolinom("1").isPolinom());
        assertFalse(polinomService.isPolinom("abcdba").isPolinom());
        assertFalse(polinomService.isPolinom("12345").isPolinom());
    }
}