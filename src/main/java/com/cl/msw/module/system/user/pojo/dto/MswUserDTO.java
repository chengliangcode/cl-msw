package com.cl.msw.module.system.user.pojo.dto;

import com.cl.msw.component.base.Save;
import com.cl.msw.component.base.Update;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Msw-用户-DTO
 *
 * @author chengliang
 * @date 2020/7/2 10:28
 */
@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
public class MswUserDTO {

    /**
     * id
     */
    @NotNull(groups = {Update.class}, message = "更新时id不能为空")
    private Long id;

    /**
     * 用户名称
     */
    @NotBlank(groups = {Save.class, Update.class}, message = "用户名称不能为空")
    private String username;

    /**
     * 账号
     */
    @NotBlank(groups = {Save.class, Update.class}, message = "账号不能为空")
    private String account;

    /**
     * 密码
     */
    @NotBlank(groups = {Save.class, Update.class}, message = "密码不能为空")
    private String password;

    /**
     * 手机
     */
    @NotBlank(groups = {Save.class, Update.class}, message = "手机不能为空")
    private String phone;

    /**
     * 邮箱
     */
    @NotBlank(groups = {Save.class, Update.class}, message = "邮箱不能为空")
    private String email;

    /**
     * 启用状态 0-禁用 1-启用
     */
    private Integer enableState;

}
