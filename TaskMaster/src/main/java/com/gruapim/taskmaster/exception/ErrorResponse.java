package com.gruapim.taskmaster.exception;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

@Schema(description = "Resposta de erro padronizada da API")
public class ErrorResponse {

    private LocalDateTime timestamp;
    private int status;
    private String erro;
    private List<String> mensagens;
    private String caminho;

    public ErrorResponse(int status, String erro, List<String> mensagens, String caminho) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.erro = erro;
        this.mensagens = mensagens;
        this.caminho = caminho;
    }

    public ErrorResponse(int status, String erro, String mensagem, String caminho) {
        this(status, erro, List.of(mensagem), caminho);
    }

    public LocalDateTime getTimestamp() { return timestamp; }
    public int getStatus() { return status; }
    public String getErro() { return erro; }
    public List<String> getMensagens() { return mensagens; }
    public String getCaminho() { return caminho; }
}
