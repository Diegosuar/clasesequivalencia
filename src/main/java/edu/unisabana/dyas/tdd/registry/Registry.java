package edu.unisabana.dyas.tdd.registry;

import java.util.HashSet;
import java.util.Set;

public class Registry {
    // Set para almacenar los IDs de las personas registradas
    private Set<Integer> registeredIds;

    // Constructor para inicializar el conjunto
    public Registry() {
        this.registeredIds = new HashSet<>();
    }

    // Método para registrar un votante
    public RegisterResult registerVoter(Person p) {
        // Verificar si la persona está viva
        if (!p.isAlive()) {
            return RegisterResult.DEAD;
        }

        // Verificar si la persona ya está registrada (duplicada)
        if (isDuplicated(p.getId())) {
            return RegisterResult.DUPLICATED;
        }

        // Verificar si la persona es menor de edad
        if (p.getAge() < 18) {
            return RegisterResult.UNDERAGE;
        }

        // Verificar si la persona tiene una edad válida para votar (18 años o más)
        if (p.getAge() >= 18 && p.getAge() <= 120) {
            // Agregar el ID de la persona registrada al conjunto
            registeredIds.add(p.getId());
            return RegisterResult.VALID;
        }

        // Si no se cumplen las condiciones anteriores, entonces la edad es inválida
        return RegisterResult.INVALID_AGE;
    }

    // Método para verificar si un número de documento ya está registrado
    private boolean isDuplicated(int id) {
        // Verificar si el ID está en el conjunto de IDs registrados
        return registeredIds.contains(id);
    }
}