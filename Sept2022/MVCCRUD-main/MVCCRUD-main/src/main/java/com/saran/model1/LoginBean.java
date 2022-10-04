package com.saran.model1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
//Model -> POJO +business logic
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginBean {  
private String name,password;  
  
  
public boolean validate(){  
    if(name.equals("saran")&&password.equals("123")){  
        return true;  
    }  
    else{  
        return false;  
    }  
}  
}  