package com.gfa.week21programmerfoxclubmysql.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Getter @Setter
@Entity
public class Fox {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Name cannot be empty")
    @NotBlank(message = "Name cannot be empty")
    @Length(min = 3, max = 16, message = "Name should be between 3 and 16 characters long")
    @Pattern(regexp = "[ 0-9a-zA-Z]+", message= "Name can contain only alphanumeric characters")
    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(value = EnumType.STRING)
    private Food food = Food.BREAD;

    @Enumerated(value = EnumType.STRING)
    private Drink drink = Drink.WATER;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Trick.class)
    private Set<Trick> tricks = new HashSet<>();

    @ManyToOne
    private User user;

    @OneToMany(mappedBy = "fox", cascade = CascadeType.ALL)
    private List<Action> actions = new ArrayList<>();

    public Fox(String name, User user) {
        this.name = name;
        this.user = user;
    }
}
