package service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BoxesFilter {
    public List<Box> boxesFilterByWidth(List<Box> boxes, int width) {
        List<Box> filteredBoxes = new ArrayList<>();
        Iterator<Box> boxIterator = boxes.iterator();
        while (boxIterator.hasNext()) {
            Box box = boxIterator.next();
            if (box.getWidth() > width) {
                filteredBoxes.add(box);
                boxIterator.remove();
            }
        }
        return filteredBoxes;
    }
}
