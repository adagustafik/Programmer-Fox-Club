package com.gfa.week21programmerfoxclubmysql.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Action {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDateTime added = LocalDateTime.now();
    private String text;

    @ManyToOne
    private Fox fox;

    public Action(Fox fox, Drink drink) {
        this.fox = fox;
        text = added.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                " : Drink has been changed to: " + drink.toString().toLowerCase();
    }

    public Action(Fox fox, Food food) {
        this.fox = fox;
        text = added.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                " : Food has been changed to: " + food.toString().toLowerCase();
    }

    public Action(Fox fox, Trick trick) {
        this.fox = fox;
        text = added.format(DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM)) +
                " : Learned to: " + trick.text.toLowerCase();
    }

    @Override
    public String toString() {
        return text;
    }
}
