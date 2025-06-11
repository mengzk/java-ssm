package com.item.study.model.dto;

import com.item.study.model.entity.ChatChoice;
import java.util.List;

/**
 * Author: Meng
 * Date: 2024-08-17
 * Desc:
 */
public class RobotDTO {
    public int status; // 0,1 默认1表示nlp有效
    public String error;
    public String msg;
//    public String agent = "third";

    public static RobotDTO nlp(List<ChatChoice.ChoicesDTO> msg) {
        RobotDTO dto = new RobotDTO();
        dto.status = 1;
        return dto;
    }
}
