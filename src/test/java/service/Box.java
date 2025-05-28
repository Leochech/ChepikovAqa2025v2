package service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Box {
    private int width;
    private int height;
    private int depth;

    @Override
    public String toString() {
        return String.format("Коробка(Ширина=%d, Высота=%d, Глубина=%d)", width, height, depth);
    }
}
