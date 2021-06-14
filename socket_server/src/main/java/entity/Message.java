package entity;

import lombok.Data;
import lombok.NonNull;

import java.io.Serializable;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-14
 */
@Data
public class Message implements Serializable {
    @NonNull
    private String message;
}
