package dev.lpa;

// Fxnl interface
// Has single abstract mtd
// Lambdas work here and call operate
// The @ is good practice. Informs future devs, and makes you not break FI rules
@FunctionalInterface
public interface Operation<T> {

    T operate(T value1, T value2);

}
