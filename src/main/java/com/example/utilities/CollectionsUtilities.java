package com.example.utilities;

import com.example.collections.Students;
import com.example.exception.ArrayListNotNullException;

import java.util.ArrayList;


public class CollectionsUtilities {
    // Проверка массива на инициализацию
    public static boolean isArrayListNotNull(ArrayList<Students> inArrayList) throws ArrayListNotNullException {
        if (inArrayList == null) {
            throw new ArrayListNotNullException();
        }
        return true;
    }

}
