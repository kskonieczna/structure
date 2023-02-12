package org.example.structure;

import java.util.stream.Stream;

public class BlockImp implements Block {
    private String color;
    private String material;

    @Override
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.of(this);
    }
}
