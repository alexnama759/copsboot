package com.example.orm.jpa;
import java.io.Serializable;

public class EntityId<T> extends Serializable {

    T getId();

    String asString();
}
