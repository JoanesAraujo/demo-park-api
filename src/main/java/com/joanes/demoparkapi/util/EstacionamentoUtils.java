package com.joanes.demoparkapi.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EstacionamentoUtils {

    //2024-02-08T15:38:14.019716
    //20240208-152121
    public static String gerarRecibo(){
        LocalDateTime date = LocalDateTime.now();
        String recibo = date.toString().substring(0,19);
        return recibo.replace("", "")
                .replace(":", "")
                .replace("T", "-");
    }
}
