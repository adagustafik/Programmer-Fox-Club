package com.gfa.week21programmerfoxclubmysql.model;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Trick {
    YOGA("DO FANCY YOGA POSES"), JAVA("CODE IN JAVA"), MAGIC("DO MAGIC"), SWIMM("SWIMM BUTTERFLY STYLE"),
    ACROBATICS("DO ACROBATIC MOVEMENTS"), HTML("WRITE HTML"), CSS("SOME CSS LOVE");

    public final String text;
}
