package org.example.structure;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CompositeBlockImp extends BlockImp implements CompositeBlock {
    private List<Block> listOfBlocks = new ArrayList<>();

    @Override
    public List<Block> getBlocks() {
        return listOfBlocks;
    }

    public void addBlocks(Block block) {
        listOfBlocks.add(block);
    }

    @Override
    public Stream<Block> toStream() {
        return Stream.concat(
                super.toStream(),
                listOfBlocks.stream().flatMap(Block::toStream)
        );
    }
}
