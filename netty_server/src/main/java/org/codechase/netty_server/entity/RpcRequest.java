package org.codechase.netty_server.entity;

import lombok.*;

/**
 * @author codechase <codecx@163.com>
 * Created on 2021-06-14
 */
@AllArgsConstructor
@Getter
@NoArgsConstructor
@Builder
@ToString
public class RpcRequest {
    private String interfaceName;
    private String methodName;
}