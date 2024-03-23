package com.example.dragons.model;

import java.util.List;

public record RaspunsDto(String text,
                         List<String> alegeri,
                         List<String> goTo) {
}