package com.gruapim.taskmaster.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.data.domain.Page;

import java.util.List;

@Schema(description = "Resposta paginada genérica")
public class PagedResponseDTO<T> {

    @Schema(description = "Lista de itens da página atual")
    private List<T> conteudo;

    @Schema(description = "Número da página atual (0-indexed)")
    private int numeroPagina;

    @Schema(description = "Tamanho da página")
    private int tamanhoPagina;

    @Schema(description = "Total de elementos")
    private long totalElementos;

    @Schema(description = "Total de páginas")
    private int totalPaginas;

    @Schema(description = "Indica se é a última página")
    private boolean ultima;

    public PagedResponseDTO(Page<T> page) {
        this.conteudo = page.getContent();
        this.numeroPagina = page.getNumber();
        this.tamanhoPagina = page.getSize();
        this.totalElementos = page.getTotalElements();
        this.totalPaginas = page.getTotalPages();
        this.ultima = page.isLast();
    }

    public List<T> getConteudo() { return conteudo; }
    public int getNumeroPagina() { return numeroPagina; }
    public int getTamanhoPagina() { return tamanhoPagina; }
    public long getTotalElementos() { return totalElementos; }
    public int getTotalPaginas() { return totalPaginas; }
    public boolean isUltima() { return ultima; }
}
