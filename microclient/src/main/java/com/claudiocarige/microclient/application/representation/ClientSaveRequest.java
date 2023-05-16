package com.claudiocarige.microclient.application.representation;

import com.claudiocarige.microclient.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {

    private String cpf;
    private String name;
    private Integer age;

    public Client toModel(){
        return new Client(cpf, name, age);
    }
}
