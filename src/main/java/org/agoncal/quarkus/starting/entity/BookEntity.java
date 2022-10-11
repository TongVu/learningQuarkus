package org.agoncal.quarkus.starting.entity;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookEntity {
    public int id;
    public String title;
    public String author;
    public int yearOfPublication;
    public String genre;
}
