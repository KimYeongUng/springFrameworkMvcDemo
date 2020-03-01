package org.hero.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class sampleDTOList {
    private List<SampleDTO> list;

    public sampleDTOList(){
        list = new ArrayList<>();
    }
}
