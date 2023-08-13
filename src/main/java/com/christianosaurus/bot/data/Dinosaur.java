package com.christianosaurus.bot.data;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Data
public class Dinosaur {
    private String name;
    private String altName;
    private String cristianName;
    private List<LocalDate> dateRange;

    public static List<Dinosaur> initList() {
        return List.of(
                new Dinosaur("T-rex","ТираннозаврРекс","Тираннорад", List.of(LocalDate.of(1991, 1, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Velociraptor", "Велоцираптор","Велесораптор", List.of(LocalDate.of(1991, 2, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Ankylosaurus", "Анкилозавр", "Анкилозуб", List.of(LocalDate.of(1991, 3, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Pteranodon","Птеранодон","Птерасвет", List.of(LocalDate.of(1991, 4, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Stegosaurus","Стегозавр", "Стегорад", List.of(LocalDate.of(1991, 5, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Spinosaurus","Спинозавр", "Спинорог", List.of(LocalDate.of(1991, 6, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Allosaurus","Аллозавр", "Аллозуб", List.of(LocalDate.of(1991, 7, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Gallimimus","Галлимим", "Диплогрив", List.of(LocalDate.of(1991, 8, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Diplodocus","Диплодок", "Диплогрив", List.of(LocalDate.of(1991, 9, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Ornithomimus","Орнитомим", "Орнибег", List.of(LocalDate.of(1991, 10, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Therizinosaurus","Теризинозавр", "Теризозуб", List.of(LocalDate.of(1991, 11, 23), LocalDate.of(1991, 2, 23))),
                new Dinosaur("Deinonychus","Дейноних", "Дейнонихослав", List.of(LocalDate.of(1991, 12, 23), LocalDate.of(1991, 2, 23)))
        );
    }
}