package org.example.structure;

import java.util.List;

interface CompositeBlock extends Block {
    List<Block> getBlocks();

}
