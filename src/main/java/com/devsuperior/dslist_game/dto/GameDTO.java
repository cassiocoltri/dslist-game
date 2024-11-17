package com.devsuperior.dslist_game.dto;

import com.devsuperior.dslist_game.entities.Game;
import org.springframework.beans.BeanUtils;

public class GameDTO {
    private Integer id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(){
    }

    public GameDTO(Game entity) {
        //O beans util serve para copiar grande quantidade de campos, caso eles tiverem o mesmo nome da classe na
        // qual está copiando vai dar certo. Vc passa primeiro parâmentro o tipo que vc quer copiar no caso aqui "Game"
        // e usa o "this" para referenciar a chamada. Então tudo vai ser copiado e referenciado.
        BeanUtils.copyProperties(entity, this);

        // Para funcionar isso, a classe TEM que ter todos os get e set.
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public void setPlatforms(String platforms) {
        this.platforms = platforms;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getLongDescription() {
        return longDescription;
    }

    public void setLongDescription(String longDescription) {
        this.longDescription = longDescription;
    }
}
