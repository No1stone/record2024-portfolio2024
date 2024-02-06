package com.origemite.authserver.mq.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Field {

    private String type;
    private boolean optional;
    private String field;



}
