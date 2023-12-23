package ru.practicum.dinner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DinnerConstructor {
    HashMap<String, ArrayList<String>> dinnerConstructor;

    DinnerConstructor(){
        dinnerConstructor = new HashMap<>();
    }

    public void addNewDish(String dishType, String dishName) {
        if (dinnerConstructor.containsKey(dishType)){
            ArrayList<String> dishes = dinnerConstructor.get(dishType);
            dishes.add(dishName);
        } else {
            ArrayList<String> dishes = new ArrayList<>();
            dishes.add(dishName);
            dinnerConstructor.put(dishType, dishes);
        }
    }

    public ArrayList<String> generateRandomSet(ArrayList<String> dishTypes) {
        Random random = new Random();
        ArrayList<String> randomSet = new ArrayList<>();
        for (int i = 0; i < dishTypes.size(); i++) {
            if (dinnerConstructor.containsKey(dishTypes.get(i))) {
                ArrayList<String> dishesOfType = dinnerConstructor.get(dishTypes.get(i));
                randomSet.add(dishesOfType.get(random.nextInt(dishesOfType.size())));
            }
        }
        return randomSet;
    }

    public boolean checkType(String nextItem) {
        return dinnerConstructor.containsKey(nextItem);
    }
}
