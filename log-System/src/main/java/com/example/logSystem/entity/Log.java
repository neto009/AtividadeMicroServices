package com.example.logSystem.entity;

import com.example.logSystem.utils.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "log")
public class Log {

    @Id
    private String id;
    private Action action;
    private String order_id;
    private Integer quantity;
    private Date data;
    private Double total_price;
    private String product_name;
    private Integer product_code;
    private String manufacture;
    private Double price;
    private String user;
    private String cpf;

}
