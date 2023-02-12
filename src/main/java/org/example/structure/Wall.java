package org.example.structure;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Wall implements Structure {
    private List<Block> blocks;

    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream().flatMap(Block::toStream).filter(block -> block.getColor().equals(color)).findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        return blocks.stream().flatMap(Block::toStream).filter(block -> block.getMaterial().equals(material))
                .collect(Collectors.toList());
    }

    @Override
    public int count() {
        return (int) blocks.stream().flatMap(Block::toStream).count();
    }
}
