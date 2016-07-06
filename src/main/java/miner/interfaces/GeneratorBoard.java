package miner.interfaces;

/**
 * Created by dvig1 on 01.07.2016.
 *
 * An examlpe of using a Functional Interface.
 * The method generate() implemented whith the help of  lambda expression
 */
@FunctionalInterface
public interface GeneratorBoard {
    Cell[][] generate();
}
