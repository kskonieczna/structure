package org.example.structure;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WallTest {

    @Test
    void shouldReturnAnyBlockByColor() {
        //given
        List<Block> blocks = createListOfBlocks();
        //when
        Wall wall = new Wall();
        wall.setBlocks(blocks);
        Optional<Block> output = wall.findBlockByColor("red");
        //then
        assert (output).isPresent();
        Block blockOutput = output.get();
        assertThat(blockOutput.getColor()).isEqualTo("red");
    }

    @Test
    void shouldReturnAllBlocksByMaterial() {
        //given
        List<Block> blocks = createListOfBlocks();
        //when
        Wall wall = new Wall();
        wall.setBlocks(blocks);
        List<Block> output = wall.findBlocksByMaterial("cement");
        //then
        assertEquals(3, output.size());
    }

    @Test
    void shouldCountAllBlocksInStructure() {
        //given
        List<Block> blocks = createListOfBlocks();
        //when
        Wall wall = new Wall();
        wall.setBlocks(blocks);
        Integer output = wall.count();
        //then
        assertThat(output).isEqualTo(4);
    }

    private List<Block> createListOfBlocks() {
        BlockImp block1 = new BlockImp();
        block1.setColor("black");
        block1.setMaterial("wood");
        BlockImp block2 = new BlockImp();
        block2.setColor("red");
        block2.setMaterial("cement");
        CompositeBlockImp block3 = new CompositeBlockImp();
        block3.setColor("black");
        block3.setMaterial("cement");
        block3.addBlocks(block2);
        List<Block> blocks1 = new ArrayList<>();
        blocks1.add(block1);
        blocks1.add(block2);
        blocks1.add(block3);

        return blocks1;
    }
}
