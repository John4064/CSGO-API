package tech.parkhurst.restapi.transformers;

import tech.parkhurst.restapi.entities.HltvMatch;
import tech.parkhurst.restapi.entities.HltvMatchDTO;

public class HltvMatchTransformer {


    private HltvMatchTransformer() {
        throw new IllegalStateException("Transformer util class");
    }

    public static HltvMatch HltvMatchDTOtoHltvMatch(HltvMatchDTO hmDTO){
        HltvMatch hm = new HltvMatch();
        return hm;
    }
}
