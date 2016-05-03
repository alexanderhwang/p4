package models;

import javax.persistence.*;

@Entity
public class Value {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public String id;

    public String valData;

    public String getData()
    {
        return this.valData;
    }

}
