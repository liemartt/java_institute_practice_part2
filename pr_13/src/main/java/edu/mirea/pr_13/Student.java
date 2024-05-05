package edu.mirea.pr_13;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
public class Student {
    @Value("${program.student.name}")
    private String name;
    @Value("${program.student.last_name}")
    private String lastName;
    @Value("${program.student.group}")
    private String group;
    @PostConstruct
    public void init(){
        System.out.println(name+" "+lastName+" "+group);
    }
}
