package com.jayschen.dto;

import com.jayschen.entity.Setmeal;
import com.jayschen.entity.SetmealDish;
import lombok.Data;
import java.util.List;

@Data
public class SetmealDto extends Setmeal {

    private List<SetmealDish> setmealDishes;

    private String categoryName;
}
