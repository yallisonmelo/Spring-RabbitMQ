package br.com.yfsmsystem.producer.dto;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class Message  implements Serializable {

    private String body;
    private String email;
}
