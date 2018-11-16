package adt.artc.array;

import adt.artc.List;

public abstract class AbstractArrayList<E> implements List<E> {

    abstract int capacity();

    abstract E get(int index);


}
