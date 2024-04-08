package com.example.dragons.model;

import java.util.List;

public record UserDto(String username,
                      List<HeroesDto> heroes) {
}
