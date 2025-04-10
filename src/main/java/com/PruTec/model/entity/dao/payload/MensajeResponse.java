package com.PruTec.model.entity.dao.payload;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
@Builder
public class MensajeResponse  implements Serializable {

    private String mnesaje;
    private Object object;
    public MensajeResponse(String mensaje, Object object){
        this.mnesaje= mnesaje;
        this.object= object;


}
}